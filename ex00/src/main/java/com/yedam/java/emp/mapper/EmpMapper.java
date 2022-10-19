package com.yedam.java.emp.mapper;

import java.util.List;

import com.yedam.java.emp.service.EmpVO;

// @mapper를 쓰나 annotation을 붙이나 큰 차이가 없다.

public interface EmpMapper {
	
	//전체조회
	public List<EmpVO> getEmpList();
	
	//단건조회 : 조회 조건 - EmpVO
	public EmpVO getEmp(EmpVO empVO);
	
	//등록
	public int insertEmp(EmpVO empVO);
	
	//수정 : 연봉 10% 인상
	public int updateEmpSalary(int employeeId); // 인상률 고정할 예정
	
	//삭제
	public int deleteEmpInfo(int employeeId);
}
