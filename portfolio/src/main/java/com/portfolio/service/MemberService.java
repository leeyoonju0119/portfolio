package com.portfolio.service;

import org.apache.ibatis.annotations.Param;

import com.portfolio.domain.MemberVO;

public interface MemberService {

	// 회원가입
	void join(MemberVO vo);
	
	// 아이디 찾기
	String idCheck(String mbsp_id);
	
	// 로그인
	MemberVO login(String mbsp_id);
	
	// 현재 로그인한 시간 업데이트
	void now_visit(String mbsp_id);
	
	// 회원정보 수정
	void modify(MemberVO vo);

	// 비밀번호 변경
	void pwchange(String mbsp_id, String new_mbsp_password);

	// 회원탈퇴
	void delete(String mbsp_id);
}
