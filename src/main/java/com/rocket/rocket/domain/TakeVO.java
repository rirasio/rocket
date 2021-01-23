package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TakeVO {

	private Long num;
	
	private Date regdate;
	
	private Long class_num;
	
	private String email;
}
