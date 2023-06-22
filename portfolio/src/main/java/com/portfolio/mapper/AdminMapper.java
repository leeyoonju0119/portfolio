package com.portfolio.mapper;

import com.portfolio.domain.AdminVO;

public interface AdminMapper {

	AdminVO admin_ok(String admin_id);
	
	void now_visit(String admin_id);
}
