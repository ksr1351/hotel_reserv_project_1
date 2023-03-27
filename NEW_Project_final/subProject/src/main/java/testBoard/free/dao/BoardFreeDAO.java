package testBoard.free.dao;

import java.util.List;

import testBoard.free.dto.BoardFreeDTO;
import testBoard.free.dto.BoardFreePageDTO;

public interface BoardFreeDAO {

	// 게시물 목록 조회 + 페이징
	public List<BoardFreeDTO> list(BoardFreePageDTO boardFreePageDTO);

	// 게시물 검색
	public List<BoardFreePageDTO> selectSearchList(BoardFreePageDTO boardFreePageDTO);

	// 게시물 작성
	public void write(BoardFreeDTO boardFreeDTO);

	// 게시물 상세조회
	public BoardFreeDTO read(int board_code);

	// 게시물 수정(기존 내용 불러와서 띄워주기)
	public void update(BoardFreeDTO boardFreeDTO);

	// 게시물 삭제
	public void delete(int board_code);

	// 게시물 총 갯수
	public int count(BoardFreePageDTO boardFreePageDTO);

	// 첨부파일 다운로드
	public String getFile(int board_code);
	
	// 게시물 조회수
	public void readCount(int board_code);

}
