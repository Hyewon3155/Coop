package com.hyewon.introduce.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.introduce.vo.Profile;

@Mapper
public interface ProfileRepository {
	
	@Insert("""
			INSERT INTO `member`
				SET `name` = #{name},
				    school = #{school},
				    depart = #{depart},
				    cellphoneNum = #{cellphoneNum},
					email = #{email}
			""")
	public void doJoin(String name, String school, String depart, String cellphoneNum, String email);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
				FROM `member`
				WHERE id = #{id}
			""")
	public Profile getProfileById(int id);
	
	@Update("""
			UPDATE `member`
			   SET  name = #{name},
			        school = #{school},
			        depart = #{depart},
			        cellphoneNum = #{cellphoneNum},
			        email = #{email}
			   WHERE id = 1
			""")
	public void doModify(String name, String school, String depart, String cellphoneNum, String email);


	@Select("""
			SELECT *
				FROM `member`
				WHERE loginId = #{loginId}
			""")
	public Profile getMemberByLoginId(String loginId);

	@Select("""
			SELECT *
				FROM `member`
				WHERE name = #{name}
				AND email = #{email}
			""")

	public Profile getMemberByNameAndEmail(String name, String email);


	@Select("""
			SELECT *
				FROM `member`
				WHERE nickname = #{nickname}
			""")
	public Profile getMemberByNickname(String nickname);
	
	@Update("""
			UPDATE `member`
			   SET  updateDate = NOW(),
			        loginPw = #{loginPw}
			   WHERE id = #{loginedMemberId}
			""")
	public void doPasswordModify(int loginedMemberId, String loginPw);


	
}
