package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	//입력될 게시글 조회
	public int getMaxNo();
	
	public BookVO getBook(BookVO vo); 	//도서정보
	public List<BookVO> getBookList();	//전체도서조회
	int insertBook(BookVO vo); //도서입력
}

