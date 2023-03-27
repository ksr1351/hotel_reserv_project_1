package testBoard.free.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testBoard.free.dao.BoardFreeReplyDAO;
import testBoard.free.dto.BoardFreeReplyDTO;

@Service
public class BoardFreeReplyServiceImp implements BoardFreeReplyService {

	private final BoardFreeReplyDAO boardFreeReplyDAO;

	@Autowired
	public BoardFreeReplyServiceImp(BoardFreeReplyDAO boardFreeReplyDAO) {
		this.boardFreeReplyDAO = boardFreeReplyDAO;
	}

	// 댓글 조회
	@Override
	public List<BoardFreeReplyDTO> readReply(int board_code) {
		return boardFreeReplyDAO.readReply(board_code);
	}

	// 댓글 작성
	@Override
	public void writeReply(BoardFreeReplyDTO boardFreeReplyDTO) {
		boardFreeReplyDAO.writeReply(boardFreeReplyDTO);

	}

	// 댓글 수정
	@Override
	public int updateReply(BoardFreeReplyDTO boardFreeReplyDTO) {
		int cnt = boardFreeReplyDAO.updateReply(boardFreeReplyDTO);
		return cnt;
	}

	// 댓글 삭제
	@Override
	public int deleteReply(int reply_code) {
		int cnt = boardFreeReplyDAO.deleteReply(reply_code);
		return cnt;

	}

	// 댓글 데이터 가져오기
	@Override
	public HashMap<String, Object> getReplyData(int reply_code) {
		return boardFreeReplyDAO.getReplyData(reply_code);
	}
}
