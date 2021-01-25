package com.rocket.rocket.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.ClassAttachFileDTO;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.service.ClassService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/classes/**")
@AllArgsConstructor
@Slf4j
public class ClassController {

	private ClassService classService;

//	@GetMapping("/list")
//	public void list (Criteria cri, Model model) {
//		
//		log.info("list :: " + cri);
//		model.addAttribute("list", classService.getList(cri));
//		
//		
//		int total = classService.getTotal(cri);
//		log.info("total :: " + total);
//		
//		
//	}

	@GetMapping(value = {"/list"})
	public String list(Model model) {

		log.info("list page");
		model.addAttribute("classlist", classService.classList());
		return "classes/list";
	}

	@GetMapping(value = {"/create"})
	public String create(Model model) {
		log.info("create page");
		model.addAttribute("ctgylist", classService.ctgyList());
		return "classes/create";
	}
	
	
	@PostMapping(value = {"/create"})
	public String create(ClassVO classVO, RedirectAttributes rttr) {

		rttr.addFlashAttribute("result", classVO.getNum());
		
		
		classService.createClass(classVO);

		log.info("create complete");

		return "index";
	}

	@GetMapping({ "/read", "/update" })

	public void read(@RequestParam("num") Long num,

			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		log.info("read page");
		model.addAttribute("class", classService.read(num));
	}

	@PostMapping("/update")
	public String update(ClassVO classVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (classService.update(classVO)) {
			rttr.addAttribute("result", "success");
		}
		log.info("update complete");
		Long cn = classVO.getNum();
		return "redirect:/classes/read?num=" + cn;
	}

	@PostMapping("/delete")

	public String delete(@RequestParam("num") Long num,

			@RequestAttribute(value = "cri", required = false) Criteria cri, RedirectAttributes rttr) {
		if (classService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		log.info("delete complete");
		return "redirect:/classes/list";
	}

	@GetMapping("/uploadForm")
	public void uploadForm() {

		log.info("upload form");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "A:\\Upload";

		for (MultipartFile multipartFile : uploadFile) {

			log.info("----------------------------------------------------------");
			log.info("Upload File Name :: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size :: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {

		log.info("upload ajax");
	}

	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {

		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ClassAttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		log.info("updata ajax post.............");

		List<ClassAttachFileDTO> list = new ArrayList<ClassAttachFileDTO>();
		String uploadFolder = "A:\\Upload";
		String uploadFolderPath = getFolder();

		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path :: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			ClassAttachFileDTO attachDTO = new ClassAttachFileDTO();

			log.info("----------------------------------------------------------");
			log.info("Upload File Name :: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size :: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name :: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);

			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);

				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}

				list.add(attachDTO);

			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		return new ResponseEntity<List<ClassAttachFileDTO>>(list, HttpStatus.OK);

	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {

		log.info("fileName :: " + fileName);

		File file = new File("A:\\Upload\\" + fileName);

		log.info("file :: " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {

		log.info("download file :: " + fileName);

		Resource resource = new FileSystemResource("A:\\Upload\\" + fileName);

		if (resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		log.info("resource :: " + resource);

		String resourceName = resource.getFilename();
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
		HttpHeaders headers = new HttpHeaders();

		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				log.info("IE browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				log.info("Edge browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
				log.info("Edge name :: " + downloadName);
			} else {
				log.info("Chrome browser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			log.info("downloadName :: " + downloadName);

			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
	
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile (String fileName, String type) {
		
		log.info("deleteFile :: " + fileName);
		
		File file;
		
		try {
			file = new File("A:\\Upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			
			if (type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName :: " + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<String> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String> ("deleted", HttpStatus.OK);
	}

}
