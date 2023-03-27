package testBoard.inform.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testBoard.inform.dao.InformDAO;
import testBoard.inform.dto.InformDTO;
import testBoard.inform.dto.InformPageDTO;

@Service
public class InformServiceImp implements InformService {

	private final InformDAO informDao;

	@Autowired
	public InformServiceImp(InformDAO informDao) {
		this.informDao = informDao;
	}

	// 공지사항 목록 + 페이징 처리
	@Override
	public List<InformDTO> listProcess(InformPageDTO informpageDto) {
		return informDao.list(informpageDto);
	}

	// 공지사항 검색
	@Override
	public List<InformPageDTO> getSearchList(InformPageDTO informpageDto) {
		return informDao.selectSearchList(informpageDto);
	}

	// 공지사항 작성
	@Override
	public void writeProcess(InformDTO informDto) {
		informDao.write(informDto);
	}

	// 공지사항 조회
	@Override
	public InformDTO readProcess(int notice_code) {
		informDao.readCount(notice_code);
		return informDao.read(notice_code);
	}

	// 공지사항 수정(저장 된 content 띄워주기)
	@Override
	public void updateProcess(InformDTO informDto, String urlpath) {
		String filename = informDto.getUpload();

		//System.out.println("filename  : " + filename);

		// 수정할 파일이 있으면
		if (filename != null) {

			String path = informDao.getFile(informDto.getNotice_code());
			// 기존 첨부파일이 있으면
			if (path != null) {
				File file = new File(urlpath, path);
				file.delete();
			}

		}
		informDao.update(informDto);
		
		//System.out.println(boardFreeDTO);

	}

	// 공지사항 삭제
	@Override
	public void deleteProcess(int notice_code, String urlpath) {
		String path = informDao.getFile(notice_code);// 첨부파일 먼저 삭제

		if (path != null) {
			File file = new File(urlpath, path);
			file.delete();
		}
		informDao.delete(notice_code);
	}

	// 공지사항 총 갯수
	@Override
	public int countProcess(InformPageDTO informpageDto) {
		return informDao.count(informpageDto);
	}

	// 첨부파일 다운로드
	@Override
	public String fileSelectProcess(int notice_code) {
		return informDao.getFile(notice_code);
	}

}
