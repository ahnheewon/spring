package com.yedam.java.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;

@Service("empDAO") //이런식으로 이름 부여 가능
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper; // Mapper 호출
	
	@Override
	public List<EmpVO> selectAllEmp() {
		
		return empMapper.getEmpList();
	}

	@Override
	public EmpVO selectOneEmp(EmpVO empVO) {
		
		return empMapper.getEmp(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		
		// 특정한 멤버를 넣을 때 
		/* 
		double salary = empMapper.selectSalTable(empVO.getDepartmentId())
		empVO.setSalary(salary);
		empMapper.insertEmp(empVO);
		
		*/
		
		// 다량의 데이터를 넣을 때
		/* insertEmpInfo(List<EmpVO> empVO)  
			for(EmpVO empInfo : empVO) {
		}
		*/
		
		return empMapper.insertEmp(empVO);
	}

	@Override
	public int updateEmpSal(int empId) {
		
		return empMapper.updateEmpSalary(empId);
	}

	@Override
	public int deleteEmpInfo(int empId) {
		
		return empMapper.deleteEmpInfo(empId);
	}

}
