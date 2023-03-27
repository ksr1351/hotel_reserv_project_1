package testBoard.free.service;

import java.util.HashMap;
import java.util.List;

import testBoard.free.dto.BoardFreeReplyDTO;


public interface BoardFreeReplyService {

	// 댓글 조회
	public List<BoardFreeReplyDTO> readReply(int board_code);
	
	// 댓글 작성
	public void writeReply(BoardFreeReplyDTO boardFreeReplyDTO);
	
	//댓글 수정
	public int updateReply(BoardFreeReplyDTO boardFreeReplyDTO);
	
	//댓글 삭제
	public int deleteReply(int reply_code);

	//댓글 데이터 가져오기
	public HashMap<String, Object> getReplyData(int reply_code);
}
