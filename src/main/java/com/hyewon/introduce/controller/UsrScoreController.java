package com.hyewon.introduce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.introduce.service.ScoreService;
import com.hyewon.introduce.util.Util;
import com.hyewon.introduce.vo.ResultData;
import com.hyewon.introduce.vo.Score;

@Controller
public class UsrScoreController {
	

	ScoreService scoreService;
	
	
	@Autowired
	public UsrScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@RequestMapping("/user/score/add")
	public String showAdd() {
		return "user/score/add";
	}
	
	@RequestMapping("/user/score/doJoin")
	@ResponseBody
	public String doJoin(String name, String subject, int year, String semester, int credit, String rank, double grade) {
	    // 이름, 학교, 학과, 전화번호, 이메일이 비어 있는지 확인
	    if (Util.empty(name)) {
	        return Util.jsHistoryBack("과목명을 입력해주세요");
	    }
	    if (Util.empty(subject)) {
	        return Util.jsHistoryBack("이수구분을 선택해주세요");
	    }
	    if (Util.empty(semester)) {
	        return Util.jsHistoryBack("학기를 선택해주세요");
	    }
	    if (Util.empty(rank)) {
	        return Util.jsHistoryBack("등급을 입력해주세요");
	    }
	    

    // 프로필 정보 저장
    ResultData<Integer> doJoinRd = scoreService.doJoin(name, subject, year, semester, credit, rank, grade);

    if (doJoinRd.isFail()) {
        return Util.jsHistoryBack(doJoinRd.getMsg());
    }

    return Util.jsReplace(doJoinRd.getMsg(), "/");
	}	
	
	@RequestMapping("/user/score/read")
	public String showRead(Model model) {
		List<Score> totalScores = scoreService.getTotalScores();
		
		model.addAttribute("totalScores", totalScores);
		return "user/score/read";
	}
	
	
	@RequestMapping("/user/score/modify")
	public String modify(Model model, int id) {
		return "user/score/modify";
	}
	
	@RequestMapping("/user/score/doModify")
	@ResponseBody
	public String doModify(int id, String name, String subject, String semester, int credit, String rank, double grade) {
	    // 이름, 학교, 학과, 전화번호, 이메일이 비어 있는지 확인
	    if (Util.empty(name)) {
	        return Util.jsHistoryBack("과목명을 입력해주세요");
	    }
	    if (Util.empty(subject)) {
	        return Util.jsHistoryBack("이수구분을 선택해주세요");
	    }
	    if (Util.empty(semester)) {
	        return Util.jsHistoryBack("학기를 선택해주세요");
	    }
	    if (Util.empty(rank)) {
	        return Util.jsHistoryBack("등급을 입력해주세요");
	    }
	    
	    scoreService.doModify(id, name, subject, semester, credit, rank, grade);

		
        return Util.jsReplace("성적 정보가 수정되었습니다", "/");


	}	
	
}
