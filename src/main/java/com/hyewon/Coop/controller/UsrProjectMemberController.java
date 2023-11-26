package com.hyewon.Coop.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.Coop.service.ProjectMemberService;
import com.hyewon.Coop.service.ProjectService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrProjectMemberController {
	ProjectMemberService projectMemberService;
	
	Rq rq;
	
	@Autowired
	public UsrProjectMemberController(ProjectMemberService projectMemberService, Rq rq) {
		this.projectMemberService = projectMemberService;
		this.rq = rq;
	}
	
	public void doManagerJoin(int project_id, int member_id) {
		 projectMemberService.doManagerJoin(project_id, member_id);
	}
	

	
}
