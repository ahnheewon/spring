package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService service;

	/*
	 * // 단건조회
	 * 
	 * @RequestMapping("/emp") public String emp(EmpVO vo, Model model,
	 * HttpServletRequest request) { logger.info("파라미터:" + vo.toString());
	 * model.addAttribute("emp", service.getEmp(vo)); return "emp/emp"; }
	 */

	// 목록
	@RequestMapping("/bookList")
	public String bookList(Model model) {
		model.addAttribute("list", service.getBookList());
		return "book/bookList";
	}

	
	//등록-폼
		@GetMapping("/bookInsert")
		public String insertForm(Model model,BookVO VO) {
			model.addAttribute("no",service.getMaxNo()); 
			
			// VO로 보낼지 아님 VO.객체 형태로 보내는지에 따라 
			// jsp쓰임새가 달라진다. ${no }로 쓰느냐, ${no.bookNo}로 쓰느냐..
			// 물론 후자가 더 다양한 값을 보낼 수 있어서 편하긴 함.
			
			return "book/bookInsertForm";
		}
		

	// 등록처리
	// @PostMapping("/bookInsert")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertBook(BookVO vo, RedirectAttributes ratt) {
		// 커맨드객체
		logger.debug(vo.toString());
		System.out.println(vo);
		service.insertBook(vo);
		ratt.addFlashAttribute("msg","도서등록이 완료되었습니다.");
		return "redirect:/bookList";
	}
	
	// 목록
	@RequestMapping("/rentList")
	public String rentList(Model model) {
		model.addAttribute("list", service.getRentList());
		return "book/rentList";
	}


}
