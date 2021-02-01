
package com.rocket.rocket.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.rocket.domain.UserRoleVO;
import com.rocket.rocket.domain.UsersVO;
import com.rocket.rocket.service.MyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = { "/myPage" })
@AllArgsConstructor
@PreAuthorize("isAuthenticated()")
@Slf4j
public class MyPageController {

	private MyService myService;

	@GetMapping(value = { "/read", "/update" })
	public void read(Principal principal, Model model) {

		model.addAttribute("users", myService.read(principal.getName()));

		List<UserRoleVO> UserRoleVO = myService.myRole(principal.getName());
		for (UserRoleVO role : UserRoleVO) {
			if (role.getAuth_num().equals("0") || role.getAuth_num().equals("1")) {
				model.addAttribute("role_stu", "student");
			}
			if (role.getAuth_num().equals("2")) {
				model.addAttribute("role_tea", "teacher");
			}
			if (role.getAuth_num().equals("9")) {
				model.addAttribute("role_adm", "admin");
			}
		}

		model.addAttribute("take", myService.myTake(principal.getName()));
		model.addAttribute("ctgy", myService.myCtgy(principal.getName()));
		model.addAttribute("class", myService.myClass(principal.getName()));
	}

	@PostMapping(value = { "/update" })
	public String update(UsersVO users) {
		myService.update(users);
		return "redirect:/myPage/read";
	}
}
