package com.rocket.rocket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommVo {

	private String comm_num;
	
	private String nickname;
	
	private String content;
	
	private String regDate;
	
	private String modiDate;
	
	private String delDate;
	
	private byte exist;
	
	private String user_num;
	
	private String lec_num;
	
	private String class_num;
}