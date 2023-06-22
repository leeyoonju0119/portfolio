package com.portfolio.service;

import com.portfolio.domain.OrderVO;
import com.portfolio.domain.PaymentVO;

public interface OrderService {

	// 주문정보
	void order_save(OrderVO o_vo, PaymentVO p_vo);
	
	
}
