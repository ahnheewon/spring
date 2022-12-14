package com.yedam.java.emp.service;

import java.util.Date; // sql은 단순히 데이터를 받아올 때 쓴다 ( 가공 불가)

import org.springframework.format.annotation.DateTimeFormat;

//util로 받아와야 가공 가능합니다.
import lombok.Data;
						
@Data
public class EmpVO {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	//	@DateTimeFormat -> 입력받는 포맷이 무엇인지 알려줌.
	//	default: yyyy/MM/dd
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
}