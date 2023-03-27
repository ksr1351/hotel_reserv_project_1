package testBoard.login.service;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testBoard.board.dto.SearchDTO;
import testBoard.login.dao.MembersDAO;
import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.SessionDTO;


@Service
public class MembersServiceImp implements MembersService{

	private final MembersDAO dao;
	
	@Autowired
	public MembersServiceImp(MembersDAO dao) {
		this.dao = dao;
	}


	@Override
	public int insertProcess(AddMemDTO addMemDTO) {
		return dao.insertMathod(addMemDTO);
	}

	//로그인 아이디, 비밀번호 확인
	@Override
	public LoginMemDTO SelectMemberCheckProcess(LoginMemDTO loginMemDTO) {
	
		LoginMemDTO mem = dao.SelectMemberCheckMathod(loginMemDTO);
		
		if(mem!=null) {
			if(loginMemDTO.getMem_Pwd().equals(mem.getMem_Pwd())) {
				return mem;
			}
		}
		
		
		return null;
	}
	
	
	
	
	

	@Override
	public int duplicateIdCheckProcess(String id) {
		
		return dao.duplicateIdCheckMeathod(id);
	}


	@Override
	public SessionDTO kakaoMemberCheckProcess(String id) {
	
		return dao.kakaoMemberCheckMathod(id);
	}


	
	
	
}
