package testBoard.login.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testBoard.login.commons.session.SessionConst;
import testBoard.login.dto.AddMemDTO;
import testBoard.login.dto.KakaoProfileDTO;
import testBoard.login.dto.LoginMemDTO;
import testBoard.login.dto.OAuthTokenDTO;
import testBoard.login.service.MembersService;

// http://localhost:8090/kakao

@Controller
public class KakaoController {
	
	private final MembersService service;
	
	
	@Autowired
	public KakaoController(MembersService service) {
		this.service = service;
	}


	@GetMapping("/kakao")
	public String execute() {
		
		return "kakaoLogin/kakao.html";
	}
	
	
	@GetMapping("/auth/kakao/callback")
	public String KakaoCallback(String code, HttpServletRequest request) {
		
		 RestTemplate rt = new RestTemplate();

		 
		 HttpHeaders headers = new HttpHeaders();
		 
		 headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		                                         
		 
		 //body
		 MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		 
		 params.add("grant_type", "authorization_code");
		 params.add("client_id","fdb3ded4b5d753c2e685b7bb4ffbaa8d");
		 params.add("redirect_uri","http://localhost:8090/auth/kakao/callback");
		 params.add("code",code );
		 //params.add("client_secret","I3fuqXbPs3OF7X1QIjv9CyRUnrAG4p2i");
		 
		 
		 HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				 new HttpEntity<>(params,headers);
		
		 ResponseEntity<String> response = rt.exchange(
				 
				 "https://kauth.kakao.com/oauth/token",
				 HttpMethod.POST,
				 kakaoTokenRequest,
				 String.class
				 
				 );
		 
		 //Gson, Tson Simple, ObjectMapper
		 ObjectMapper objectMapper = new ObjectMapper();
		 OAuthTokenDTO oauthToken = null;
		 
		 try {
			oauthToken = objectMapper
					 	.readValue(response.getBody(), OAuthTokenDTO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		  
		System.out.println("카카오 엑세스 토큰 : " + oauthToken.getAccess_token());
		 
		/////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		RestTemplate rt2 = new RestTemplate();

		 
		 HttpHeaders headers2 = new HttpHeaders();
		 
		 //공백 주의
		 headers2.add("Authorization", "Bearer "+ oauthToken.getAccess_token());
		 
		 headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		                                         
		 
		 
		 
		 HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 =
				 new HttpEntity<>(headers2);
		
		 ResponseEntity<String> response2 = rt2.exchange(
				 
				 "https://kapi.kakao.com/v2/user/me",
				 HttpMethod.POST,
				 kakaoProfileRequest2,
				 String.class
				 
				 );
		 
		 
		 ObjectMapper objectMapper2 = new ObjectMapper();
		 KakaoProfileDTO kakaoProfile = null;
		 
		 try {
			 kakaoProfile = objectMapper2
					 	.readValue(response2.getBody(), KakaoProfileDTO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		 System.out.println("카카오 아이디(번호) : " + kakaoProfile.getId());
		 System.out.println("카카오 아이디(번호) : " + kakaoProfile.getKakao_account().getEmail());
		
		 
		 String kakao_id = String.valueOf(kakaoProfile.getId())+5;
		 
		 //회원가입이 안되어있으면, 
		 if(service.duplicateIdCheckProcess(kakao_id)!=1){
			 
			 System.out.println("회원가입이 안되어있으면, 호출");
			 
			 AddMemDTO addMemDTO = new AddMemDTO();
			 
			 addMemDTO.setMem_Id(kakao_id);
			 addMemDTO.setMem_Pwd(33+String.valueOf(kakaoProfile.getId())+45);
			 addMemDTO.setMem_Phone("01012341234");
			 addMemDTO.setMem_Name("회원");
			 addMemDTO.setMem_Email(kakaoProfile.getKakao_account().getEmail());
			 addMemDTO.setMemberType("3");
			 
			 service.insertProcess(addMemDTO);
			 
			 System.out.println("회원 저장 성공");
			 
			 HttpSession session = request.getSession();
			 
			 
			 session.setAttribute(SessionConst.LOGIN_KAKAO,  service.kakaoMemberCheckProcess(addMemDTO.getMem_Id()));
			 
			 System.out.println("회원가입이 안되어있으면, 종료");
			 
			 return "redirect:/";
		 }
		 
		 
		 
		 System.out.println("회원가입이 되어있으면 세션 저장");
		 
		 HttpSession session = request.getSession();
		 
			
		 
		 session.setAttribute(SessionConst.LOGIN_KAKAO,  service.kakaoMemberCheckProcess(kakao_id));
		 
		 System.out.println("회원가입이 되어있으면 세션 완료");
		 
		return "redirect:/"; 
	}	       
	
	@GetMapping("/kakaoLogout")
	public String kakaoexcute2() {
		
		
		
		
		
		return "kakaoLogin/kakaoLogout.html";
	}
	
	@GetMapping("/auth/kakao/logout")
	public String kakaoLogut(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		
		return "redirect:/"; 
	}	
	
}
