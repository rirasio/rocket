package com.rocket.rocket.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.mapper.SecurityMapper;
import com.rocket.rocket.service.HwService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Pre;

@Slf4j
@RequestMapping("/users/**")
@Controller
@MapperScan(basePackages = { "com.rocket.rocket.mapper" })
@AllArgsConstructor
public class SecurityController {

	@Autowired
	SecurityMapper securityMapper;
	
	//유저권한별 마이페이지-------------------
	@RequestMapping("/admin")
	public String user() {
		return "/users/adminPage";
	}

	@RequestMapping("/teacher")
	public String teacher() {
		return "/users/teacherPage";
	}
	
	@RequestMapping("/subs")
	public String subs() {
		return "/users/subsPage";
	}

	@RequestMapping("/student")
	public String student() {
		return "/users/studentPage";
	}	

	//로그인 관련-------------------------------------------------------
	@GetMapping("/login")
	public void login(String error, String logout, Model model ) {
		log.info("error : "+error);
		log.info("logout : "+logout);
		
		if (error !=null) {
			model.addAttribute("error", "login Error check your account");
		}
		if (logout !=null) {
			model.addAttribute("logout", "logout!");
		}
	}
	
	@GetMapping("/access_denied")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "403 access_denied입니다.(from model)");
	}
	
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout실행");

	}
	
	
	
}
