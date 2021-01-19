package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.LecVO;
import com.rocket.rocket.service.lec.LecService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/lec/*")
@AllArgsConstructor
public class LecController {

	private final LecService lecService;
	
	@GetMapping(value = {"/registerLec"})
	public String registerLec() {
		return "lec/registerLec";
	}
	
	@PostMapping(value = {"/registerLec"})
	public String registerLec(LecVO lecvo, RedirectAttributes rttr) {
		lecService.register(lecvo);
		rttr.addFlashAttribute("result", lecvo.getLec_num());
		return "test";
	}

}
