package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.FortuneService;

@Controller
public class FortuneController {
	
	private final FortuneService fortuneService;
	
	
	@Autowired
	public FortuneController(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@RequestMapping("/fortune")
	public String start() {
		double fn = Math.random();
		String result;
		if (fn >= 0.7) {
			result = "大吉";
			fortuneService.saveFortuneResult(result);
			return "greatFortune.html";
		}else if (fn >= 0.4) {
			result = "中吉";
			fortuneService.saveFortuneResult(result);
			return  "middleFortune.html";
		}else if (fn >= 0.1) {
			result = "小吉";
			fortuneService.saveFortuneResult(result);
			return "smallFortunr.html";
		}else {
			result = "凶";
			fortuneService.saveFortuneResult(result);
			return "misFortune.html";
		}
	}
	@RequestMapping("/result")
	public String fortune_result() {
		return "result.html";
	}

}