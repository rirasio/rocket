package com.rocket.rocket.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DoHwVO {

	private String dohw_num;
	
	private Date regDate;
	
	private Date modiDate;
	
	private String fileName;
	
	private byte fileType;
	
	private String filePath;
	
	private String user_num;
	
	private String hw_num;
}
