package com.yedam.java.emp.service;

import java.util.List;

public interface EmpService { 
	// 서비스 로직은 mapper랑 별개입니다. 헷갈리지 않도록 명명 다르게 하고 있음.
	// 인터페이스는 bean으로 등록 안됩니다.
	// 이 인터페이스로 구현된 클래스가 bean으로 등록 가능한 것임. -> EmpServiceImpl.java
	
	//전체조회
	public List<EmpVO> selectAllEmp();
	
	//단건조회
	public EmpVO selectOneEmp(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	//수정
	public int updateEmpSal (int empId);
	
	//삭제
	public int deleteEmpInfo(int empId);
	
}
