package com.portfolio.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.EmailDTO;
import com.portfolio.service.EmailService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/email/*")
public class EmailController {

	@Setter(onMethod_ = {@Autowired})
	private EmailService emailService;
	
	// 메일인증코드 요청주소
	@GetMapping("/send") // 1)EmailDTO클래스의 기본생성자 호출, 사용자의 EMail주소는 receiverMail필드에 저장
	public ResponseEntity<String> send(EmailDTO dto, HttpSession session) { // EmailDTO 인증메일 보내고 받은 데이터를 HttpSession 저장후 맞다면 코드 실행
		
		log.info("메일정보: " + dto);
		
		ResponseEntity<String> entity = null;
		
		// 인증코드 생성 6자리 
		String authCode = "";
		for(int i=0; i<6; i++) {
			authCode += String.valueOf((int) (Math.random() * 10));
			
		}
		
		log.info("인증코드 : " + authCode);
		
		// 사용자가 인증코드를 입력시 비교하기위하여 발급해준 인증코드를 세션형태로 저장해두어야한다.
		session.setAttribute("authcode", authCode);
		
		// 인증코드 메일발송
		try {
			emailService.sendMail(dto, authCode);
			entity = new ResponseEntity<String>("success", HttpStatus.OK); // 200
		}catch (Exception ex) {
			ex.printStackTrace(); // printStackTrace - 예외발생 당시의 호출스택에 있었던 메서드의 정보와 예외 메시지를 출력
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); // 응답한다거나 알 수 없는 Exception 의 경우 INTERNAL_SERVER_ERROR(500)를 발생
		}
		
		return entity;
		
	}
	
	// 인증코드확인
	@GetMapping("/confirmAuthcode")
	public ResponseEntity<String> confirmAuthCode(String authcode, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		
		String confirm_authCode = (String) session.getAttribute("authcode"); // Attribute - 결과
		
		if(authcode.equals(confirm_authCode)) { // equals - 동일한
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			session.removeAttribute("authcode"); // 저장하기
		}else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
}
