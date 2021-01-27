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
	public String list(@RequestParam("class_num") Long class_num, Model model) {
		model.addAttribute("list", service.getList(class_num));
		model.addAttribute("class_num", class_num);
		return "lec/list";
	}
	
	@GetMapping("/create")
	public String create(@RequestParam("class_num") Long class_num, Model model) {
		model.addAttribute("class_num", class_num);
		return "lec/create";
	}
	
	@PostMapping("/create")
	public String create(LecVO lecvo, RedirectAttributes rttr) {
		service.create(lecvo);
		rttr.addFlashAttribute("result", lecvo.getNum());
		return "redirect:/classes/read?num=" + lecvo.getClass_num();
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
		return "redirect:/classes/read?num=" + lecvo.getClass_num();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("num") Long num, @RequestParam("class_num") String class_num, RedirectAttributes rttr) {
		if (service.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/classes/read?num=" + class_num;
	}
	
//	@GetMapping("/autocreate")
//	public void auto(LecVO lecvo) {
//		service.autoCreate(lecvo);
//	}

}
