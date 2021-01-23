package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ExVO {

	private Long num;
	
	private String title;
	
	private String content;
	
	private byte answer;
	
	private Date modidate;
	
	private Date regdate;
	
	private Long lec_num;
}
