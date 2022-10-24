package com.yedam.java.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookMapper, BookService {

	@Autowired
	BookMapper mapper;
	
	@Override
	public int insertBook(BookVO vo) {
		
		return mapper.insertBook(vo);
	}

	@Override
	public BookVO getBook(BookVO vo) {
		
		return mapper.getBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		
		return mapper.getBookList();
	}
	
	@Override
	public int getMaxNo() {
		
		return mapper.getMaxNo();
	}
	

}
