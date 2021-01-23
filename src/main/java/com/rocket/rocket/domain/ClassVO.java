package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ClassVO {

	private Long num;
	
	private String title;
	
	private String intro;
	
	private Date regdate;
	
	private Date modidate;
	
	private String ctgy_title;
	
	private String email;
}
