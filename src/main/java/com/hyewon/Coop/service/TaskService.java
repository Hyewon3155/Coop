package com.hyewon.Coop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.TaskRepository;
import com.hyewon.Coop.vo.Task;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public void doCreate(int member_id, int project_id, String title, String body, String startDate, String endDate) {
		taskRepository.doCreate(member_id, project_id, title, body, startDate, endDate);
	}
	
	public int getLastInsertId() {
		return taskRepository.getLastInsertId();
	}

	public List<Task> getToDosByMemberId(int loginedMemberId) {
		return taskRepository.getToDosByMemberId(loginedMemberId);
	}

	public List<Task> getDonesByMemberId(int loginedMemberId) {
		return taskRepository.getDonesByMemberId(loginedMemberId);
	}

	public List<Task> sortByStartDateAsc(int loginedMemberId) {
		return taskRepository.sortByStartDateAsc(loginedMemberId);
	}

	public List<Task> sortByStartDateDesc(int loginedMemberId) {
		return taskRepository.sortByStartDateDesc(loginedMemberId);
	}

	public List<Task> sortByEndDateAsc(int loginedMemberId) {
		return taskRepository.sortByEndDateAsc(loginedMemberId);
	}

	public List<Task> sortByEndDateDesc(int loginedMemberId) {
		return taskRepository. sortByEndDateDesc(loginedMemberId);
	}

	public List<Task> getToDosForWork(int member_id, int project_id) {
		return taskRepository.getToDosForWork(member_id, project_id);
	}

	public List<Task> sortByStartDateAscMember(int member_id, int project_id) {
		return taskRepository.sortByStartDateAscMember(member_id, project_id);
	}

	public List<Task> sortByStartDateDescMember(int member_id, int project_id) {
		return taskRepository.sortByStartDateDescMember(member_id, project_id);
	}
	
	public List<Task> sortByEndDateAscMember(int member_id, int project_id) {
		return taskRepository.sortByEndDateAscMember(member_id, project_id);
	}
	
	public List<Task> sortByEndDateDescMember(int member_id, int project_id) {
		return taskRepository.sortByEndDateDescMember(member_id, project_id);
	}

	public void changeStatus(int toDoId, int newStatus) {
		taskRepository.changeStatus(toDoId, newStatus);

	}
	

}
