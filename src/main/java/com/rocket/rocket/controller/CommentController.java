package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rocket.rocket.domain.CommVO;
import com.rocket.rocket.service.CommentService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
	
	private final CommentService service;
	
//	@GetMapping("/list")
//	@ResponseBody
//	public String create(@RequestParam("lec_num") Long lec_num, Model model) {
//			model.addAttribute("list", service.getList(lec_num));
//			model.addAttribute("class_num", lec_num);
//			return "lec/list";
//		}

}
