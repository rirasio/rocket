package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.service.LecService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/lec")
@AllArgsConstructor
public class LecController {

	private final LecService service;
	
	@GetMapping("/list")
	public String list(@RequestParam("class_num") String param_class_num, Model model) {
		Long class_num = Long.parseLong(param_class_num);
		model.addAttribute("list", service.getList(class_num));
		model.addAttribute("param", param_class_num);
		return "lec/list";
	}
	
	@GetMapping("/create")
	public String create() {
		return "lec/create";
	}
	
	@PostMapping("/create")
	public String create(LecVO lecvo, @RequestParam("class_num") String classnum, RedirectAttributes rttr) {
		Long class_num = Long.parseLong(classnum);
		service.create(lecvo, class_num);
		rttr.addFlashAttribute("result", lecvo.getNum());
		return "redirect:/lec/list";
	}
	
	@GetMapping({"/read", "/update"})
	public void read(@RequestParam("num") Long num, Model model) {
		model.addAttribute("lecture", service.read(num));
	}
	
	@PostMapping("/update")
	public String update(LecVO lecvo, RedirectAttributes rttr) {
		if (service.update(lecvo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lec/list?class_num" + lecvo.getClass_num();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("num") Long num, RedirectAttributes rttr) {
		if (service.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lec/list";
	}

}
