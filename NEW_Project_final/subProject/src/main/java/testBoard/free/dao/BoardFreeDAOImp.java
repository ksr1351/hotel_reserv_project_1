package testBoard.free.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testBoard.free.dto.BoardFreeDTO;
import testBoard.free.dto.BoardFreePageDTO;

@Repository
public class BoardFreeDAOImp implements BoardFreeDAO {

	private final SqlSessionTemplate sqlSession;

	@Autowired
	public BoardFreeDAOImp(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 게시물 목록 조회 + 페이징
	@Override
	public List<BoardFreeDTO> list(BoardFreePageDTO boardFreepageDTO) {
		return sqlSession.selectList("board.list",boardFreepageDTO);
	}
	
	// 게시물 검색
	@Override
	public List<BoardFreePageDTO> selectSearchList(BoardFreePageDTO boardFreePageDTO) {
		return sqlSession.selectList("board.list", boardFreePageDTO);
	}

	
	// 게시물 작성
	@Override
	public void write(BoardFreeDTO boardFreeDTO) {
		sqlSession.insert("board.write", boardFreeDTO);

	}

	// 게시물 상세조회
	@Override
	public BoardFreeDTO read(int board_code) {
		return sqlSession.selectOne("board.read", board_code);
	}

	// 게시물 수정
	@Override
	public void update(BoardFreeDTO boardFreeDTO) {
		sqlSession.update("board.update", boardFreeDTO);

	}

	// 게시물 삭제
	@Override
	public void delete(int board_code) {
		sqlSession.delete("board.delete", board_code);

	}

	// 게시물 총 갯수
	@Override
	public int count(BoardFreePageDTO boardFreePageDTO) {
		return sqlSession.selectOne("board.count",boardFreePageDTO);
	}

	//첨부파일 다운로드
	@Override
	public String getFile(int board_code) {
		return sqlSession.selectOne("board.getFile", board_code); 
	}

	// 게시물 조회수
	@Override
	public void readCount(int board_code) {
		sqlSession.update("board.readCount", board_code);
	}

	
	
	

	

	

}
