package com.hyewon.introduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrScoreController {
	
	@RequestMapping("/user/score/add")
	public String showAdd() {
		return "user/score/add";
	}
	
	@RequestMapping("/user/score/read")
	public String showRead() {
		return "user/score/read";
	}
	
}
