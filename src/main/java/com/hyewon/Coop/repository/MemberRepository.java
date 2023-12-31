package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.Coop.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Insert("""
			INSERT INTO `member`
				SET regDate = NOW(),
					updateDate = NOW(),
					loginId = #{loginId},
					loginPw = #{loginPw},
					company = #{company},
					pw = #{pw},
					`position` = #{position},
					depart = #{depart},
					`name` = #{name},
					nickname = #{nickname},
					email = #{email},
					cellphoneNum = #{cellphoneNum}
			""")
	public void doJoin(String loginId, String loginPw, String name, String company, String pw, int position, String depart, String nickname, String email, String cellphoneNum);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
				FROM `member`
				WHERE id = #{id}
			""")
	public Member getMemberById(int id);

	@Select("""
			SELECT *
				FROM `member`
				WHERE loginId = #{loginId}
			""")
	public Member getMemberByLoginId(String loginId);

	@Select("""
			SELECT *
				FROM `member`
				WHERE name = #{name}
				AND email = #{email}
			""")

	public Member getMemberByNameAndEmail(String name, String email);

	@Update("""
			UPDATE `member`
				SET updateDate = NOW(),
					name = #{name},
					company = #{company},
					pw = #{pw},
					position = #{position},
					depart = #{depart},
					nickname = #{nickname},
					cellphoneNum = #{cellphoneNum},
					email = #{email}
				WHERE id = #{loginedMemberId}
			""")
	public void doModify(int loginedMemberId, String name, String company, String pw, int position, String depart, String nickname, String cellphoneNum, String email);

	@Select("""
			SELECT *
				FROM `member`
				WHERE nickname = #{nickname}
			""")
	public Member getMemberByNickname(String nickname);
	
	@Update("""
			UPDATE `member`
			   SET  updateDate = NOW(),
			        loginPw = #{loginPw}
			   WHERE id = #{loginedMemberId}
			""")
	public void doPasswordModify(int loginedMemberId, String loginPw);

	@Select("""
			SELECT *
				FROM `member`
				WHERE company = #{company}
			""")
	public Member getMemberByCompany(String company);

	@Select("""
			SELECT *
				FROM `member`
				WHERE company = #{company}
				AND pw = #{pw}
			""")
	public Member getMemberByCompanyAndPw(String company, String pw);

	@Select("""
			SELECT loginId
				FROM `member`
				WHERE company = #{company}
				ORDER BY regDate ASC
				LIMIT 1
			""")
	public String isFirstMember(String company);

	@Select("""
			SELECT id, `name`, depart
				FROM `member`
				WHERE depart LIKE CONCAT('%', #{searchKeywordType}, '%')
				AND `name` LIKE CONCAT('%', #{searchKeyword}, '%')
				AND company = #{company}
			""")
	public List<Member> getMemberByNameAndDepart(String searchKeywordType, String searchKeyword, String company);



	
}
