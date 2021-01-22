package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int reply_num;
	
	private String content;
	
	private String nickname;
	
	private Date regDate;
	
	private Date modiDate;
	
	private Date delDate;
	
	private int comm_num;
}
