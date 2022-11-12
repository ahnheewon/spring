package com.yedam.java.free.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.free.mapper.FBMapper;
import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Service
public class FBServiceImpl implements FBService {

	@Autowired
	FBMapper fbMapper;
	
	@Override
	public int getBoardNo() {
		/*	
	 	FBVO fbVO = fbMapper.getBoardNo();
		int bno = fbVO.getBno();
		return bno; 
		이러한 세 줄을 한 문장으로 ... 
		*/
		
		return fbMapper.getBoardNo().getBno(); // 한 번 더 필드를 꺼내줘야 합니다.
	}

	@Override
	public List<FBVO> selectBoardList() {
		
		return fbMapper.getBoardList();
	}

	@Override
	public FBVO selectBoardInfo(FBVO fbVO) {
		// TODO Auto-generated method stub
		return fbMapper.getBoardInfo(fbVO);
	}

	@Override
	public Map insertBoardInfo(FBVO fbVO) {
		int count = fbMapper.insertBoard(fbVO);
		return getResult(count,fbVO);
	}

	@Override
	public Map updateBoardInfo(FBVO fbVO) {
		int count = fbMapper.updateBoard(fbVO);
		return getResult(count,fbVO);
	}

	@Override
	public Map deleteBoardInfo(FBVO fbVO) {
		int count = fbMapper.deleteBoard(getBoardNo());
		return getResult(count,fbVO);
		
	}
	
	public Map getResult(int count,FBVO fbVO) {
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("result", count);
		result.put("data", fbVO);
		return result;

	}

}
