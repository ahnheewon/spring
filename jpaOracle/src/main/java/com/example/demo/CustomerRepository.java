package com.example.demo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface CustomerRepository	extends JpaRepository<Customer,	Long>{
				//비워있어도 잘 작동함.
	
	public List<Customer> findByName(String name);
	
	
}