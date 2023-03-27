package testBoard.free.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testBoard.free.dao.BoardFreeDAO;
import testBoard.free.dto.BoardFreeDTO;
import testBoard.free.dto.BoardFreePageDTO;

@Service
public class BoardFreeServiceImp implements BoardFreeService {

	private final BoardFreeDAO boardFreeDAO;

	@Autowired
	public BoardFreeServiceImp(BoardFreeDAO boardFreeDAO) {
		this.boardFreeDAO = boardFreeDAO;
	}

	// 게시물 목록 조회 + 페이징
	@Override
	public List<BoardFreeDTO> listProcess(BoardFreePageDTO boardFreePageDTO) {
		return boardFreeDAO.list(boardFreePageDTO);
	}

	// 게시물 검색
	@Override
	public List<BoardFreePageDTO> getSearchList(BoardFreePageDTO boardFreePageDTO) {
		return boardFreeDAO.selectSearchList(boardFreePageDTO);
	}


	// 게시물 작성
	@Override
	public void write(BoardFreeDTO boardFreeDTO) {
		boardFreeDAO.write(boardFreeDTO);

	}

	// 게시물 상세조회
	@Override
	public BoardFreeDTO read(int board_code) {
		boardFreeDAO.readCount(board_code);
		return boardFreeDAO.read(board_code);
	}

	// 게시물 수정
	@Override
	public void update(BoardFreeDTO boardFreeDTO, String urlpath) {
		String filename = boardFreeDTO.getUpload();
			
		System.out.println("filename  : " + filename);
		
		// 수정할 파일이 있으면
		if (filename != null) {

			String path = boardFreeDAO.getFile(boardFreeDTO.getBoard_code());
			// 기존 첨부파일이 있으면
			if (path != null) {
				File file = new File(urlpath, path);
				file.delete();
			}

		}
		boardFreeDAO.update(boardFreeDTO);
		
		System.out.println(boardFreeDTO);

	}

	// 게시물 삭제
	@Override
	public void delete(int board_code, String urlpath) {
		String path = boardFreeDAO.getFile(board_code);// 첨부파일 먼저 삭제

		if (path != null) {
			File file = new File(urlpath, path);
			file.delete();
		}
		boardFreeDAO.delete(board_code);
	}

	// 게시물 총 갯수
	@Override
	public int countProcess(BoardFreePageDTO boardFreePageDTO) {
		return boardFreeDAO.count(boardFreePageDTO);
	}

	// 첨부파일 다운로드
	@Override
	public String fileSelectProcess(int board_code) {
		return boardFreeDAO.getFile(board_code);
	}


	

}
