package com.rocket.rocket.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommVO {

	private String comm_num;
	
	private String nickname;
	
	private String content;
	
	private Date regDate;
	
	private Date modiDate;
	
	private Date delDate;
	
	private byte exist;
	
	private String user_num;
	
	private String lec_num;
	
	private String class_num;
}
