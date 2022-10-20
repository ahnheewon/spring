package com.yedam.java.emp;

import static org.junit.Assert.assertEquals;
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
	
	//@Test
	public void returnObjectTest() {
		assertNotNull(mapper);
		// 성공했다면 DB와 연결이 됐고 mapper가 생성됐다는 뜻.
	}
	
	//@Test
	public void empAllSelectTest() {
		List<EmpVO> empList= mapper.getEmpList();
		for(EmpVO empInfo : empList) {
			System.out.println(empInfo.getLastName());
		}
	}
	
	@Test
	public void empInserTest() {
		
		//employeeId는 selectKey로 지정되어있다.
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("go-dong");
		empVO.setLastName("kong");
		empVO.setEmail("kgdong@google.com");
		empVO.setPhoneNumber("010-1234-2222");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(15000);
		
		mapper.insertEmp(empVO);
		
	//	assertEquals(empVO.getEmployeeId(), 207);
		
	}
	
	
	//@Test
	public void updateEmpSalary() {
		int result = mapper.updateEmpSalary(207);
		assertEquals(result,1); // 1행 실행 완료, 에서 그 숫자 1 확인
	}
	
	//@Test
	public void deleteEmpInfoTest() {
		int result = mapper.deleteEmpInfo(207);
		assertEquals(result,1); // 1행 실행 완료, 에서 그 숫자 1 확인
	}
	
	//@Test
	public void updateEmpInfoTest() {
		EmpVO empVO = new EmpVO(); // 업데이트할 바구니 생성
		empVO.setEmployeeId(207);
		empVO.setFirstName("rO rO");
		//empVO.setLastName("Ki Ki"); 
		// 이렇게 필요한 부분만 업데이트도 가능하다
		empVO.setEmail("RoRo@naver.com");
		
		int result = mapper.updateEmpInfo(empVO);
		assertEquals(result,1); // 1행 실행 완료, 에서 그 숫자 1 확인
		
	}
	
	//@Test
	public void empSelectOne() {
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("Steven");
		EmpVO selected = mapper.getEmp(empVO);
		assertNotNull(selected);
	}
	
}
