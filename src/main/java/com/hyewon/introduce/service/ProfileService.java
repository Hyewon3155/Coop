package com.hyewon.introduce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.introduce.repository.ProfileRepository;
import com.hyewon.introduce.util.Util;
import com.hyewon.introduce.vo.Profile;
import com.hyewon.introduce.vo.ResultData;

@Service
public class ProfileService {
	
	@Value("${custom.siteName}")
	private String siteName;
	@Value("${custom.siteMainUri}")
	private String siteMainUri;
	
	private ProfileRepository profileRepository;
	
	@Autowired
	public ProfileService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}
	
	public ResultData<Integer> doJoin(String name, String school, String depart, String cellphoneNum, String email) {
		
		profileRepository.doJoin(name, school, depart, cellphoneNum, email);
		
		return ResultData.from("S-1", Util.f("%s님의 프로필이 생성되었습니다", name), "name", profileRepository.getLastInsertId());
	}
	
	public Profile getProfileById(int id) {
		return profileRepository.getProfileById(id);
	}
	
	public void doModify(String name, String school, String depart, String cellphoneNum,
			String email) {
		profileRepository.doModify(name, school, depart, cellphoneNum, email);
		
	}
	/*
	public Profile getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	private Profile getMemberByNickname(String nickname) {
		return memberRepository.getMemberByNickname(nickname);
	}

	public Profile getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}


	public void doModify(int loginedMemberId, String name, String nickname, String cellphoneNum, String email) {
		memberRepository.doModify(loginedMemberId, name, nickname, cellphoneNum, email);
	}
	*/

	
	
}