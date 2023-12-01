package com.hyewon.Coop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.service.TaskService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Task;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;
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
	public String showMyWorkCheck(Model model) {
		List<Task> toDos = taskService.getToDosByMemberId(rq.getLoginedMemberId());
		List<Task> Dones = taskService.getDonesByMemberId(rq.getLoginedMemberId());

        model.addAttribute("toDos", toDos);
        model.addAttribute("Dones", Dones);
		
		return "user/myWork/check";
	}
	
	@RequestMapping("/user/myWork/sortByStartDateAsc")
	@ResponseBody
	public ResultData sortByStartDateAsc(Model model) {
		List<Task> toDos = taskService.sortByStartDateAsc(rq.getLoginedMemberId());
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByStartDateAscMember")
	@ResponseBody
	public ResultData sortByStartDateAscMember(Model model, int member_id, int project_id) {
		List<Task> toDos = taskService.sortByStartDateAscMember(member_id, project_id);
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByStartDateDesc")
	@ResponseBody
	public ResultData sortByStartDateDesc(Model model) {
		List<Task> toDos = taskService.sortByStartDateDesc(rq.getLoginedMemberId());
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByStartDateDescMember")
	@ResponseBody
	public ResultData sortByStartDateDescMember(Model model, int member_id, int project_id) {
		List<Task> toDos = taskService.sortByStartDateDescMember(member_id, project_id);
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByEndDateAsc")
	@ResponseBody
	public ResultData sortByEndDateAsc(Model model) {
		List<Task> toDos = taskService.sortByEndDateAsc(rq.getLoginedMemberId());
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByEndDateAscMember")
	@ResponseBody
	public ResultData sortByEndDateAscMember(Model model, int member_id, int project_id) {
		List<Task> toDos = taskService.sortByEndDateAscMember(member_id, project_id);
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByEndDateDesc")
	@ResponseBody
	public ResultData sortByEndDateDesc(Model model) {
		List<Task> toDos = taskService.sortByEndDateDesc(rq.getLoginedMemberId());
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/sortByEndDateDescMember")
	@ResponseBody
	public ResultData sortByEndDateDescMember(Model model, int member_id, int project_id) {
		List<Task> toDos = taskService.sortByEndDateDescMember(member_id, project_id);
		if (toDos.isEmpty()) {
			return ResultData.from("F-2", "불러오는 것에 실패하였습니다.");
		}
		model.addAttribute("toDos", toDos);
		return ResultData.from("S-1", "", "toDos", toDos);

	}
	
	@RequestMapping("/user/myWork/changeStatus")
	@ResponseBody
	public ResultData changeStatus(int toDoId, int newStatus) {
		taskService.changeStatus(toDoId, newStatus);
		
		return ResultData.from("S-1", "완료했습니다");
		
	}
	
	@RequestMapping("/user/myWork/create")
	public String showMyWorkCreate() {
		return "user/myWork/create";
	}
	

	@RequestMapping("/user/project/work_create")
	public String showProejct_WorkCreate(Model model, int member_id, int project_id) {
		model.addAttribute("member_id", member_id);
		model.addAttribute("project_id", project_id);
		return "user/project/work_create";
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
	
	@RequestMapping("/user/myWork/workForModify")
	public String workForModify(Model model, int member_id, int project_id) {
		List<Task> toDos = taskService.getToDosForWork(member_id, project_id);

        model.addAttribute("toDos", toDos);
        model.addAttribute("member_id", member_id);
        model.addAttribute("project_id", project_id);
		return "user/myWork/workForModify";
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

