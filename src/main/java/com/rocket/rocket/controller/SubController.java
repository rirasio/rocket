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

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.SubVO;
import com.rocket.rocket.service.SubService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/sub")
@AllArgsConstructor
public class SubController {

	private final SubService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",service.getList());
		return "sub/create";
	}

	@PostMapping(value = { "/create" })
	public String create(SubVO subvo, RedirectAttributes rttr) {
		service.create(subvo);
		rttr.addFlashAttribute("result", subvo.getNum());
		return "test";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num,
			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		model.addAttribute("hw", service.read(num));
	}

	@PostMapping("/update")
	public String update(SubVO subvo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (service.update(subvo)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/sub?num=" + subvo.getNum();// class num 필요함
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @RequestAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		if (service.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/sub?num=";// sub 상품 게시판 
	}
}
