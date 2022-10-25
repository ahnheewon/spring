package com.yedam.ahw.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.ahw.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("userList")
	public String mainUserList(Model model) {
		
		model.addAttribute("userInfoList", service.selectUserList());
		
		return "user/userList";
	}
	
	@RequestMapping("adminUserList")
	public String adminUserList(Model model) {
		
		model.addAttribute("userInfoList", service.selectUserList());
		
		return "admin/userList";
	}
	
	@RequestMapping("adminLogin")
	public String adminLogin(Model model) { // 단순 페이지 이동
		return "admin/loginForm";
	}
	
	

	

}
