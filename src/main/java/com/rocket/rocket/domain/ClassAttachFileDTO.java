package com.rocket.rocket.domain;

import lombok.Data;


@Data
public class ClassAttachFileDTO {
	
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean image;
	private Long classNum;
	
}
