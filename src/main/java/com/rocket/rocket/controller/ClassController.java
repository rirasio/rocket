package com.rocket.rocket.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.service.ClassService;
import com.rocket.rocket.service.LecService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/classes")
@AllArgsConstructor
@Slf4j
public class ClassController {

	private ClassService classService;
	private LecService lecService;

	

		//디폴트 리스트 
	@GetMapping(value = { "/list" })
	public String list(Model model) {
		
		log.info("list page");
		model.addAttribute("classlist", classService.classList());
		model.addAttribute("ctgylist", classService.ctgyList());
		
		
		return "classes/list";
	}




	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	
		
//	//	필터 적용 리스트
//	@GetMapping(value = { "/list" })
//	public void listCtgy(Criteria cri, Model model) {
//
//		log.info("filtered list page");
//		model.addAttribute("classlist", classService.classList(cri));
//		model.addAttribute("ctgylist", classService.ctgyList());
//		int total = classService.getTotal(cri);
//	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//	클래스 개설
	@GetMapping(value = { "/create" })
	public String create(ClassVO classVO, Model model) {
		log.info("create page");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		classVO.setEmail(email);
		model.addAttribute("classVO", classVO);
		model.addAttribute("ctgylist", classService.ctgyList());
		return "classes/create";
	}


////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//	클래스 개설 완료 후 개설된 페이지로 이동

	@PostMapping(value = { "/create" })
	public String create(ClassVO classVO, RedirectAttributes rttr) {

		classService.createClass(classVO);

		Long mn = classService.maxNum();
		log.info(mn.toString());
		log.info("create complete");

		return "redirect:/classes/read?num=" + mn;

	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//	클래스 상세, 수정페이지로 이동
	@GetMapping({ "/read", "/update" })

	public void read(@RequestParam("num") Long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		log.info("read page");
		model.addAttribute("class", classService.read(num));
		model.addAttribute("list", lecService.getList(num));
		model.addAttribute("class_num", num);
		model.addAttribute("classAvg", Math.round((classService.classAvg(num)*100))/100.0);
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//	수정완료
	@PostMapping("/update")
	public String update(ClassVO classVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (classService.update(classVO)) {
			rttr.addAttribute("result", "success");
		}
		log.info("update complete");
		Long cn = classVO.getNum();
		return "redirect:/classes/read?num=" + cn;
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//	삭제
	@PostMapping("/delete")
	public String delete(@RequestParam("num") Long num,

			@RequestAttribute(value = "cri", required = false) Criteria cri, RedirectAttributes rttr) {
		if (classService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		log.info("delete complete");
		return "redirect:/classes/list";
	}

	
//	@PostMapping("/classThumbnail")
//	@ResponseBody
//	public ResponseEntity<List<FilesVO>> fileUpload (HttpServletRequest request, @RequestParam("thumbnail") MultipartFile multipartFile) {
//		
//		
//		log.info("----------------------------------------------------------");
//		log.info("Upload File Name :: " + multipartFile.getOriginalFilename());
//		log.info("Upload File Size :: " + multipartFile.getSize());
//
//		
//		
//		log.info("classThumnail.............");
//
//		List<FilesVO> list = new ArrayList<FilesVO>();
//		String uploadFolder = "C:\\Image";
//		String uploadFolderPath = getFolder();
//
//		File uploadPath = new File(uploadFolder, uploadFolderPath);
//		log.info("upload path :: " + uploadPath);
//
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		}
//
//		
//
//		FilesVO filesVO = new FilesVO();
//
//			
//			String uploadFileName = multipartFile.getOriginalFilename();
//
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
//			log.info("only file name :: " + uploadFileName);
//			filesVO.setFilename(uploadFileName);
//
//			UUID uuid = UUID.randomUUID();
//			uploadFileName = uuid.toString() + "_" + uploadFileName;
//
//			try {
//				File saveFile = new File(uploadPath, uploadFileName);
//				multipartFile.transferTo(saveFile);
//
//				filesVO.setUuid(uuid.toString());
//				filesVO.setUploadpath(uploadFolderPath);
//
//				if (checkImageType(saveFile)) {
//
//					filesVO.setFiletype(true);
//
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
//					thumbnail.close();
//				}
//
//				list.add(filesVO);
//
//			} catch (Exception e) {
//				log.error(e.getMessage());
//			}
//		
//			classAttachMapper.insertClassThumbnail(filesVO);
//		
//		
//		return new ResponseEntity<List<FilesVO>>(list, HttpStatus.OK);
//	}
//	

}
