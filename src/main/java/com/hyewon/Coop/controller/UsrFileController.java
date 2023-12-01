package com.hyewon.Coop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.service.FileService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Task;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrFileController {
	private FileService fileService;
	private Rq rq;
	
	public UsrFileController(FileService fileService, Rq rq) {
		this.fileService = fileService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/myWork/reference")
	public String showMyWorkRefernce(Model model, int id) {
		model.addAttribute("project_id", id);
		return "user/myWork/reference";
	}
	
	@RequestMapping("/user/myWork/doReference")
	@ResponseBody
	public String doReference(int project_id, String title, MultipartFile file, String body) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("제목을 입력해주세요");
		}

		if (Util.empty(body)) {
			return Util.jsHistoryBack("내용을 입력해주세요");
		}
		
		
		try {
			fileService.doReference(rq.getLoginedMemberId(), project_id, title, file, body);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int id = fileService.getLastInsertId();

		return Util.jsReplace(Util.f("작업물이 업로드되었습니다", id), "/");
	}
	

}

