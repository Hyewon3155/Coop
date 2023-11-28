package com.hyewon.Coop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hyewon.Coop.repository.MemberRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.ResultData;

@Service
public class MemberService {
	
	@Value("${custom.siteName}")
	private String siteName;
	@Value("${custom.siteMainUri}")
	private String siteMainUri;
	
	private MemberRepository memberRepository;
	private MailService mailService;
	
	@Autowired
	public MemberService(MemberRepository memberRepository, MailService mailService) {
		this.memberRepository = memberRepository;
		this.mailService = mailService;
	}
	
	public ResultData<Integer> doJoin(String loginId, String loginPw, String name, String company, String pw, int position, String depart, String nickname, String email, String cellphoneNum) {

		Member existsMember = getMemberByLoginId(loginId);
		
		if (existsMember != null) {
			return ResultData.from("F-7", Util.f("이미 사용중인 아이디(%s) 입니다", loginId));
		}
		
		existsMember = getMemberByNickname(nickname);
		
		if (existsMember != null) {
			return ResultData.from("F-8", Util.f("이미 사용중인 닉네임(%s) 입니다", nickname));
		}
		
		existsMember = getMemberByNameAndEmail(name, email);
		
		if (existsMember != null) {
			return ResultData.from("F-9", Util.f("이미 사용중인 이름(%s)과 이메일(%s) 입니다", name, email));
		}
		
		memberRepository.doJoin(loginId, loginPw, name, company, pw, position, depart, nickname, email, cellphoneNum);
		
		return ResultData.from("S-1", Util.f("%s님이 가입되었습니다", nickname), "nickname", memberRepository.getLastInsertId());
	}
	
	public Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	private Member getMemberByNickname(String nickname) {
		return memberRepository.getMemberByNickname(nickname);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

	public void doModify(int loginedMemberId, String name, String company, String pw, int position, String depart, String nickname, String cellphoneNum, String email) {
		memberRepository.doModify(loginedMemberId, name, company, pw, position, depart, nickname, cellphoneNum, email);
	}

	public void doPasswordModify(int loginedMemberId, String loginPw) {
		memberRepository.doPasswordModify(loginedMemberId, loginPw);
	}

	public ResultData notifyTempLoginPwByEmail(Member member) {

		String title = "[" + siteName + "] 임시 패스워드 발송";
		String tempPassword = Util.getTempPassword(8);
		String body = "<h1>임시 패스워드 : " + tempPassword + "</h1>";
		body += "<a style='font-size:4rem;' href=\"" + siteMainUri + "/user/member/login\" target=\"_blank\">로그인 하러가기</a>";

		ResultData sendRd = mailService.send(member.getEmail(), title, body);

		if (sendRd.isFail()) {
			return sendRd;
		}

		setTempPassword(member, tempPassword);

		return ResultData.from("S-1", "계정의 이메일주소로 임시 패스워드가 발송되었습니다");
	}

	private void setTempPassword(Member member, String tempPassword) {
		memberRepository.doPasswordModify(member.getId(), Util.sha256(tempPassword));
	}

	public Member getMemberByCompany(String company) {
		return memberRepository.getMemberByCompany(company);

	}

	public Member getMemberByCompanyAndPw(String company, String pw) {
		return memberRepository.getMemberByCompanyAndPw(company, pw);
	}

	public String isFirstMember(String company) {
		return memberRepository.isFirstMember(company);

	}

	public List<Member> getMemberByNameAndDepart(String searchKeywordType, String searchKeyword, String company) {
		return memberRepository.getMemberByNameAndDepart(searchKeywordType, searchKeyword, company);
	}

	
}