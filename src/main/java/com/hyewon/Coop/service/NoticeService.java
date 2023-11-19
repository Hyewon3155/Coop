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
	
	public void doWrite(int memberId, String title, String body) {
		noticeRepository.doWrite(memberId, title, body);
	}
	
	public int getLastInsertId() {
		return noticeRepository.getLastInsertId();
	}
	
	public List<Notice> getNotices(int itemsInAPage, int page){
		
		int limitStart = (page - 1) * itemsInAPage;
		
		return noticeRepository.getNotices(limitStart, itemsInAPage);
	}

	public int getNoticeCount() {
		return noticeRepository.getNoticeCount();
	}

	public Notice getNoticeById(int id) {
		return noticeRepository.getNoticeById(id);
	}

	
}