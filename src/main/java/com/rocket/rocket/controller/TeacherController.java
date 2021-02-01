package com.rocket.rocket.controller;

import java.security.Principal;

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
import com.rocket.rocket.service.MyService;
import com.rocket.rocket.service.TeacherService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/teachers")
@AllArgsConstructor
@Slf4j
public class TeacherController {

	private TeacherService teacherService;
	private MyService myService;

	// 디폴트 리스트
	@GetMapping(value = { "/list" })
	public String list(Model model) {

		log.info("list page");
		model.addAttribute("teacherlist", teacherService.teacherList());

		return "teachers/list";
	}

	// 선생님 소개페이지로 이동
	@GetMapping("/read")
	public void read(
			@RequestParam("name") String name,
			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		
		log.info("read page");
		
		model.addAttribute("teacher", teacherService.read(name));
		model.addAttribute("class", myService.myClass(teacherService.read(name).getEmail()));
		
		

	}

}
