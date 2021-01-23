package com.rocket.rocket.domain;

import lombok.Data;

@Data
public class HwVO {

	private int hw_Num;
	
	private String title;
	
	private String content;
	
	private String fileName;
	
	private byte fileType;
	
	private String filePath;
	
	private int lec_Num;
}
