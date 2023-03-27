package testBoard.inform.dao;

import java.util.List;

import testBoard.inform.dto.InformDTO;
import testBoard.inform.dto.InformPageDTO;

public interface InformDAO {

	// 공지사항 목록 + 페이징 처리
	public List<InformDTO> list(InformPageDTO informpageDto);
	
	// 공지사항 검색 
	public List<InformPageDTO> selectSearchList(InformPageDTO informpageDto);

	// 공지사항 작성
	public void write(InformDTO informDto);

	// 공지사항 조회
	public InformDTO read(int notice_code);

	// 공지사항 수정(저장 된 content 띄워주기)
	public void update(InformDTO informDto);

	// 공지사항 삭제
	public void delete(int notice_code);

	// 공지사항 총 갯수
	public int count(InformPageDTO informpageDto);
	
	// 공지사항 조회수
	public void readCount(int notice_code);
	
	// 첨부파일 다운로드
	public String getFile(int notice_code);
	
}
