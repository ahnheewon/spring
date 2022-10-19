package com.yedam.java.emp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 RunWith() 이용하기
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperTest {

	@Autowired
	EmpMapper empMapper;
    
    @Test
    public void getEmp() {
        EmpVO vo = new EmpVO();
        vo.setEmployee_id("100");
        EmpVO findVO = empMapper.getEmp(vo);
        System.out.println(findVO.getLast_name());
        assertEquals(findVO.getLast_name(),"Kingkong");
    }

	
}
