package com.rocket.rocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.mapper.LecMapper;

@RequestMapping("/lec")
@RestController
public class LecController {
	
	private final LecMapper lecMapper;
	
	public LecController(LecMapper lecMapper) {
		this.lecMapper = lecMapper;
	}

	@GetMapping("/list")
	public String lec() {
		LecVO lec = lecMapper.getLec();
		return lec.toString();
	}
	
	@GetMapping("/title")
	public String title() {
		LecVO lec = lecMapper.getLecTitle();
		return lec.getTitle();
	}

}
