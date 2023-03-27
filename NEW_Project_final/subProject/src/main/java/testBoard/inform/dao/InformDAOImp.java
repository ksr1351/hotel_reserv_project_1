package testBoard.inform.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testBoard.inform.dto.InformDTO;
import testBoard.inform.dto.InformPageDTO;

@Repository
public class InformDAOImp implements InformDAO {
	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public InformDAOImp(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 공지사항 목록 + 페이징 처리
	@Override
	public List<InformDTO> list(InformPageDTO informpageDto) {
		return sqlSession.selectList("inform.list", informpageDto);
	}

	// 공지사항 검색
	@Override
	public List<InformPageDTO> selectSearchList(InformPageDTO informpageDto) {
		return sqlSession.selectList("inform.list", informpageDto);
	}

	// 공지사항 작성
	@Override
	public void write(InformDTO informDto) {
		sqlSession.insert("inform.write", informDto);
	}

	// 공지사항 조회
	@Override
	public InformDTO read(int notice_code) {
		return sqlSession.selectOne("inform.read", notice_code);
	}

	// 공지사항 수정(저장 된 content 띄워주기)
	@Override
	public void update(InformDTO informDto) {
		sqlSession.update("inform.update", informDto);
	}

	// 공지사항 삭제
	@Override
	public void delete(int notice_code) {
		sqlSession.delete("inform.delete", notice_code);
	}

	// 공지사항 총 갯수
	@Override
	public int count(InformPageDTO informpageDto) {
		return sqlSession.selectOne("inform.count", informpageDto);
	}

	// 공지사항 조회수
	@Override
	public void readCount(int notice_code) {
		sqlSession.update("inform.readCount", notice_code);
	}
	
	// 첨부파일 다운로드
	@Override
	public String getFile(int notice_code) {
		return sqlSession.selectOne("inform.getFile", notice_code); 
	}

}
