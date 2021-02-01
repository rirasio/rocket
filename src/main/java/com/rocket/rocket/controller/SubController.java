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
import com.rocket.rocket.domain.SubVO;
import com.rocket.rocket.service.SubService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/sub")
@AllArgsConstructor
public class SubController {
                         
	private SubService service;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("subsub", service.getList());
		return "/notice/list";
	}

	@GetMapping(value={"/create"})  //  1.  local8080:asd/sub/create 이라고 들어오는 것에 대해서 
	public String create(Model model) {
		model.addAttribute("listlist",service.getList());
		return "sub/create"; // 2. sub 폴더 밑에 create.html 로 이동시킨다 
	}

	@PostMapping(value = { "/create" }) // 4. post방식으로 /sub/create 온것에 대해서 처리하는데, 
	public String create(SubVO subvo, RedirectAttributes rttr) {
		service.create(subvo);
		rttr.addFlashAttribute("result", subvo.getNum()); // "result"를 써준 이유: return 되는 페이지에 알람이나, 작은 팝업을 띄우는용도이자, 값이 잘넘어갔는지 확인용도 
		return "/sub/list"; //  앞에 슬레쉬 빠뜨리지말자ㅜㅜㅜㅜㅜ
	}

	@GetMapping({ "/read", "/update" })
	public void read(@RequestParam("num") long num,
			@RequestAttribute(value = "cri", required = false) Criteria cri, Model model) {
		log.info(" Get + /read + /update ,,,,,, ");
		model.addAttribute("sub", service.read(num));
	}
	
	

	@PostMapping("/update")
	public String update(SubVO subvo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if (service.update(subvo)) {
			log.info(" Post  + /update,,,, ");
			rttr.addAttribute("result", "success");
		}
		return "redirect:/sub?num=" + subvo.getNum();// have to add regidate in Pay table 
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("num") long num, @RequestAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		if (service.delete(num)) {
			log.info(" Post + /delete,,,,,, ");
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/sub?num=";// sub 상품 게시판 
	}
}
