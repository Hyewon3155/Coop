package com.hyewon.Coop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.Coop.service.NoticeService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.ResultData;
import com.hyewon.Coop.vo.Rq;


@Controller
public class UsrNoticeController {
	
	NoticeService noticeService;
	
	Rq rq;
	
	@Autowired
	public UsrNoticeController(NoticeService noticeService, Rq rq) {
		this.noticeService = noticeService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/notice/write")
	public String join() {
		return "user/notice/write";
	}
	
	@RequestMapping("/user/notice/doWrite")
	@ResponseBody
	public String doJoin(String title, String body) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("제목 입력해주세요");
		}
		if (Util.empty(body)) {
			return Util.jsHistoryBack("내용 입력해주세요");
		}
		
	    noticeService.doWrite(rq.getLoginedMemberId(), title, body);
		
		int id = noticeService.getLastInsertId();
		
		return Util.jsReplace(Util.f("%d번 게시물이 생성되었습니다", id), Util.f("/"));


		
	}
	
	@RequestMapping("/user/notice/check")
	public String showList(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int noticesCnt = noticeService.getNoticeCount();

		int itemsInAPage = 10;

		int pagesCount = (int) Math.ceil((double) noticesCnt / itemsInAPage);

		List<Notice> notices = noticeService.getNotices(itemsInAPage, page);

		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("noticesCnt", noticesCnt);
		model.addAttribute("notices", notices);

		return "user/notice/check";
	}
	
	@RequestMapping("/user/notice/detail")
	public String showDetail(Model model, int id) {

        Notice notice = noticeService.getNoticeById(id);
        
		model.addAttribute("notice", notice);
	
		return "user/notice/detail";
	}
}



