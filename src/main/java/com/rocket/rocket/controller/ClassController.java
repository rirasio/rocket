package com.rocket.rocket.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
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
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.ClassAttachFileDTO;
import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.service.ClassService;
import lombok.AllArgsConstructor;
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

	@GetMapping(value = { "/list" })
	public String list(Model model) {

		log.info("list page");
		model.addAttribute("classlist", classService.classList());
		return "classes/list";
	}

	@GetMapping(value = { "/create" })
	public String create(Model model) {
		log.info("create page");
		model.addAttribute("ctgylist", classService.ctgyList());
		return "classes/create";
	}

	@PostMapping(value = { "/create" })
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
	
	@GetMapping(value = { "/uploadForm" })
	public String uploadForm(Model model) {

		log.info("uploadForm page");
		return "classes/uploadForm";
	}
	
	
//	@PostMapping("/file")
//	@ResponseStatus(HttpStatus.CREATED)
//	public List<String> upload(@RequestPart List<MultipartFile> files) throws Exception {
//		List<String> list = new ArrayList<>();
//		for (MultipartFile file : files) {
//			String originalfileName = file.getOriginalFilename();
//			File dest = new File("A:/Upload/" + originalfileName);
//			file.transferTo(dest);
//			// TODO
//		}
//		return list;
//	}

	
	
	
	
}
