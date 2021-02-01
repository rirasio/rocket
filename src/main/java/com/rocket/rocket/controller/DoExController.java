
package com.rocket.rocket.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoExDTO;
import com.rocket.rocket.domain.DoExVO;
import com.rocket.rocket.service.DoExService;

import com.rocket.rocket.service.ExService;
import com.rocket.rocket.service.MyService;
import com.rocket.rocket.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/doex")
@AllArgsConstructor
@Slf4j
public class DoExController {

	private MyService myService;
	private DoExService doexService;
	private ExService exService;

	@GetMapping(value = { "/create" })
	public void create(DoExDTO doex, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();
		doex.setEmail(email);
		String nickname = myService.read(email).getNickname();
		doex.setNickname(nickname);

		double score = Math.round(Math.random() * 1000) / 10.0;
		doex.setScore(score);

		log.info("doex: " + doex.toString());
		model.addAttribute("doex", doex);

	}

	@PostMapping(value = { "/create" })
	public String create(DoExVO doex, RedirectAttributes rttr) {
		log.info("doex: " + doex.toString());
		doexService.create(doex);

		return "redirect:/ex/read?num=" + doex.getEx_num();

	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		model.addAttribute("doex", doexService.read(num));
		model.addAttribute("lec_num", exService.read(doexService.read(num).getEx_num()).getLec_num());
	}

	@PostMapping("/update")
	public String update(DoExDTO doex, RedirectAttributes rttr) {

		double score = Math.round(Math.random() * 1000) / 10.0;

		DoExVO doexvo = new DoExVO();
		doexvo.setEmail(doex.getEmail());
		doexvo.setContent(doex.getContent());
		doexvo.setEx_num(doex.getEx_num());
		doexvo.setNum(doex.getNum());
		doexvo.setScore(score);
		log.info(doexvo.toString());
		if (doexService.update(doexvo)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/";
//		return "redirect:/doex/read?num=" + doex.getNum();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, RedirectAttributes rttr) {
		if (doexService.delete(num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";// lec 게시판
	}

	@GetMapping("/list")
	public void list(long ex_num, Model model) {
		model.addAttribute("list", doexService.readList(ex_num));
		model.addAttribute("ex_num", ex_num);
	}
}
