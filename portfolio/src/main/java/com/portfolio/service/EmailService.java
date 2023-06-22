package com.portfolio.service;

import com.portfolio.dto.EmailDTO;

public interface EmailService {

	void sendMail(EmailDTO dto, String message);
	
}
