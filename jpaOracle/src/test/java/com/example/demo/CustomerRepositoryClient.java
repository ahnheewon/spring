package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest // 알아서 dataSource 다 가져와요^^
public class CustomerRepositoryClient {
	
		@Autowired
		CustomerRepository repo;
		
		@Test
		public void findName() {
			List<Customer> list = repo.findByName("홍길동");
			System.out.println(list);
			assertEquals( list.get(0).getName()	,"홍길동");
		}
		@Test
		public void find() {
			Optional<Customer> cust = repo.findById(1L);
			System.out.println(cust);
			assertEquals( cust.get().getName()	,"홍길동");
		}
		
		@Test
		@Commit
		public void insert() {
			Customer cust = Customer.builder().name("홍길동").phone("222").build();
			repo.save(cust);
			
		}
}