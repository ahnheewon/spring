package com.yedam.java.user.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.java.user.service.UserVO;

@Controller
public class UserController {

	@RequestMapping(value="inputForm",
					method= {RequestMethod.POST, RequestMethod.GET})
					// value로 경로 설정, method로 방식 설정.
	
	//post 방식은 주소 경로에 적은 데이터 값이 안보임.
	//get 방식은 주소 경로에 적은 데이터 값이 보임.
	
	public String inputForm() {
		return "inputForm";
	}
	// inputForm.jsp 에서 데이터를 받아온 action
	@RequestMapping("users") 
	
	// 1) 노가다 방식
	//public String process(UserVO userVO) {
		//System.out.println("이름 : " + userVO.getName());
		//System.out.println("나이 : " + userVO.getAge());
	
	// 2) 매개변수 방식(RequestParam)
//	public String process(@RequestParam String name,
//							@RequestParam int age) {
			/* form의 name 속성을 이용해서
				@RequestParam("name") String userName 
				@RequestParam("age") String userage
				이런 식으로도 가능. */
//		System.out.println(name+ ", " + age);
	// 3) map 방식
	public String process(@RequestParam Map<String, Object> map) {
		
		System.out.println(map.get("name")+ ", " +map.get("age"));
		return "";	
	}
	
	@RequestMapping("nameList")
	public String nameProcess(@RequestParam List<String> name) {
		for(String temp : name) {
			System.out.println(temp);
		}
//  주소창에 ~/java/nameList?name=김&name=나&name=박 이런식으로
		return "";
	}
	
	//배열인 경우,
	@RequestMapping("userList")
	//public String listProcess(UserListVO userList) {
	/*for(UserVO userVO : userList.getList()) {
		System.out.println("이름 : " + userVO.getName());
		System.out.println("나이 : " + userVO.getAge());
	}*/
	// 이번엔 객체를 이용해서 값을 받아보겠습니다.
	public String listProcess(@RequestBody List<UserVO> userList) {
		for(UserVO userVO : userList) {
			System.out.println("이름 : " + userVO.getName());
			System.out.println("나이 : " + userVO.getAge());
		}
		return "";
	}

}
