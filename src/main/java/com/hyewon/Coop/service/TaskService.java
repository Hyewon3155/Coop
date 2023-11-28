package com.hyewon.Coop.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.TaskRepository;

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
	

}
