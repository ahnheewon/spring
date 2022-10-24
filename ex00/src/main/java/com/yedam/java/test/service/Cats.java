package com.yedam.java.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	public String getName() {
		System.out.println(this.name);
		return this.name;
	}
	
	public void printInfo() {
		System.out.println(this.getName() +", "
							+this.getAge() +", "
							+this.getColor());
		// this 사용.. 어드바이스의 존재조차 모름.
	}
	
	@Autowired
	Cats myCat;
	
	public void printData() {
		System.out.println(myCat.getName() +", "
							+myCat.getAge() +", "
							+myCat.getColor());
		
		// 인터페이스로 하니 aop 동작
	}
	
	
}
