package com.hyewon.Coop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.NoticeRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.ResultData;

@Service
public class NoticeService {

	
	private NoticeRepository noticeRepository;
	
	@Autowired
	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	public void doWrite(int memberId, String company, String title, String body) {
		noticeRepository.doWrite(memberId, company, title, body);
	}
	
	public int getLastInsertId() {
		return noticeRepository.getLastInsertId();
	}
	
	public List<Notice> getNotices(int itemsInAPage, int page, String company){
		
		int limitStart = (page - 1) * itemsInAPage;
		
		return noticeRepository.getNotices(limitStart, itemsInAPage, company);
	}

	public int getNoticeCount(String company) {
		return noticeRepository.getNoticeCount(company);
	}

	public Notice getNoticeById(int id) {
		return noticeRepository.getNoticeById(id);
	}

	public ResultData actorCanMD(int loginedMemberId, Notice notice) {
		if(notice == null) {
			return ResultData.from("F-1", "해당 게시물은 존재하지 않습니다");
		}
		
		if (loginedMemberId != notice.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");	
		}
		
		return ResultData.from("S-1", "가능");
	}
	
	public void doModify(int id, String title, String body) {
		noticeRepository.doModify(id, title, body);
	}

	public void doDelete(int id) {
		noticeRepository.doDelete(id);
		
	}

	public List<Notice> getHomeNotices(String company) {
		return noticeRepository.getHomeNotices(company);
	}

	
}