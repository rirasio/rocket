package com.rocket.rocket;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
@MapperScan(basePackages = { "com.rocket.rocket.mapper" })
public class SecurityApplication {

    public static PasswordEncoder testClientPasswordEncoder = new BCryptPasswordEncoder();
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
        String secret = testClientPasswordEncoder.encode("와우친구들 빡빡이 아저씨야");
        log.info("encode Password :: "+ secret);
        log.info("Client pass: secreto, " + testClientPasswordEncoder.matches("와우친구들 빡빡이 아저씨야",secret));
	}

}
