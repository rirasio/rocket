package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LecVO {

	private Long num;
	
	private String title;
	
	private String video;
	
	private String ingre;
	
	private Date regdate;
	
	private Date modidate;
	
	private String clickcnt;
	
	private Long class_num;
	
	private int lorder;
	
}
