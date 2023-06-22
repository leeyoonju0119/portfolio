package com.portfolio.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.portfolio.dto.StatChartDTO;

public interface StatChartService {

	public List<StatChartDTO> firstCategoryOrderPrice();
	
	public JSONObject firstCategoryChart();
	
	
}
