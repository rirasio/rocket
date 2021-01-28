
package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.service.MyPageService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = { "/myPage" })
@AllArgsConstructor
public class MyPageController {

	private MyPageService myPageService;

	@GetMapping(value = { "/myPage" })
	public void myPage(UsersVO users, Model model) {
		model.addAttribute("users", myPageService.myPage(users.getEmail()));
		model.addAttribute("ctgy", myPageService.myCtgy(users.getEmail()));
		model.addAttribute("take", myPageService.myTake(users.getEmail()));
	}

}
