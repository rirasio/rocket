
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
@PreAuthorize("isAuthenticated()") //로그인 한 사람만 쓸수있도록
@Slf4j
public class MyPageController {

	private MyService myService;

	// 요기서 'update'는  read.html 에 "button[data-oper='update']" 에서 동작되고, myPage/update.html로 보낸다 
	// 업데이트는 무조건 post로 작동이되기 떄문에 ,,
	@GetMapping(value = { "/read", "update" }) //  슬레쉬 read 로 되어있는건 , void read라는 메소드 수행, Mypage/read.html 로간다 
	public void readaaa(Principal principal, Model model) { //메소드 이름과 무관,,,,,,,,,,,,,,,,,

		model.addAttribute("users", myService.read(principal.getName()));

		List<UserRoleVO> UserRoleVO = myService.myRole(principal.getName());
		for (UserRoleVO role : UserRoleVO) { // 권한 체크,,, 굿굿
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
