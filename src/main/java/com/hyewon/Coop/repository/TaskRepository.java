package com.hyewon.Coop.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

	@Insert("""
			INSERT INTO Task
				SET member_id = #{member_id},
					project_id = #{project_id},
					`body` = #{body},
					startDate = #{startDate},
					endDate = #{endDate}
			        
			""")
	public void doCreate(int member_id, int project_id, String title, String body, String startDate, String endDate);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
}
