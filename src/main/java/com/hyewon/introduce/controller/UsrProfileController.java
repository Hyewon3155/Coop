package com.hyewon.introduce.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public String doJoin(MultipartFile photo, String name, String school, String depart, String phone1, String phone2, String phone3, String email) {
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
	    String filePath = "";
	    if (photo != null && !photo.isEmpty()) {
	        try {
	            // 프로필 사진을 저장할 디렉토리 경로 설정
	            String uploadDir = "C:\\KHW\\workspace\\Introduce\\reference_file";
	            
	            // 디렉토리가 존재하지 않으면 생성
	            File directory = new File(uploadDir);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }
	
	            String fileName = photo.getOriginalFilename();
	            filePath = uploadDir + File.separator + fileName;

	
	            // 파일 저장
	            photo.transferTo(new File(filePath));
	
	        } catch (IOException e) {
	            e.printStackTrace();
	            return Util.jsHistoryBack("프로필 사진 업로드에 실패했습니다.");
	        }
	    }

    // 프로필 정보 저장
    ResultData<Integer> doJoinRd = profileService.doJoin(name, school, depart, cellphoneNum, email, filePath);

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
	    

	 // 파일 경로에서 마지막 파일 이름 부분만 추출
	    int startIndex = profile.getFilePath().indexOf("\\reference_file\\");
	    String fileName = profile.getFilePath().substring(startIndex);
// 파일 이름 부분만 추출합니다.


		model.addAttribute("profile", profile);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		model.addAttribute("fileName", fileName);



		return "user/profile/modify";
	}
	

	@RequestMapping("/user/profile/doModify")
	@ResponseBody
	public String doModify(MultipartFile photo, String name, String school, String depart, String phone1, String phone2, String phone3, String email) {
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
	    String filePath = "";
	    if (photo != null && !photo.isEmpty()) {
	        try {
	            // 프로필 사진을 저장할 디렉토리 경로 설정
	            String uploadDir = "C:\\KHW\\workspace\\Introduce\\reference_file";
	            
	            // 디렉토리가 존재하지 않으면 생성
	            File directory = new File(uploadDir);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }
	
	            String fileName = photo.getOriginalFilename();
	            filePath = uploadDir + File.separator + fileName;

	
	            // 파일 저장
	            photo.transferTo(new File(filePath));
	            System.out.println(filePath);
	
	        } catch (IOException e) {
	            e.printStackTrace();
	            return Util.jsHistoryBack("프로필 사진 업로드에 실패했습니다.");
	        }
	    }

           profileService.doModify(name, school, depart, cellphoneNum, email, filePath);
		
           return Util.jsReplace("프로필 정보가 수정되었습니다", "/");
}
	
	
}



