package com.rocket.rocket.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ClassVO {

	private String class_num;
	
	private String title;
	
	private String intro;
	
	private Date regDate;
	
	private Date modiDate;
	
	private String fileName;
	
	private byte fileType;
	
	private String filePath;
	
	private String thumbName;
	
	private byte thumbType;
	
	private String thumbPath;
}
