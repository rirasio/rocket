package com.rocket.rocket.domain;

import lombok.Data;

@Data
public class FilesVO {

	private String uuid;
	
	private String uploadpath;
	
	private String filename;
	
	private byte filetype;
	
	private Long class_num;
	
	private Long hw_num;
	
	private Long dohw_num;
	
	private Long ex_num;
	
	private Long lec_num;
}
