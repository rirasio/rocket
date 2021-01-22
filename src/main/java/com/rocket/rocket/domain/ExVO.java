package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ExVO {

	private int ex_num;
	
	private String title;
	
	private String content;
	
	private byte answer;
	
	private Date modiDate;
	
	private Date regDate;
	
	private int lec_num;
}
