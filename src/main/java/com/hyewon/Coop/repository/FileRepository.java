package com.hyewon.Coop.repository;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileRepository {
	
	@Insert("""
			INSERT INTO `file`
				SET regDate = NOW(),
					member_id = #{loginedMemberId},
			        project_id = #{project_id},
			        title = #{title},
			        file_savedPath = #{savedPath},
			        `body` = #{body}
			        
			""")
	public void doReference(int loginedMemberId, int project_id, String title, String savedPath, String body);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();


	
}
