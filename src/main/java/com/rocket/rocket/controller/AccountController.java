package com.rocket.rocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.rocket.mapper.AccountMapper;

import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/users/**")
@AllArgsConstructor
public class AccountController {

	@Autowired
	AccountMapper accountMapper;
	
	@RequestMapping("/student")
	public String user() {
		return "/users/studentPage";
	}
	
	@RequestMapping("/teacher")
	public String member() {
		return "/users/teacherPage";
	}	
	
	@RequestMapping("/accessDenied_page")
	public String accessDenied() {
		return "/users/accessDenied_page";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "/users/adminPage";
	}	
	
	@GetMapping("/login")
	public String login() {
		return "/users/login";
	}	
	
	@RequestMapping("/logout")
	public String logout() {
		return "/users/logout";
	}	
}
