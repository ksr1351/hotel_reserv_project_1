package testBoard.free.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import file.FileUpload;
import testBoard.free.dto.BoardFreeDTO;
import testBoard.free.dto.BoardFreePageDTO;
import testBoard.free.dto.BoardFreeReplyDTO;
import testBoard.free.service.BoardFreeReplyService;
import testBoard.free.service.BoardFreeService;

//http://localhost:8090/

@Controller
public class BoardFreeController {

	private final BoardFreeService service;
	private BoardFreePageDTO pdto;
	private final BoardFreeReplyService replyService;

	@Autowired
	public BoardFreeController(BoardFreeService service, BoardFreeReplyService replyService) {
		this.service = service;
		this.replyService = replyService;
	}

	// 게시물 목록 조회 + 페이징 + 검색
	@GetMapping("/board")
	public String mainPage2(BoardFreeDTO boardFreeDTO, @ModelAttribute("pv") BoardFreePageDTO pv, Model model) {

		int totalRecord = service.countProcess(pv);

		BoardFreePageDTO FreeDTO = new BoardFreePageDTO(pv.getCurrentPage(), totalRecord, pv.getSearchKey(),
				pv.getSearchWord());

		List<BoardFreeDTO> board_list = service.listProcess(FreeDTO);

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				pv.setCurrentPage(1);

			this.pdto = new BoardFreePageDTO(pv.getCurrentPage(), totalRecord, pv.getSearchKey(), pv.getSearchWord());
			pv.setStartRow(this.pdto.getStartRow());
			pv.setEndRow(this.pdto.getEndRow());
			model.addAttribute("pv", this.pdto);
			model.addAttribute("list", board_list);
			model.addAttribute("searchWord", pv.getSearchWord());

		}

		return "board/board";
	}

	// 게시물 작성
	@PostMapping("/write")
	public String postWrite(BoardFreeDTO boardFreeDTO, HttpServletRequest request) {

		MultipartFile file = boardFreeDTO.getFilename();

		if (!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, request);
			boardFreeDTO.setUpload(random + "_" + file.getOriginalFilename());
		}

		service.write(boardFreeDTO);

		return "redirect: /board?currentPage=1";
	}

	// 게시물 상세조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardFreeDTO boardFreeDTO, Model model) {

		model.addAttribute("read", service.read(boardFreeDTO.getBoard_code()));

		List<BoardFreeReplyDTO> replyList = replyService.readReply(boardFreeDTO.getBoard_code());

		model.addAttribute("replyList", replyList);

		return "board/readView";
	}

	// 게시물 수정view
	@GetMapping("/updateView")
	public String updateView(BoardFreeDTO boardFreeDTO, HttpServletRequest request, Model model) {

		model.addAttribute("update", service.read(boardFreeDTO.getBoard_code()));

		return "board/updateView";

	}

	// 게시물 수정 post
	@PostMapping("/update")
	public String update(BoardFreeDTO boardFreeDTO, HttpServletRequest request) {
		MultipartFile file = boardFreeDTO.getFilename();

		if (!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, request);
			boardFreeDTO.setUpload(random + "_" + file.getOriginalFilename());
		}

		service.update(boardFreeDTO, FileUpload.urlPath(request));

		return "redirect:/board?currentPage=1";
	}

	// 게시물 삭제
	@PostMapping("/delete")
	public String delete(BoardFreeDTO boardFreeDTO, HttpServletRequest request) {
		service.delete(boardFreeDTO.getBoard_code(), FileUpload.urlPath(request));

		return "redirect:/board?currentPage=1";
	}

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(BoardFreeReplyDTO boardFreeReplyDTO, RedirectAttributes rttr) {
		replyService.writeReply(boardFreeReplyDTO);

		rttr.addAttribute("board_code", boardFreeReplyDTO.getBoard_code());

		return "redirect:/readView";
	}

	// 댓글 수정 view
	@RequestMapping(value = "/replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(BoardFreeReplyDTO boardFreeReplyDTO, Model model) {

		model.addAttribute("replyUpdate", replyService.readReply(boardFreeReplyDTO.getReply_code()));

		return "/jsp/replyUpdateView";
	}

	// 댓글 수정 post
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	@ResponseBody
	public int replyUpdate(BoardFreeReplyDTO boardFreeReplyDTO, RedirectAttributes rttr) {

		int cnt = replyService.updateReply(boardFreeReplyDTO);

		rttr.addAttribute("reply_code", boardFreeReplyDTO.getReply_code());

		return cnt;
	}

	// 댓글 삭제

	@RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
	@ResponseBody
	public int replyDelete(BoardFreeReplyDTO boardFreeReplyDTO) {

		int cnt = replyService.deleteReply(boardFreeReplyDTO.getReply_code());

		return cnt;
	}

	// 댓글 데이터 가져오기
	@RequestMapping(value = "/getReplyData", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getReplyData(BoardFreeReplyDTO boardFreeReplyDTO) {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data = replyService.getReplyData(boardFreeReplyDTO.getReply_code());

		return data;
	}

	// 첨부파일 다운로드
	@GetMapping("/contentdownload")
	public ModelAndView downloadExecute(int board_code, ModelAndView mav) {

		mav.addObject("board_code", board_code);
		mav.addObject("fileSelectProcess", service.fileSelectProcess(board_code));
		mav.setViewName("download");

		return mav;

	}
				 
	@GetMapping("/board/notice_board")
	public String boardPage() {
		return "board/notice_board";
	}

}


