package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.portfolio.domain.AdOrderDetailVO;
import com.portfolio.domain.OrderVO;
import com.portfolio.dto.Criteria;

public interface AdOrderMapper {

	List<OrderVO> orderList(@Param("cri") Criteria cri, @Param("sDate") String sDate, @Param("eDate") String eDate);
	
	int getTotalCount(@Param("cri") Criteria cri, @Param("sDate") String sDate, @Param("eDate") String eDate);
	
	List<AdOrderDetailVO> orderDetail(Long ord_code);
	
	void orderDetailProductDelete(@Param("ord_code") Long ord_code, @Param("pro_num") Integer pro_num);
	// 2)주문삭제
	void orderDelete(Long ord_code);
	// 1)주문상세상품삭제 (참조관계때문에 먼저 삭제해야 에러가 안남)
	void orderDetailDelete(Long ord_code);
	// 3)결제삭제
	void paymentDelete(Long ord_code);

}
