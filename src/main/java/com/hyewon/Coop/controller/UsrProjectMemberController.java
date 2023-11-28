package com.hyewon.Coop.controller;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.Coop.service.MemberService;
import com.hyewon.Coop.service.ProjectMemberService;
import com.hyewon.Coop.service.ProjectService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrProjectMemberController {
	ProjectMemberService projectMemberService;
    MemberService memberService;
    Member member;
	Rq rq;
	
	@Autowired
	public UsrProjectMemberController(ProjectMemberService projectMemberService, MemberService memberService, Rq rq) {
		this.projectMemberService = projectMemberService;
		this.memberService = memberService;
		this.rq = rq;
	}
	
	public void doManagerJoin(int project_id, int member_id) {
		 projectMemberService.doManagerJoin(project_id, member_id);
	}
	
	@RequestMapping("/user/project/member")
	public String showJoinMember(Model model, int id) {
        
		model.addAttribute("project_id", id);
	
		return "user/project/member";
	}
	
	@RequestMapping("/user/project/searchMember")
	@ResponseBody
	public ResultData searchMember(@RequestParam(defaultValue = "") String searchKeywordType,
			@RequestParam(defaultValue = "") String searchKeyword) {
		
		if (Util.empty(searchKeywordType)) {
			return ResultData.from("F-1", "부서명을 설정해주세요");
		}
		if (Util.empty(searchKeyword)) {
			return ResultData.from("F-1", "회원명을 입력해주세요");
		}
		
		List<Member> members = memberService.getMemberByNameAndDepart(searchKeywordType, searchKeyword, rq.getLoginedMember().getCompany());
		
		if (members.isEmpty()) {
			return ResultData.from("F-2", "존재하지 않는 회원입니다");
		}
		
		return ResultData.from("S-1", "", "members", members);
	}
	
	
	@RequestMapping("/user/project/joinProjectMember")
	@ResponseBody
	public ResultData joinProjectMember(@RequestParam int memberId, @RequestParam int project_id) {
		
	     projectMemberService.join(memberId, project_id);
		 
		 return ResultData.from("S-1", "회원 추가 성공");
		 
	}
	
	@RequestMapping("/user/project/showMemberForWork")
	public String showMemberForWork(Model model, int id) {

        List<Integer> memberIds = projectMemberService.getProjectMembers(id);
        if(memberIds.isEmpty()) {
        	Util.f("멤버를 추가해주세요", "showMemberForWork");
        }
    	List<Member> members = new ArrayList<>();

        for (int memberId : memberIds) {
            Member member = memberService.getMemberById(memberId); // memberId에 대한 멤버 정보를 조회합니다.
            if (member != null) {
                members.add(member); // 조회된 멤버 정보를 members 리스트에 추가합니다.
            }
        }
        
		model.addAttribute("members", members);
		model.addAttribute("project_id", id);	
		return "user/project/showMemberForWork";
	}
	
	@RequestMapping("/user/project/check_member")
	public String check_member(Model model, int id) {

        List<Integer> memberIds = projectMemberService.getProjectMembers(id);
        if(memberIds.isEmpty()) {
        	Util.f("멤버를 추가해주세요", "check_member");
        }
    	List<Member> members = new ArrayList<>();

        for (int memberId : memberIds) {
            Member member = memberService.getMemberById(memberId); // memberId에 대한 멤버 정보를 조회합니다.
            if (member != null) {
                members.add(member); // 조회된 멤버 정보를 members 리스트에 추가합니다.
            }
        }
        
		model.addAttribute("members", members);
	
		return "user/project/check_member";
	}
	
	

	
}
