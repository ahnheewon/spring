package com.yedam.java.emp.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller // bean에 등록
public class EmpController {

	@Autowired
	EmpService empService;		//empDAO; //EmpServiceImpl의 @Service 이름으로 호출
	
	@RequestMapping("/allList")
	public String getEmpList(Model model) {
		
		model.addAttribute("empInfoList", empService.selectAllEmp());
		
		return "emp/empList";
	
	}
	
	@GetMapping("/info") // 통신이 get방식으로만 들어오게 제한
	public String getEmpInfo(EmpVO empVO,Model model) {
		EmpVO findEmp = empService.selectOneEmp(empVO); // model에 담아주는 값 (model은 request,response 같은 기능을 함.)
		model.addAttribute("empInfo",findEmp); // model을 이용해서 view에 전달
		return "emp/empInfo";
	}
	
	@GetMapping("insertForm")
	public String printInsertForm() {
		return "emp/insertForm";
		// 단순 페이지 전환용. -> void (근데 emp폴더 밑에 위치해서 void 사용불가..)
		
	}
	
	@PostMapping("insert")
	public String empInsert(EmpVO empVO,RedirectAttributes ratt) { 
	//insertForm에서 주는 데이터를 받아야 함.
	//EmpVO 형태로 받는게 편함.
	//이제 페이지 전환을 시켜줌. reDirect
		
		int result = empService.insertEmpInfo(empVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg","정상적으로 등록되었습니다.");
		}
		else {
			ratt.addAttribute("msg","등록 실패");
		}
		return "redirect:allList"; //상대경로
	}
	
	@PostMapping("updateSal")
	public String empUpdateSal(@RequestParam int employeeId, RedirectAttributes ratt) {
		
		int result = empService.updateEmpSal(employeeId);
		
		if (result == 1) {
			ratt.addFlashAttribute("msg","정상적으로 변경되었습니다.");
		}
		else {
			ratt.addAttribute("msg","변경 실패");
		}
		return "redirect:allList"; //상대경로
	}
	
	@GetMapping("delete/{empId}") // 필드에 담기는게 아님.
	@ResponseBody //비동기식으로 진행할거라서.
	public Map<String, String> empDelete(@PathVariable int empId) {
		
		int result = empService.deleteEmpInfo(empId);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if (result == 1 ) {
			map.put("msg","삭제 성공");
		}
		else {
			map.put("msg","삭제 실패");
		}
		return map;
	}
	
	
}
