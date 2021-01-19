package com.rocket.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.service.HwService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/hw/*")
//@MapperScan(basePackages = { "mapper" })
@AllArgsConstructor
public class HwController {

	private HwService hwService;

	@GetMapping(value = { "/registerHw" })
	public String registerHw() {
		return "hw/registerHw";
	}

	@PostMapping(value = { "/registerHw" })
	public String registerHw(HwVO hwvo, RedirectAttributes rttr) {
		hwService.register(hwvo);
		rttr.addFlashAttribute("result", hwvo.getHw_num());
		return "test";
	}

}
