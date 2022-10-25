package com.yedam.ahw.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	
	private String userId;
	private String userName;
	private String userPassword;
	private String userNick;
	private String userPhone;
	private String userEmail;
	private char userType;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date userDate;
	
}
