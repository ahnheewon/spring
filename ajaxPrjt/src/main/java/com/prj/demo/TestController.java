package com.prj.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class TestController {
	
	
	@GetMapping("/main")
	public void main() {	
		
	}
	
	@GetMapping("/userReg")
	public void userRegForm() {	
		//return "userReg";
	}
	
	@PostMapping("/userRegProc")
	public String userRegProc(UserVO vo,
							  MultipartFile pic,
							  RedirectAttributes rttr) throws IllegalStateException, IOException {
		// 리다이렉트 했을때도 값 넘겨주고 싶을때 RedirectAttributes
		// 리다이렉트는 get방식밖에 안됩니다.
		
		// 파일 첨부 안하면 에러나므로 있는 경우만 조건을 붙여줌. 
		if(pic != null && pic.getSize()>0) {
			// 파일명 중복 처리
			String fname =pic.getOriginalFilename();
			// 파일을 정해준 폴더로 이동
			File dest = new File("d:/upload",fname);
			pic.transferTo(dest);
			vo.setPicName(fname);
			
		}
		
		log.info(vo);

		rttr.addAttribute("page", 1); // param.page
		rttr.addAttribute("search", "title"); // param.search
		rttr.addFlashAttribute("msg","등록완료"); // param 적을 필요가 없음.
		// addFlashAttribute => 새로고침하면 사라지는 휘발성이 있음.
		return "redirect:/main";
	}
	
	@GetMapping("/userRegParam")
	public String userRegParam(@RequestParam(required = false, defaultValue = "admin")
								String name,
								int age) {
		log.info(name);
		log.info(age);
		//System.out.println(vo); // 언제 어디에서 에러가 났는지 알 수 있다
		return "userReg";
	}
	
	@GetMapping("/userRegArray")
	public String userRegArray(@RequestParam List<String> hobby) {
		log.info(hobby);
		return "userReg";
	}
	
	@GetMapping("/userRegListVO")
	public String userRegListVO(UserListVO list) {
		log.info(list);
		return "userReg";
	}
}
