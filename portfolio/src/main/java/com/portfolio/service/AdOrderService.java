package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.AdOrderDetailVO;
import com.portfolio.domain.OrderVO;
import com.portfolio.dto.Criteria;

public interface AdOrderService {

	List<OrderVO> orderList(Criteria cri, String sDate, String eDate);
	
	int getTotalCount(Criteria cri, String sDate, String eDate);
	
	List<AdOrderDetailVO> orderDetail(Long ord_code);
	
	void orderDetailProductDelete(Long ord_code, Integer pro_num);
	
	void orderInfoDelete(Long ord_code);

}
