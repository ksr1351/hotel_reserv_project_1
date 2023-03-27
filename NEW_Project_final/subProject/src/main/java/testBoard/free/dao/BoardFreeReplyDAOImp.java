package testBoard.free.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testBoard.free.dto.BoardFreeReplyDTO;


@Repository
public class BoardFreeReplyDAOImp implements BoardFreeReplyDAO {

	private final SqlSessionTemplate sqlSession;

	@Autowired
	public BoardFreeReplyDAOImp(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 댓글 조회
	@Override
	public List<BoardFreeReplyDTO> readReply(int board_code) {
		return sqlSession.selectList("board.readReply", board_code);
	}

	// 댓글 작성
	@Override
	public void writeReply(BoardFreeReplyDTO boardFreeReplyDTO) {
		sqlSession.insert("board.writeReply", boardFreeReplyDTO);

	}

	// 댓글 수정
	@Override
	public int updateReply(BoardFreeReplyDTO boardFreeReplyDTO) {
		return sqlSession.update("board.updateReply", boardFreeReplyDTO);

	}

	// 댓글 삭제
	@Override
	public int deleteReply(int reply_code) {
		return sqlSession.delete("board.deleteReply", reply_code);

	}

	// 댓글 데이터 가져오기
	@Override
	public HashMap<String, Object> getReplyData(int reply_code) {
		return sqlSession.selectOne("board.getReplyData", reply_code);
	}

}
