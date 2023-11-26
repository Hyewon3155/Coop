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
		
	    noticeService.doWrite(rq.getLoginedMemberId(), rq.getLoginedMember().getCompany(), title, body);
		
		int id = noticeService.getLastInsertId();
		
		return Util.jsReplace(Util.f("게시물이 생성되었습니다"), Util.f("/"));


		
	}
	
	@RequestMapping("/user/notice/check")
	public String showList(Model model,
			@RequestParam(defaultValue = "1") int page) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int noticesCnt = noticeService.getNoticeCount(rq.getLoginedMember().getCompany());

		int itemsInAPage = 10;

		int pagesCount = (int) Math.ceil((double) noticesCnt / itemsInAPage);

		List<Notice> notices = noticeService.getNotices(itemsInAPage, page, rq.getLoginedMember().getCompany());

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
	
	@RequestMapping("/user/notice/modify")
	public String modify(Model model, int id) {

		Notice notice = noticeService.getNoticeById(id);

		ResultData actorCanMD = noticeService.actorCanMD(rq.getLoginedMemberId(), notice);

		if (actorCanMD.isFail()) {
			return rq.jsReturnOnView(actorCanMD.getMsg(), true);
		}

		model.addAttribute("notice", notice);

		return "user/notice/modify";
	}
	
	@RequestMapping("/user/notice/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {

		Notice notice = noticeService.getNoticeById(id);

		ResultData actorCanModifyRd = noticeService.actorCanMD(rq.getLoginedMemberId(), notice);

		if (actorCanModifyRd.isFail()) {
			return Util.jsHistoryBack(actorCanModifyRd.getMsg());
		}

		noticeService.doModify(id, title, body);

		return Util.jsReplace(Util.f("%d번 게시물을 수정했습니다", id), Util.f("detail?id=%d", id));
	}
	
	@RequestMapping("/user/notice/delete")
	@ResponseBody
	public String doDelete(int id) {

		Notice notice = noticeService.getNoticeById(id);

		ResultData actorCanModifyRd = noticeService.actorCanMD(rq.getLoginedMemberId(), notice);

		if (actorCanModifyRd.isFail()) {
			return Util.jsHistoryBack(actorCanModifyRd.getMsg());
		}

		noticeService.doDelete(id);

		return Util.jsReplace(Util.f("%d번 게시물을 삭제했습니다", id), Util.f("check"));
	}
	
}



