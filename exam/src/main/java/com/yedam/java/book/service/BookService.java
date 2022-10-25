package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	
	// 등록할 게시글 번호
	public int getMaxNo();
	
	public BookVO getBook(BookVO vo); 	//도서정보
	public List<BookVO> getBookList();	//전체도서조회
	public List<RentVO> getRentList();	//대여현황조회
	int insertBook(BookVO vo); //도서입력
	
}

