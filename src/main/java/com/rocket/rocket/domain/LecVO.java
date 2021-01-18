package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LecVO {

	private String lec_num;
	
	private String title;
	
	private String video;
	
	private String ingre;
	
	private Date regDate;
	
	private Date modiDate;
	
	private String clickCnt;
	
	private String class_num;
	
	private int lorder;
}
