package com.hyewon.Coop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.NoticeRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
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

	
}