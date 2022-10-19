package com.yedam.java.emp;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
												//bean 등록할 때는 중복되지 않도록 해주세요.
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;
	
	@Before
	public void testDivid() {
		System.out.println("-------------------");
	}
	
	@Test
	public void returnObjectTest() {
		assertNotNull(mapper);
		// 성공했다면 DB와 연결이 됐고 mapper가 생성됐다는 뜻.
	}
	
	@Test
	public void empAllSelectTest() {
		List<EmpVO> empList= mapper.getEmpList();
		for(EmpVO empInfo : empList) {
			System.out.println(empInfo.getLastName());
		}
	}
}
