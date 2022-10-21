package com.yedam.java.free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.java.free.service.FBVO;

public interface FBMapper {
		
		//전체조회
		public List<FBVO> getBoardList();
		
		//단건조회
		public FBVO getBoardInfo(FBVO fbvo);

		//등록
		public int insertBoard(FBVO fbVO);
		
		//수정
		public int updateBoard(FBVO fbVO);
		
		//삭제
		public int deleteBoard(@Param("bno")int boardNo); // 컬럼을 넘길 때는 bno

		//입력될 게시글 번호를 조회
		public FBVO getBoardNo();
		
}
