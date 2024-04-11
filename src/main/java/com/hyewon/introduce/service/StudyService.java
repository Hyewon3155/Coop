package com.hyewon.introduce.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyewon.introduce.repository.StudyRepository;

@Service
public class StudyService {
	
	private StudyRepository studyRepository;

	@Autowired
	public StudyService(StudyRepository studyRepository) {
		this.studyRepository = studyRepository;
	}
	
	public void createGroup(String host, int headCount, int status, String name, String body, String pw) {
		studyRepository.createGroup(host, headCount, status, name, body, pw);
	}
	
	public int getLastInsertId() {
		return studyRepository.getLastInsertId();
	}
	

}
