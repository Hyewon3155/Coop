package com.hyewon.Coop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.MemberRepository;
import com.hyewon.Coop.repository.ProjectMemberRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.ResultData;

@Service
public class ProjectMemberService {
    
	private ProjectMemberRepository projectMemberRepository;
	
	@Autowired
	public ProjectMemberService(ProjectMemberRepository projectMemberRepository) {
		this.projectMemberRepository = projectMemberRepository;
	}

	public void doManagerJoin(int project_id, int member_id) {
		projectMemberRepository.doManagerJoin(project_id, member_id);
		
	}

	public void join(int id, int project_id) {
		projectMemberRepository.join(id, project_id);
		
	}

	public void deleteProjectById(int id) {
		projectMemberRepository.deleteProjectById(id);
		
	}

	public List<Integer> getProjectMembers(int id) {
		return projectMemberRepository.getProjectMembers(id);
	}
	
	
}