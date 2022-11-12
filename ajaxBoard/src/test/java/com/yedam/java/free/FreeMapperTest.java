package com.yedam.java.free;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.free.mapper.FBMapper;
import com.yedam.java.free.service.FBVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class FreeMapperTest {
	
	@Autowired
	FBMapper fbMapper;
	
	@Test
	public void freeBoardSelect() {
		FBVO fbvo = fbMapper.getBoardNo();
		
		assertNotNull(fbvo);
	}

}
