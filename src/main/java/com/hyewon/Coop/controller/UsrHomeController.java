package com.hyewon.Coop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyewon.Coop.service.NoticeService;
import com.hyewon.Coop.service.TaskService;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.Rq;


@Controller
public class UsrHomeController {
	   @Autowired
	   private TaskService taskService;
	   @Autowired
	   private NoticeService noticeService;
	   @Autowired
	   Rq rq;
	
	@RequestMapping("/user/home/main")
	public String homeMain() {
		return "user/home/main";
	}
	@RequestMapping("/")
	public String showRoot() {
		// redirect로 해야함 
		// 1. 사용자가 링크를 클릭 (클라이언트가 서버에 요청)
		// 2. 서버가 클라이언트에 Redirect 주소 보냄
		// 3. 클라이언트는 서버에게 받은 새로운 주소로 재요청
		// 4. 서버 응답
		
		// 서버로부터 확인하고 재응답 해줌(앞의 부모 부분이 자동으로 채워짐)
		// request와 response 객체가 새롭게 생성됨
		// detail 부분 처리할 때 앞의 경로를 굳이 적지 않아도 됨 
		// /로 들어가면 /usr/home/main 으로 이동 
		// url 부분이 /가 아니라 /usr/home/main이 됨 
		return "redirect:user/home/main";
	}
	
	@RequestMapping("/user/member/home")
	public String showHome(Model model) {
		List<Notice> notices = noticeService.getHomeNotices(rq.getLoginedMember().getCompany());
		model.addAttribute("notices", notices);
		return "user/member/home";
	}
}
