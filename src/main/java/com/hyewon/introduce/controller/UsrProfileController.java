package com.hyewon.introduce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyewon.introduce.service.ProfileService;
import com.hyewon.introduce.util.Util;
import com.hyewon.introduce.vo.Profile;
import com.hyewon.introduce.vo.ResultData;
@Controller
public class UsrProfileController {
	
	ProfileService profileService;
	
	
	@Autowired
	public UsrProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@RequestMapping("user/profile/create")
	public String join() {
		return "user/profile/create";
	}
	
	@RequestMapping("/user/profile/doJoin")
	@ResponseBody
	public String doJoin(String name, String school, String depart, String phone1, String phone2, String phone3, String email) {
	    // 이름, 학교, 학과, 전화번호, 이메일이 비어 있는지 확인
	    if (Util.empty(name)) {
	        return Util.jsHistoryBack("이름을 입력해주세요");
	    }
	    if (Util.empty(school)) {
	        return Util.jsHistoryBack("학교를 입력해주세요");
	    }
	    if (Util.empty(depart)) {
	        return Util.jsHistoryBack("학과를 입력해주세요");
	    }
	    if (Util.empty(phone1) || Util.empty(phone2) || Util.empty(phone3)) {
	        return Util.jsHistoryBack("전화번호를 입력해주세요");
	    }
	    if (Util.empty(email)) {
	        return Util.jsHistoryBack("이메일을 입력해주세요");
	    }
	    
	    String cellphoneNum = phone1 + "-" + phone2 + "-" + phone3;
	    // 프로필 사진이 있는지 확인하고 저장
	    

    // 프로필 정보 저장
    ResultData<Integer> doJoinRd = profileService.doJoin(name, school, depart, cellphoneNum, email);

    if (doJoinRd.isFail()) {
        return Util.jsHistoryBack(doJoinRd.getMsg());
    }

    return Util.jsReplace(doJoinRd.getMsg(), "/");
	}	

	@RequestMapping("/user/profile/modify")
	public String modify(Model model, int id) {

		Profile profile = profileService.getProfileById(id);
		String[] parts = profile.getCellphoneNum().split("-");
	    String phone1 = parts[0];
	    String phone2 = parts[1];
	    String phone3 = parts[2];


		model.addAttribute("profile", profile);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);



		return "user/profile/modify";
	}
	

	@RequestMapping("/user/profile/doModify")
	@ResponseBody
	public String doModify(String name, String school, String depart, String phone1, String phone2, String phone3, String email) {
	    // 이름, 학교, 학과, 전화번호, 이메일이 비어 있는지 확인
	    if (Util.empty(name)) {
	        return Util.jsHistoryBack("이름을 입력해주세요");
	    }
	    if (Util.empty(school)) {
	        return Util.jsHistoryBack("학교를 입력해주세요");
	    }
	    if (Util.empty(depart)) {
	        return Util.jsHistoryBack("학과를 입력해주세요");
	    }
	    if (Util.empty(phone1) || Util.empty(phone2) || Util.empty(phone3)) {
	        return Util.jsHistoryBack("전화번호를 입력해주세요");
	    }
	    if (Util.empty(email)) {
	        return Util.jsHistoryBack("이메일을 입력해주세요");
	    }
	    
	    String cellphoneNum = phone1 + "-" + phone2 + "-" + phone3;
	    // 프로필 사진이 있는지 확인하고 저장

           profileService.doModify(name, school, depart, cellphoneNum, email);
		
           return Util.jsReplace("프로필 정보가 수정되었습니다", "/");
}
	
	
}



