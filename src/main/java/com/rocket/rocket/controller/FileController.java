package com.rocket.rocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.rocket.rocket.mapper.ClassAttachMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
public class FileController {
	
	@Setter(onMethod_ = @Autowired)
	private ClassAttachMapper classAttachMapper;
	
	
	
//	@RequestMapping("/classes/create")
	
	
//	@RequestMapping("/classThumbnail")
//	public String fileUpload (HttpServletRequest request, @RequestParam("thumbnail") MultipartFile multipartFile) {
//		try {
//			multipartFile.transferTo(new File("c:/Image/ClassThumbnail/"+multipartFile.getOriginalFilename()));
//		} catch (IllegalStateException | IOException e) {
//			
//		}
//		
//		return null;
//	}
	
	
//	@RequestMapping("/classThumbnail")
//	public String fileUpload (HttpServletRequest request, @RequestParam("thumbnail") MultipartFile multipartFile) {
//		
//		try {
//			FilesVO filesVO = new FilesVO();
//			
//			String uploadPath = "C:\\Image\\ClassThumbnail";
//			filesVO.setUploadPath(uploadPath);
//			
//			String uploadFileName = multipartFile.getOriginalFilename();
//			filesVO.setFileName(uploadFileName);
//			
//			log.info("----------------------------------------------------------");
//			log.info("Upload File Name :: " + uploadFileName);
//			log.info("Upload File Folder :: " + uploadPath);
//			log.info("Upload File Size :: " + multipartFile.getSize());
//			
//			UUID uuid = UUID.randomUUID();
//			filesVO.setUuid(uuid.toString());
//			uploadFileName = uuid.toString() + "_" + uploadFileName;
//			
//			File saveFile = new File(uploadPath, uploadFileName);
//			multipartFile.transferTo(saveFile);
//			
//			classAttachMapper.insertClassThumbnail(filesVO);
//			
//		} catch (IllegalStateException | IOException e) {
//			
//		} 
//		return "index";
//	}
//	
//
//	private String getFolder() {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String str = sdf.format(date);
//
//		return str.replace("-", File.separator);
//	}
//	
//	private boolean checkImageType(File file) {
//
//		try {
//			String contentType = Files.probeContentType(file.toPath());
//			return contentType.startsWith("image");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}
	
	
}
