package primeProject.board.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8090/test?age=10

@Controller
public class BoardFreeController {
	
	
//	@GetMapping("/")
//	public String execute() {
//		
//		return "main.html";
//	}
	
	@GetMapping("/test")
	public String extcute(int age) {
		System.out.println(age);
		
		
		return "test.html";
	}	
	
	@GetMapping("/test2")
	public String execute(int age) {
		return "jsp/test";
	}
	
	@GetMapping("/asd")
	public String execute3() {
		
		return "";
	}
	
	@GetMapping("/error/error-page/404")
	public String execute4() {
		
		System.out.println("컨트롤러 호출");
		
		return "/error/error-page/404";
	}
	

	@GetMapping("/error/error-page/500")
	public String execute5() {
		
		System.out.println("컨트롤러 호출");
		
		return "/error/error-page/500";
	}
	
}
