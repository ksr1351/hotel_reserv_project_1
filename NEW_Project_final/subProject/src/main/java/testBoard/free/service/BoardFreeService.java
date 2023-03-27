package testBoard.free.service;

import java.util.List;

import testBoard.free.dto.BoardFreeDTO;
import testBoard.free.dto.BoardFreePageDTO;


public interface BoardFreeService {

	// 게시물 목록 조회 + 페이징
	public List<BoardFreeDTO> listProcess(BoardFreePageDTO boardFreePageDTO);
	
	// 게시물 검색
	public List<BoardFreePageDTO> getSearchList(BoardFreePageDTO boardFreePageDTO);

	// 게시물 작성
	public void write(BoardFreeDTO boardFreeDTO);

	// 게시물 상세조회
	public BoardFreeDTO read(int board_code);

	// 게시물 수정(수정 함수 설정)
	public void update(BoardFreeDTO boardFreeDTO, String urlpath);

	// 게시물 삭제
	public void delete(int board_code, String urlpath);

	// 게시물 총 갯수
	public int countProcess(BoardFreePageDTO boardFreePageDTO);

	// 첨부파일 다운로드
	public String fileSelectProcess(int board_code);

	
	
	

}
