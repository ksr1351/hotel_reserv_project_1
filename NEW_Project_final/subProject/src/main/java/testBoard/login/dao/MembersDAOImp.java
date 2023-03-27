package testBoard.login.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.SessionDTO;

@Component
public class MembersDAOImp implements MembersDAO{

	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public MembersDAOImp(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public int insertMathod(AddMemDTO addMemDTO) {
		
		return sqlSession.insert("login.MemberSave",addMemDTO);
	}



	@Override
	public LoginMemDTO SelectMemberCheckMathod(LoginMemDTO loginMemDTO) {
		
		return sqlSession.selectOne("login.MemberCheck", loginMemDTO);
	}



	@Override
	public int duplicateIdCheckMeathod(String id) {
		
		System.out.println("dao 호출" + "id");
		
		
		
		return sqlSession.selectOne("login.IdCheck", id);
	}



	@Override
	public SessionDTO kakaoMemberCheckMathod(String id) {
		
		return sqlSession.selectOne("login.kakaoIdCheck", id);
	}




	
}
