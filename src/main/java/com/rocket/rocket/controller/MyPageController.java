package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 
 * 임시 url mapping을 해놓았습니다. 작성자분은 작동확인 후 마음대로 수정해주세요.
 */

@Controller()
public class MyPageController {

	@GetMapping("/mypage")
	public String mypage() {
		return "/mypage/mypage";
	}
	
	@GetMapping("/admin")
	public String adminMypage() {
		return "/mypage/adminMypage";
	}
}
