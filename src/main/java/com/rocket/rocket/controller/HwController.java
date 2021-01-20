
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
import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.service.HwService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/hw/*")
@AllArgsConstructor
public class HwController {

	private HwService hwService;

	@GetMapping(value = { "/create" })
	public String create() {
		return "hw/create";
	}

	@PostMapping(value = { "/create" })
	public String create(HwVO hwvo, RedirectAttributes rttr) {
		hwService.create(hwvo);
		rttr.addFlashAttribute("result", hwvo.getHw_Num());
		return "test";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("hw_Num") String hw_Num,
			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		model.addAttribute("hw", hwService.read(hw_Num));
		log.info("hwvo: ");
	}

	@PostMapping("/update")
	public String update(HwVO hwvo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (hwService.update(hwvo)) {
			rttr.addAttribute("result", "success");
		}
		log.info("hwvo: " + hwvo);
		return "redirect:/lec?lec_num=" + hwvo.getLec_Num();// class num 필요함
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("hw_Num") String hw_Num, @RequestAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		if (hwService.delete(hw_Num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lec?lec_num=";// lec 게시판
	}
}
