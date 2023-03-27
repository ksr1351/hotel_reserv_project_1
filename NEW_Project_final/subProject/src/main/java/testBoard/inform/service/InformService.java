package testBoard.inform.service;

import java.util.List;

import testBoard.inform.dto.InformDTO;
import testBoard.inform.dto.InformPageDTO;

public interface InformService {

	// 공지사항 목록 + 페이징 처리
	public List<InformDTO> listProcess(InformPageDTO informpageDto);
	
	// 공지사항 검색
	public List<InformPageDTO> getSearchList(InformPageDTO informpageDto);

	// 공지사항 작성
	public void writeProcess(InformDTO informDto);

	// 공지사항 조회
	public InformDTO readProcess(int notice_code);

	// 공지사항 수정(저장 된 content 띄워주기)
	public void updateProcess(InformDTO informDto, String urlpath);

	// 공지사항 삭제
	public void deleteProcess(int notice_code, String urlpath);

	// 공지사항 총 갯수
	public int countProcess(InformPageDTO informpageDto);
	
	// 첨부파일 다운로드
	public String fileSelectProcess(int notice_code);
	
}
