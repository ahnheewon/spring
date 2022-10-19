package com.yedam.java.emp.mapper;

import com.yedam.java.emp.service.EmpVO;

public interface EmpMapper {
	 public EmpVO getEmp(EmpVO empVO);
	 // 인터페이스기 때문에 annotation 안씀.
}
