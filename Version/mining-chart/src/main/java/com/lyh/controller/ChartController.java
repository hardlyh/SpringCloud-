package com.lyh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {
	
	
	
	@RequestMapping("/savePayInfo")
	public String savePayInfo() {
		return null;
	}	
	
	
	@RequestMapping("/profitList")
	public String profitList() {
		return "";
	}
	
	
	@RequestMapping("/payList")
	public String payList() {
		return "";
	}
}
