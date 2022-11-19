package com.prj.cosm;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prj.demo.UserVO;

public class JsonTest {
	
	@Test
	public void test() throws JsonProcessingException {
		UserVO vo = new UserVO(); // java 객체
		vo.setName("홍길동");
		vo.setAge(20);
		vo.setBirth(new Date()); // java.sql.Date는 new Date() 못해요.
		/* "birth":1668829692571 이게 뭡니까??
		 => 1970년 1월 1일부터 하루를 1로 계산해서..  // System.currentTimeMillis()
		 => 정말 원초적인 날짜 데이터라서 @JsonFormat(pattern = "yyyy/MM/dd") 해줘야 합니다.
	    */

		
		// java 객체 -> json type
		// @ResponseBody와 같습니다.
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo); // 이것을 가장 많이 사용.
		
		System.out.println(result); // java 객체 -> json type으로 변환 완료!
		
		String jsonStr = "{\"name\":\"홍길동\",\"age\":20,\"hobby\":null,\"picName\":null,\"birth\":null}";
		// json구조의 String
		
		// json type -> java 객체
		// @RequestBody와 같습니다.
		UserVO userVO = om.readValue(jsonStr, UserVO.class); // java 객체로 변경 완료!
		
		System.out.println(userVO);
	
	
	}
}
