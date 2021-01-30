package com.rocket.rocket.controller;

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

//		rttr.addFlashAttribute("result", classVO.getNum());

		classService.createClass(classVO);

		log.info("create complete");

		return "redirect:/";
	}

	@GetMapping({ "/read", "/update" })

	public void read(@RequestParam("num") Long num,

			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		log.info("read page");
		model.addAttribute("class", classService.read(num));
		model.addAttribute("list", lecService.getList(num));
		model.addAttribute("class_num", num);
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
