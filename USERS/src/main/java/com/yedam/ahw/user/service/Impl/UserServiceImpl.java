package com.yedam.ahw.user.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.ahw.user.mapper.UserMapper;
import com.yedam.ahw.user.service.UserService;
import com.yedam.ahw.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper mapper;
	
	@Override
	public List<UserVO> selectUserList() {
		return mapper.selectUserList();
	}
	

}
