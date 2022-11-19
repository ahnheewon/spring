package com.prj.demo;


import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestAjaxController {
		
	@RequestMapping("/userRegAjax")
	public void userRegAjax() {
		
	}
	
	@RequestMapping("/list")
	@ResponseBody // response에 contentType이 무조건 Json
				  // ajaxJQuery는 자동으로 Json 타입변환 해준다.
	public Map<String, String> list() {
		return Collections.singletonMap("name", "hong");
	
	}
	
	@RequestMapping("/regInsert")
	@ResponseBody // response에 contentType이 무조건 Json
				  // ajaxJQuery는 자동으로 Json 타입변환 해준다.
	public UserVO regInsert(UserVO vo) {
		System.out.println(vo);
		return vo;
	
	}
	
	/*
	@RequestMapping("/list")
	public String list() {
		return "main";
	
	}*/
}
