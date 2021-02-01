
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
import com.rocket.rocket.service.DoHwService;
import com.rocket.rocket.service.HwService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/hw")
@AllArgsConstructor
public class HwController {

	private HwService hwService;

	private DoHwService dohwService;

	@GetMapping(value = { "/create" })
	public void create() {
	}

	@PostMapping(value = { "/create" })
	public String create(HwVO hwvo, RedirectAttributes rttr) {
		hwService.create(hwvo);
		rttr.addFlashAttribute("result", hwvo.getNum());
		return "/lec/list";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("lec_num") long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		model.addAttribute("hw", hwService.read(num));
		model.addAttribute("dohw", dohwService.readList(hwService.read(num).getNum(), cri));
	}

	@PostMapping("/update")
	public String update(HwVO hwvo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (hwService.update(hwvo)) {
			rttr.addAttribute("result", "success");
		}
		log.info("update hwvo: " + hwvo);

		return "redirect:/lec/get?num=" + hwvo.getLec_num();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (hwService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/lec/list";// lec 게시판
	}
}
