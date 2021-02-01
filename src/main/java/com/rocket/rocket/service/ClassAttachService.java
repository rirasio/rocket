package com.rocket.rocket.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rocket.rocket.domain.FilesVO;

public interface ClassAttachService {
	
	void saveUploadFiles(List<MultipartFile> files) throws IOException;
	
}
