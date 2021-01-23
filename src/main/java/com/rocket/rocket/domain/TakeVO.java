package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TakeVO {

	private int take_num;
	
	private Date regDate;
	
	private int user_num;
	
	private int class_num;
}
