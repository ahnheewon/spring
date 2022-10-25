package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	
	public BookVO getBook(BookVO vo);
	
	public List<BookVO> getBookList();
	
	int insertBook(BookVO vo); //등록
	
	public List<RentVO> getRentList(); //대여
	
	//입력될 게시글 번호를 조회
	public int getMaxNo();

}
