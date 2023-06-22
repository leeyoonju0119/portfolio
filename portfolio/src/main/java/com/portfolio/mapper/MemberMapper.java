package com.portfolio.mapper;


import org.apache.ibatis.annotations.Param;

import com.portfolio.domain.MemberVO;

public interface MemberMapper {

	// 회원가입
	void join(MemberVO vo);
	
	// 아이디 중복체크
	String idCheck(String mbsp_id);
	
	// 로그인, 회원수정폼
	MemberVO login(String mbsp_id);
	
	// 현재 로그인한 시간 업데이트
	void now_visit(String mbsp_id);
	
	// 회원수정
	void modify(MemberVO vo);
	
	// 비밀번호 변경
	void pwchange(@Param("mbsp_id") String mbsp_id, @Param("new_mbsp_password") String new_mbsp_password);

	void delete(String mbsp_id);

}
