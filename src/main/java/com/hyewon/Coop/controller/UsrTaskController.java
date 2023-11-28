package com.hyewon.Coop.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.service.TaskService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrTaskController {
	private TaskService taskService;
	private Rq rq;
	
	public UsrTaskController(TaskService taskService, Rq rq) {
		this.taskService = taskService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/myWork/check")
	public String showMyWorkCheck() {
		return "user/myWork/check";
	}
	
	@RequestMapping("/user/myWork/create")
	public String showMyWorkCreate() {
		return "user/myWork/create";
	}
	
	
	@RequestMapping("/user/project/doWorkCreate")
	@ResponseBody
	public String doWorkCreate(int member_id, int project_id, String title, String body, String startDate, String endDate) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("작업명을 입력해주세요");
		}
		if (Util.empty(body)) {
			return Util.jsHistoryBack("작업 설명을 입력해주세요");
		}
		if (Util.empty(startDate)) {
			return Util.jsHistoryBack("시작 날짜를 입력해주세요");
		}
		if (Util.empty(endDate)) {
			return Util.jsHistoryBack("종료 날짜를 입력해주세요");
		}
		
	    taskService.doCreate(member_id, project_id, title, body, startDate, endDate);
		
		int id = taskService.getLastInsertId();
		
		return Util.jsReplace(Util.f("작업이 할당되었습니다"), Util.f("/"));


		
	}
	@RequestMapping("/user/myWork/modify")
	public String showMyWorkModify() {
		return "user/myWork/modify";
	}
	
	@RequestMapping("/user/myWork/delete")
	public String showMyWorkDelete() {
		return "user/myWork/delete";
	}
	

}

