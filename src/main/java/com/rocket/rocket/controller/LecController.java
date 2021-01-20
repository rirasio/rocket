package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.service.lec.LecService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/lecture")
@AllArgsConstructor
public class LecController {

	private final LecService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", service.getList());
		return "lecture/list";
	}
	
	@GetMapping(value = {"/register"})
	public String registerLec() {
		return "lecture/register";
	}
	
	@PostMapping(value = {"/register"})
	public String registerLec(LecVO lecvo, RedirectAttributes rttr) {
		service.register(lecvo);
		rttr.addFlashAttribute("result", lecvo.getLec_num());
		return "redirect:/lecture/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("lec_num") String lec_num, Model model) {
		model.addAttribute("lecture", service.get(lec_num));
	}
	
//	@GetMapping("/modify")
//	public String modify() {
//		return "lecture/modifyForm";
//	}
	
	@PostMapping("/modify")
	public String modify(LecVO lecvo, RedirectAttributes rttr) {
		if (service.modify(lecvo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lecture/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("lec_num") String lec_num, RedirectAttributes rttr) {
		if (service.remove(lec_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lecture/list";
	}

}
