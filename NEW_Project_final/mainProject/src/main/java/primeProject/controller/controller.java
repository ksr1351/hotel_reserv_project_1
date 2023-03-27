package primeProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// http://localhost:8090/test?age=10

@Controller
public class controller {

	@GetMapping("/test")
	String execute(int age) {
		
		
		System.out.println(age);
		
		
		return "test.html";
	}
	
	@GetMapping("/test2")
	String execute2(int age) {
		
		
		System.out.println(age);
		
		
		return "test2";
	}
	
}


