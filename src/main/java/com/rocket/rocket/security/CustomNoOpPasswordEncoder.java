package com.rocket.rocket.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//패스워드 인코더를 안쓰고 로그인하고자 하면 context.xml이나 cofig파일에 의존성 주입
@Slf4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	public String encode(CharSequence rawPassword) {
		
		log.warn("before encode : " + rawPassword);
		
		return rawPassword.toString();
		
	}
	
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		log.warn("matches: " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		
	}
}
