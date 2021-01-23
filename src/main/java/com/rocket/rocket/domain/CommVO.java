package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommVO {

	private Long num;
	
	private String nickname;
	
	private String content;
	
	private Date regdate;
	
	private Date modidate;
	
	private Date deldate;
	
	private byte exist;
	
	private Long lec_num;
	
	private Long class_num;
	
	private String email;
}
