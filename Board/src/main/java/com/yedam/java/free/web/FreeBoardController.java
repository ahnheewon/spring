package com.yedam.java.free.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Controller
@RequestMapping("freeBoard") 	// 경로가 너무 길어질 경우
								// 중간에 중분류를 만들면 update? delete? select? 완전히 구분됨.
								// 컨트롤러에 맵핑시킬때 request만 가능하다 (get,post불가)
public class FreeBoardController {
	
	@Autowired
	FBService fbService;
	
	//등록-폼
	@GetMapping("insert")
	public String insertForm(Model model) {
		model.addAttribute("no",fbService.getBoardNo());
		return "freeBoard/insertForm";
	}
	
	//등록-DB insert
	@PostMapping("insert")
	public String insertFreeBoard(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.insertBoardInfo(fbVO);
		ratt.addFlashAttribute("msg",result.get("result")+"건이 등록되었습니다.");
		return "redirect:list"; // 상대경로
	}
	
	//전체조회
	
	@GetMapping("list")
	public String selectFreeBoardList(Model model, @RequestParam(required = false) String msg) {
		model.addAttribute("boardList",fbService.selectBoardList());
		System.out.println("Message : "+msg);
		return "freeBoard/boardList";
	}
	
	//단건조회
	@GetMapping("info")
	public String selectBoardInfo(FBVO fbVO,Model model) {
		model.addAttribute("board",fbService.selectBoardInfo(fbVO));
		return "freeBoard/boardInfo";
	}
	//수정-폼
	
	//수정-DB update
	
	//삭제
	
}
