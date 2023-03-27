package testBoard.login.dao;


import java.util.List;

import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.SessionDTO;

public interface MembersDAO {
	
	
	public int insertMathod(AddMemDTO addMemDTO);
	
	public LoginMemDTO SelectMemberCheckMathod(LoginMemDTO loginMemDTO);
	
	public int duplicateIdCheckMeathod(String id);
	
	public SessionDTO kakaoMemberCheckMathod(String id);
	
	
}

