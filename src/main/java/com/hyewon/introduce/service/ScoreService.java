package com.hyewon.introduce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyewon.introduce.repository.ScoreRepository;
import com.hyewon.introduce.util.Util;
import com.hyewon.introduce.vo.ResultData;
import com.hyewon.introduce.vo.Score;

@Service
public class ScoreService {
	
	private ScoreRepository scoreRepository;
	
	@Autowired
	public ScoreService(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}


	public ResultData<Integer> doJoin(String name, String subject, int year, String semester, int credit, String rank,
			double grade) {
		scoreRepository.doJoin(name, subject, year, semester, credit, rank, grade);
		return ResultData.from("S-1", Util.f("%s 과목이 추가되었습니다", name), "name", scoreRepository.getLastInsertId());
	}


	public Score getScoreById(int id) {
		return scoreRepository.getScoreById(id);
	}


	public void doModify(int id, String name, String subject, String year, String semester, int credit, String rank, double grade) {
		scoreRepository.doModify(id, name, subject, year, semester, credit, rank, grade);
		
	}


	public List<Score> getTotalScores() {
		return scoreRepository.getTotalScores();
	}


	public List<Score> getYearAndSemester(int year, int semester) {
		return scoreRepository.getYearAndSemester(year, semester);
	}


	
}