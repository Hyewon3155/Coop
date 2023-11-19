package com.hyewon.Coop.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeRepository {
	
	@Insert("""
			INSERT INTO notice
				SET regDate = NOW(),
					updateDate = NOW(),
					memberId = #{memberId},
					title = #{title},
			        `body` = #{body}
			        
			""")
	public void doWrite(int memberId, String title, String body);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();


	
}
