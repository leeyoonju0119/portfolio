package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.ReviewVO;
import com.portfolio.dto.Criteria;

public interface ReviewService {

	List<ReviewVO> review_list(Criteria cri, int pro_num);
	
	int review_count(int pro_num);
	
	void create(ReviewVO vo);
	
	void modify(ReviewVO vo);
	
	void delete(Long rew_num);
}
