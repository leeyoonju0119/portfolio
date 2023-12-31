package com.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor // 모든 변수들을 매개변수로 받는 생성자를 알아서 생성해준다.
public class EmailDTO {

	private String senderName; // 발신자 이름
 	private String senderMail; // 발신자 메일주소
	private String receiverMail; // 수신자 메일주소, 즉 회원메일 주소로 사용
	private String subject; // 제목
	private String message; // 본문내용
	
	public EmailDTO() {
		this.senderName = "ShoppingMall";
		this.senderMail = "ShoppingMall";
		this.subject = "ShoppingMall 회원가입 메일인증코드입니다.";
		this.message = "메일인증을 위한 인증코드를 확인하시고, 회원가입시 인증코드 입력란에 입력하세요.";
	}
	
}
