package testBoard.login.service;

import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.SessionDTO;

public interface MembersService {
		
	public int insertProcess(AddMemDTO addMemDTO);
	
	public LoginMemDTO SelectMemberCheckProcess(LoginMemDTO loginMemDTO);
	
	public int duplicateIdCheckProcess(String id);
	
	public SessionDTO kakaoMemberCheckProcess(String id);
		
}
