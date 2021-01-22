package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommVO {

	private int comm_num;
	
	private String nickname;
	
	private String content;
	
	private Date regDate;
	
	private Date modiDate;
	
	private Date delDate;
	
	private byte exist;
	
	private int user_num;
	
	private int lec_num;
	
	private int class_num;
}
