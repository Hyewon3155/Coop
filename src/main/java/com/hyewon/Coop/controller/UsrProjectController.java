package com.hyewon.Coop.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.Coop.service.ProjectMemberService;
import com.hyewon.Coop.service.ProjectService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrProjectController {
	
	ProjectService projectService;
	@Autowired
	ProjectMemberService projectMemberService;
	
	Rq rq;
	
	@Autowired
	public UsrProjectController(ProjectService projectService, Rq rq) {
		this.projectService = projectService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/project/create")
	public String showProjectCreate() {
		return "user/project/create";
	}
	
	@RequestMapping("/user/project/doCreate")
	@ResponseBody
	public String doCreate(String title, String body, String startDate, String endDate) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("프로젝트명을 입력해주세요");
		}
		if (Util.empty(body)) {
			return Util.jsHistoryBack("프로젝트 설명을 입력해주세요");
		}
		if (Util.empty(startDate)) {
			return Util.jsHistoryBack("시작 날짜를 입력해주세요");
		}
		if (Util.empty(endDate)) {
			return Util.jsHistoryBack("마감 날짜를 입력해주세요");
		}
		
	    projectService.doCreate(title, body, rq.getLoginedMemberId(), startDate, endDate);
	    projectMemberService.doManagerJoin(projectService.getLastInsertId(), rq.getLoginedMemberId());
	    return Util.jsReplace(Util.f("게시물이 생성되었습니다"), Util.f("/"));


		
	}
	
	@RequestMapping("/user/project/check")
	public String ProjectList(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int projectsCnt = projectService.getProjectCount(rq.getLoginedMemberId());
		int itemsInAPage = 6;
                                             
		int pagesCount = (int) Math.ceil((double) projectsCnt / itemsInAPage);

		List<Project> projects = projectService.getProjects(itemsInAPage, page, rq.getLoginedMemberId());
                                                              
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("projectsCnt", projectsCnt);
		model.addAttribute("projects", projects);

		return "user/project/check";
	}
	
	@RequestMapping("/user/project/joinMember")
	public String UserProjectList(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int projectsCnt = projectService.getProjetManagerCount(rq.getLoginedMemberId());
		int itemsInAPage = 6;
                                             
		int pagesCount = (int) Math.ceil((double) projectsCnt / itemsInAPage);

		List<Project> projects = projectService.getProjectsManager(itemsInAPage, page, rq.getLoginedMemberId());
                                                              
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("projectsCnt", projectsCnt);
		model.addAttribute("projects", projects);

		return "user/project/joinMember";
	}
	
	@RequestMapping("/user/project/work_create")
	public String showProejct_WorkCreate() {
		return "user/project/work_create";
	}
	
	@RequestMapping("/user/project/showDelete")
	public String showDelete(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int projectsCnt = projectService.getProjetManagerCount(rq.getLoginedMemberId());
		int itemsInAPage = 6;
                                             
		int pagesCount = (int) Math.ceil((double) projectsCnt / itemsInAPage);

		List<Project> projects = projectService.getProjectsManager(itemsInAPage, page, rq.getLoginedMemberId());
                                                              
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("projectsCnt", projectsCnt);
		model.addAttribute("projects", projects);

		return "user/project/showDelete";
	}
	
	@RequestMapping("/user/project/delete")
	@ResponseBody
	public String deleteProject(int id) {
		projectMemberService.deleteProjectById(id);
		projectService.deleteProject(id);
		return Util.jsReplace(Util.f("프로젝트를 삭제했습니다"), Util.f("showDelete"));

	}
	
	@RequestMapping("/user/project/modify")
	public String showModify(Model model, int id) {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		return "user/project/modify";

	}
	
	@RequestMapping("/user/project/doModify")
	@ResponseBody
	public String doModify(String title, String body, String startDate, String endDate) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("프로젝트명을 입력해주세요");
		}
		if (Util.empty(body)) {
			return Util.jsHistoryBack("프로젝트 설명을 입력해주세요");
		}
		if (Util.empty(startDate)) {
			return Util.jsHistoryBack("시작 날짜를 입력해주세요");
		}
		if (Util.empty(endDate)) {
			return Util.jsHistoryBack("마감 날짜를 입력해주세요");
		}
		
	    projectService.doModify(title, body, startDate, endDate);
	    return Util.jsReplace(Util.f("게시물이 수정되었습니다"), Util.f("check"));


		
	}
	@RequestMapping("/user/project/showWorkCreate")
	public String showWorkCreate(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int projectsCnt = projectService.getProjetManagerCount(rq.getLoginedMemberId());
		int itemsInAPage = 6;
                                             
		int pagesCount = (int) Math.ceil((double) projectsCnt / itemsInAPage);

		List<Project> projects = projectService.getProjectsManager(itemsInAPage, page, rq.getLoginedMemberId());
                                                              
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("projectsCnt", projectsCnt);
		model.addAttribute("projects", projects);

		return "user/project/showWorkCreate";
	}
	
	
	
}
