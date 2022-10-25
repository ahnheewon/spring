package com.yedam.ahw.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.ahw.user.service.UserVO;

public interface UserMapper {

		//전체조회
		public List<UserVO> selectUserList();
		
		//관리자 전용 ↓↓↓
		
		//단건조회 : 조회 조건 - UserVO
		public UserVO getUser(UserVO vo);
		
		//등록
		public int insertUser(UserVO vo);
		
		//수정 : 회원 정보를 넘겨받아서 이름과, 성 이메일을 수정할 수 있는 메소드
		public int updateUserInfo(UserVO vo);
		
		//탈퇴
		public int deleteUserInfo(String userId);
}
