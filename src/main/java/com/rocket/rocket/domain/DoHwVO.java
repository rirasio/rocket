package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DoHwVO {

	private int dohw_num;
	
	private Date regDate;
	
	private Date modiDate;
	
	private String fileName;
	
	private byte fileType;
	
	private String filePath;
	
	private int user_num;
	
	private int hw_num;
}
