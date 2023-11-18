package com.hyewon.Coop.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.Coop.service.ScheduleService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrProjectController {
	ScheduleService scheduleService;
	
	Rq rq;
	
	@Autowired
	public UsrProjectController(ScheduleService scheduleService, Rq rq) {
		this.scheduleService = scheduleService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/project/create")
	public String showProjectCreate() {
		return "user/project/create";
	}
	
	@RequestMapping("/user/project/work_create")
	public String showProejct_WorkCreate() {
		return "user/project/work_create";
	}
	
	@RequestMapping("/user/project/check")
	public String showProejctCheck() {
		return "user/project/check";
	}
	
	@RequestMapping("/user/project/modify")
	public String showProejctModify() {
		return "user/project/modify";
	}
	
	@RequestMapping("/user/project/delete")
	public String showProejctDelete() {
		return "user/project/delete";
	}
	
	
	
	@RequestMapping("/user/member/addSchedule")
	@ResponseBody
	public String addSchedule(int id,  String event_color, String event_date
, String event_name, String event_body) {
		
		if (Util.empty(event_date)) {
			return Util.jsHistoryBack("response 날짜를 선택해주세요");
		}
		
		if (Util.empty(event_name)) {
			return Util.jsHistoryBack("이벤트 이름을 입력해주세요");
		}
		
		if (Util.empty(event_body)) {
			return Util.jsHistoryBack("이벤트 내용을 입력해주세요");
		}
				
        scheduleService.addSchedule(id, rq.getLoginedMemberId(), event_date, event_name, event_body, event_color);
		
		return Util.jsReplace("일정이 추가되었습니다", "../member/schedule");
		
	}
	
	@RequestMapping("/user/member/schedule-modify")
	public String modifySchedule() {
		return "user/member/schedule-add";
	}
	
	@RequestMapping("/user/member/schedule-delete")
	public String deleteSchedule() {
		return "user/member/schedule-delete";
	}

}
