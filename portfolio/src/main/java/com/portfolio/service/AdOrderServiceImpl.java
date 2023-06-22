package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.domain.AdOrderDetailVO;
import com.portfolio.domain.OrderVO;
import com.portfolio.dto.Criteria;
import com.portfolio.mapper.AdOrderMapper;

import lombok.Setter;

@Service
public class AdOrderServiceImpl implements AdOrderService {

	@Setter(onMethod_ = {@Autowired})
	private AdOrderMapper adOrderMapper;

	

	@Override
	public List<AdOrderDetailVO> orderDetail(Long ord_code) {
		// TODO Auto-generated method stub
		return adOrderMapper.orderDetail(ord_code);
	}

	@Override
	public void orderDetailProductDelete(Long ord_code, Integer pro_num) {
		// TODO Auto-generated method stub
		adOrderMapper.orderDetailProductDelete(ord_code, pro_num);
	}

	@Override
	public List<OrderVO> orderList(Criteria cri, String sDate, String eDate) {
		// TODO Auto-generated method stub
		return adOrderMapper.orderList(cri, sDate, eDate);
	}

	@Override
	public int getTotalCount(Criteria cri, String sDate, String eDate) {
		// TODO Auto-generated method stub
		return adOrderMapper.getTotalCount(cri, sDate, eDate);
	}

	@Transactional // 처리해주기
	@Override
	public void orderInfoDelete(Long ord_code) {
		// TODO Auto-generated method stub
		// 주문상세삭제 먼저 해주기
		adOrderMapper.orderDetailDelete(ord_code);
		
		// 주문삭제
		adOrderMapper.orderDelete(ord_code);
		
		// 결제삭제
		adOrderMapper.paymentDelete(ord_code);
	}
}
