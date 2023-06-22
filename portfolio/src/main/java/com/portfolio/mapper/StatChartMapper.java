package com.portfolio.mapper;

import java.util.List;
import java.util.Map;

import com.portfolio.dto.StatChartDTO;

public interface StatChartMapper {

	public List<StatChartDTO> firstCategoryOrderPrice();
	
	public List<Map<String, Object>> firstCategoryChart();
}
