package testBoard.inform.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import file.FileUpload;
import testBoard.inform.dto.InformDTO;
import testBoard.inform.dto.InformPageDTO;
import testBoard.inform.service.InformService;





// http://localhost:8090

@Controller
public class InformController {
	
	private final InformService informService;
	private InformPageDTO informpageDto;
	
	@Autowired
	public InformController(InformService informService) {
		this.informService = informService;
		
	}	
	
	// 게시물 목록 + 페이징 + 검색
	@GetMapping("/inform")
	   public String inform(InformDTO informDto, @ModelAttribute("pv") InformPageDTO pv, Model model) {

	      int totalRecord = informService.countProcess(pv);

	      InformPageDTO pdto = new InformPageDTO(pv.getCurrentPage(), totalRecord, pv.getSearchKey(), pv.getSearchWord());

	      List<InformDTO> inform_list = informService.listProcess(pdto);
	         
	      if (totalRecord >= 1) {
	         if (pv.getCurrentPage() == 0)
	            pv.setCurrentPage(1);

	         this.informpageDto = new InformPageDTO(pv.getCurrentPage(), totalRecord, pv.getSearchKey(), pv.getSearchWord());
	         pv.setStartRow(this.informpageDto.getStartRow());
	         pv.setEndRow(this.informpageDto.getEndRow());
	         model.addAttribute("pv", this.informpageDto);
	         model.addAttribute("list", inform_list);
	         model.addAttribute("searchWord", pv.getSearchWord());
	      }
	      return "inform/inform";
	   }
		
	// 게시물 작성 화면
	@RequestMapping(value = "/informWrite", method = RequestMethod.GET)
	public ModelAndView writeView(@ModelAttribute("InformDTO") InformDTO informDto, ModelAndView mav) {
		mav.setViewName("inform/write");
		return mav;

	}

	// 게시물 작성
	@RequestMapping(value = "/informWrite", method = RequestMethod.POST)
	public String postWrite(InformDTO informDto, HttpServletRequest request) {
		
		MultipartFile file = informDto.getFilename();

		if (!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, request);
			informDto.setUpload(random + "_" + file.getOriginalFilename());
		}

		informService.writeProcess(informDto);

		return "redirect:/inform?currentPage=1";
	}

	// 게시물 조회
	@RequestMapping(value = "/noticeReadView", method = RequestMethod.GET)
	public String read(InformDTO informDto, Model model) {
		
		model.addAttribute("read", informService.readProcess(informDto.getNotice_code()));
			
		return "inform/readView";

	}

	@GetMapping("/noticeUpdateView")
	public String updateView(InformDTO informDto, HttpServletRequest request, Model model) {
		model.addAttribute("update", informService.readProcess(informDto.getNotice_code()));

		return "inform/updateView";
	}

	// 게시물 수정 post
	@RequestMapping(value = "/noticeUpdate", method = RequestMethod.POST)
	public String update(InformDTO informDto, HttpServletRequest request) {
		MultipartFile file = informDto.getFilename();

	      if (!file.isEmpty()) {
	         UUID random = FileUpload.saveCopyFile(file, request);
	         informDto.setUpload(random + "_" + file.getOriginalFilename());
	      }

		informService.updateProcess(informDto, FileUpload.urlPath(request));

		return "redirect:/inform?currentPage=1"; // 인폼으로 리다이렉트
	}

	// 게시물 삭제
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.POST)
	public String delete(InformDTO informDto, HttpServletRequest request) {
		informService.deleteProcess(informDto.getNotice_code(), FileUpload.urlPath(request));

		return "redirect:/inform?currentPage=1";
	}
	
	// 첨부파일 다운로드
	@GetMapping("/noticeContentdownload")
	public ModelAndView downloadExecute(int notice_code, ModelAndView mav) {

		mav.addObject("notice_code", notice_code);
		mav.addObject("fileSelectProcess", informService.fileSelectProcess(notice_code));
		mav.setViewName("download");

		return mav;

	}
	
	@GetMapping("/inform/write")
	public String writePage() {
		return "inform/write";
	}
		
}


