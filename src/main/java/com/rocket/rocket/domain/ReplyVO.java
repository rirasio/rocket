package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private String reply_num;
	
	private String content;
	
	private String nickname;
	
	private Date regDate;
	
	private Date modiDate;
	
	private Date delDate;
	
	private String comm_num;
}
