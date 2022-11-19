package com.prj.demo;

import java.util.List;

import lombok.Data;

@Data
public class UserListVO { // VO 안에 VO
	private List<UserVO> userlist;	
}
