
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
import com.rocket.rocket.domain.DoHwVO;
import com.rocket.rocket.domain.PageDTO;
import com.rocket.rocket.service.DoHwService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dohw")
@AllArgsConstructor
public class DoHwController {

	private DoHwService dohwService;

	@GetMapping(value = { "/create" })

	public void create(DoHwVO dohw, Model model) {
		model.addAttribute("dohw", dohw);

	}

	@PostMapping(value = { "/create" })
	public String create(DoHwVO dohw, RedirectAttributes rttr) {
		dohwService.create(dohw);
		rttr.addFlashAttribute("result", dohw.getNum());
		return "redirect:/dohw/list";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		model.addAttribute("dohw", dohwService.read(num));
	}

	@PostMapping("/update")
	public String update(DoHwVO dohw, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (dohwService.update(dohw)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/dohw/read?num=" + dohw.getNum();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @ModelAttribute(value = "cri") Criteria cri,
			RedirectAttributes rttr) {
		if (dohwService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";// lec 게시판
	}

	@GetMapping("/list")
	public void list(@RequestParam("hw_num") long hw_num, Criteria cri, Model model) {
		model.addAttribute("list", dohwService.readList(hw_num, cri));
		int total = dohwService.getTotal(cri);
		model.addAttribute("hw_num", hw_num);
	}
}
