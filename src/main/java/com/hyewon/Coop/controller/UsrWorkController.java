package com.hyewon.Coop.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.service.StudyService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrWorkController {
	private StudyService studyService;
	private Rq rq;
	
	public UsrWorkController(StudyService studyService, Rq rq) {
		this.studyService = studyService;
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
	
	@RequestMapping("/user/myWork/modify")
	public String showMyWorkModify() {
		return "user/myWork/modify";
	}
	
	@RequestMapping("/user/myWork/delete")
	public String showMyWorkDelete() {
		return "user/myWork/delete";
	}
	
	@RequestMapping("/user/group/create")
	public String showGroupPage() {
		return "user/group/create";
	}
	
	@RequestMapping("/user/group/doWrite")
	@ResponseBody
	public String doWrite(int headCount, int status, String name, String body, String pw) {
		if (Util.empty(name)) {
			return Util.jsHistoryBack("그룹 이름을 입력해주세요");
		}

		if (Util.empty(body)) {
			return Util.jsHistoryBack("내용을 입력해주세요");
		}
		
	    studyService.createGroup(rq.getLoginedMember().getLoginId(), headCount, status, name, body, Util.sha256(pw));
		
	    int id = studyService.getLastInsertId();

		return Util.jsReplace(Util.f("%d번 그룹이 생성되었습니다", id), "/");
	}

}

