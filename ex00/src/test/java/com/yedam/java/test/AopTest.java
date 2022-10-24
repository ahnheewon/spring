package com.yedam.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.test.service.Cats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AopTest {
	
	@Autowired
	Cats myCat;
	
	//@Test
	public void aopTest() {
		myCat.getName();
		System.out.println("===================================");
		
		System.out.println("1) ");
		System.out.println(myCat.getName());
		String catName = myCat.getName();
		
		System.out.println("2) ");
		System.out.println(catName);
	}
	
	@Test
	public void aopTest2() {
		myCat.printInfo();
		System.out.println("===================================");
		myCat.printData();
	}
}
