package com.hyewon.Coop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.ProjectRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;

@Service
public class ProjectService {

	
	private ProjectRepository projectRepository;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public void doCreate(String title, String body, int manager, String startDate, String endDate) {
		projectRepository.doCreate(title, body, manager, startDate, endDate);
	}
	
	public int getLastInsertId() {
		return projectRepository.getLastInsertId();
	}

	public int getProjectCount(int loginedMemberId) {
		return projectRepository.getProjectCount(loginedMemberId);

	}

	public Project getProjectById(int project_id) {
		return projectRepository.getProjectById(project_id);
	}

	public List<Project> getProjects(int itemsInAPage, int page, int loginedMemberId) {
		int limitStart = (page - 1) * itemsInAPage;
		return projectRepository.getProjects(limitStart, itemsInAPage, loginedMemberId);
	}

	public int getProjetManagerCount(int loginedMemberId) {
		return projectRepository.getProjectManagerCount(loginedMemberId);

	}

	public List<Project> getProjectsManager(int itemsInAPage, int page, int loginedMemberId) {
		int limitStart = (page - 1) * itemsInAPage;
		return projectRepository.getProjectsManager(limitStart, itemsInAPage, loginedMemberId);
	}

	public void deleteProject(int id) {
		projectRepository.deleteProject(id);
		
	}

	
	
}