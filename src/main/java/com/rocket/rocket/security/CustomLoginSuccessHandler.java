package com.rocket.rocket.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
	
		log.warn("Login Success");
		
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		log.warn("ROLE NAMES: "+ roleNames);
		
		//관리자 로그인시 관리자 페이지로 자동연결
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/users/admin");
			return;
		}
		
		if (roleNames.contains("ROLE_2")) {
			response.sendRedirect("/users/teacher");
			return;
		}
		if (roleNames.contains("ROLE_1")) {
			response.sendRedirect("/users/subs");
			return;
		}
		if (roleNames.contains("ROLE_0")) {
			response.sendRedirect("/users/student");
			return;
		}
		
		response.sendRedirect("/");
		
	}

}
