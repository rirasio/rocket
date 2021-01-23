package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long num;
	
	private String content;
	
	private String nickname;
	
	private Date regdate;
	
	private Date modidate;
	
	private Date deldate;
	
	private Long comm_num;
	
	private String email;
}
