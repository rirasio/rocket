package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TakeVO {

	private String take_num;
	
	private Date regDate;
	
	private String user_num;
	
	private String class_num;
}
