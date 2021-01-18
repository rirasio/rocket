package com.rocket.rocket.domain;

import lombok.Data;

@Data
public class HwVO {

	private String hw_num;
	
	private String title;
	
	private String content;
	
	private String fileName;
	
	private byte fileType;
	
	private String filePath;
	
	private String lec_num;
}