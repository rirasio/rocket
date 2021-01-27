
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

	@GetMapping("/list")
	public String list(@RequestParam("email") String email, Model model) {
		model.addAttribute("notice", noticeService.getList(email));
		return "/notice/list";
	}

// http://localhost:8080/notice/create 실행
	@GetMapping("/create")
	public void create() {
	}

// 공지 생성시 해당 num 을 통해서 공지로 보여지도록 설정 
	@PostMapping("/create")
	public String create(NoticeVO noticevo, RedirectAttributes rttr) {
		noticeService.create(noticevo);
//		rttr.addFlashAttribute("result", noticevo.getNum());
//		return "redirect:/notice/list?num="+ noticevo.getNum();
//		return "redirect:/notice/list?email=qqruqq@naver.com";
		return "redirect:/notice/list?email=" + noticevo.getEmail();
//		return "redirect:/notice/list?email=" + uservo.();

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

//		return "redirect:/notice/get?Num=" + noticevo.getNum();
		return "redirect:/notice/get?Num=" + noticevo.getNum();
	}

	@PostMapping("/delete")
	public String delete(NoticeVO noticevo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (noticeService.delete(noticevo.getNum())) {
			log.info("delete notice_seq: " + noticevo.getNum());
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list?email=" + noticevo.getEmail();// notice 게시판
	}
}
