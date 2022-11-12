package com.yedam.java.free;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	@Test
	public void test() {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder(); // 암호화?
		String pass = enco.encode("1111");
		System.out.println(pass);
		
		System.out.println(enco.matches("1111", pass)); // 순서 지키세요.

	}
}
