
package com.rocket.rocket.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rocket.rocket.domain.Account;
import com.rocket.rocket.domain.AccountRole;
import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.HwVO;
import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.service.HwService;
import com.rocket.rocket.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/users/*")
@AllArgsConstructor
public class UserController {

	private UserService usersService;

	// 회원가입
	@GetMapping(value = { "/userSign" })
	public String create() {
		return "users/userSign";
	}

//	@PostMapping(value = { "/userSign" })
//	public String create(UsersVO usersvo, UserRoleVO userrolevo, RedirectAttributes rttr) {
//		usersService.create(usersvo, userrolevo);
//		rttr.addFlashAttribute("result", usersvo.getEmail());
//		return "/users/login";
//	}

	@PostMapping(value = { "/userSign" })
	public String create(Account account, AccountRole accountrole, RedirectAttributes rttr) {
		usersService.create(account, accountrole);
		rttr.addFlashAttribute("result", account.getId());
		return "/users/login";
	}

	// 회원수정
	@GetMapping({ "/update" })
	public String read() {
		return "/users/userUpdate";
	}

	@PostMapping("/update")
	public String update(UsersVO usersvo, UserRoleVO userrolevo, RedirectAttributes rttr) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		log.info("Now Login id : " + name);
		if (usersService.update(usersvo, userrolevo)) {
			rttr.addAttribute("result", "success");
		}
		log.info("usersVO: " + usersvo);
		return "redirect:/";
	}

	// 회원삭제
	@PostMapping("/delete")
	public String delete(@RequestParam("email") String email, RedirectAttributes rttr) {
		if (usersService.delete(email)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";
	}
}
