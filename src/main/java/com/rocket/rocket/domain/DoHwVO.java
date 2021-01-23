package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DoHwVO {

	private Long num;
	
	private Date regdate;
	
	private Date modidate;
	
	private Long hw_num;
	
	private String email;
}
