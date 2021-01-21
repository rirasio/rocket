package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.service.ClassService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/classes/*")
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
	public String list() {
		log.info("list page");
		return "classes/list";
	}
	
	@GetMapping(value = { "/create" })
	public String create() {
		log.info("create page");
		return "classes/create";
	}


	@PostMapping(value = { "/create" })
	public String create(ClassVO classVO, RedirectAttributes rttr) {
		classService.create(classVO);
		rttr.addFlashAttribute("result", classVO.getClass_num());
		log.info("create complete");
		return "index";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("class_num") String class_num,
			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		log.info("read page");
		model.addAttribute("class", classService.read(class_num));
	}

	@PostMapping("/update")
	public String update(ClassVO classVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (classService.update(classVO)) {
			rttr.addAttribute("result", "success");
		}
		log.info("update complete");
		return "redirect:/classes/read?class_num=" + classVO.getClass_num();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("class_num") String class_num, @RequestAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (classService.delete(class_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		log.info("delete complete");
		return "redirect:/classes/list";
	}
}
