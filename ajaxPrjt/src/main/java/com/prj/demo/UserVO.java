package com.prj.demo;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private Integer age;
	private List<String> hobby;
	
	@JsonIgnore //Json변환 안할래요~ 알아서 빼줌.
	String picName; //단순한 파일 이름, pic로 지으면 안됩니다 타입에러
	//private MultipartFile pic;
	
	//java Date는 2022/11/19 이런 형태인데
	//sql Date는 2022-11-19 형태라서 통일 시켜줘야 합니다.
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date birth;
}
