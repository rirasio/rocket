package com.rocket.rocket.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

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
