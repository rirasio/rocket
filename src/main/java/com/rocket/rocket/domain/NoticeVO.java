package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {

	private Long num;
	
	private String title;
	
	private String content;
	
	private Date regdate;
	
	private Date modidate;
	
	private Date deldate;
	
	private String email;
}
