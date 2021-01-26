
package com.rocket.rocket.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
import com.rocket.rocket.domain.NoticeVO;
import com.rocket.rocket.service.NoticeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
@AllArgsConstructor
public class NoticeController {

	private NoticeService noticeService;

	
	@GetMapping(value = { "/create" })
	public void create() {
	}
    
	@PostMapping(value = { "/create" })
	public String create(NoticeVO noticevo, RedirectAttributes rttr) {
		noticeService.create(noticevo);
		rttr.addFlashAttribute("result", noticevo.getNum());
		return "/notice/list";
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num, @RequestAttribute(value = "cri", required = false) Criteria cri,
			Model model) {
		model.addAttribute("notice", noticeService.read(num));
	}

	@PostMapping("/update")
	public String update(NoticeVO noticevo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (noticeService.update(noticevo)) {
			rttr.addAttribute("result", "success");
		}
		log.info("update notice: " + noticevo);

		return "redirect:/notice/get?notice_num=" + noticevo.getNum();
	}
	



	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		if (noticeService.delete(num)) {
			log.info("delete notice_seq: " + num);
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list";// notice 게시판
	}
}
