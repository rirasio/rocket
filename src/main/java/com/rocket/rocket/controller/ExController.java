
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
import com.rocket.rocket.domain.ExVO;
import com.rocket.rocket.service.ExService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ex")
@AllArgsConstructor
public class ExController {


	private ExService exService;

	@GetMapping(value = { "/create" })
	public void create(ExVO ex, Model model) {
		model.addAttribute("ex", ex);
	}

	@PostMapping(value = { "/create" })
	public String create(ExVO ex, RedirectAttributes rttr) {
		exService.create(ex);
		return "redirect:/";
//		return "/lec/read?num=" + ex.getLec_num();
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		model.addAttribute("ex", exService.read(num));
	}

	@PostMapping("/update")
	public String update(ExVO ex, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (exService.update(ex)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/";
//		return "redirect:/lec/get?num=" + ex.getLec_num();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (exService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";
//		return "redirect:/lec/list";// lec 게시판
	}
}
