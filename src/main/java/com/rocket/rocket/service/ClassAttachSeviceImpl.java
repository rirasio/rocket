package com.rocket.rocket.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClassAttachSeviceImpl implements ClassAttachService {
	
	private static String UPLOADED_FOLDER = "./upload/";
	
	
	
	@Override
	public void saveUploadFiles(List<MultipartFile> files) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	}


