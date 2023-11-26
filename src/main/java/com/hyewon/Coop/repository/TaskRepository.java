package com.hyewon.Coop.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

	@Insert("""
			INSERT INTO Task
				SET writer = #{id},
					title = #{title},
					`body` = #{body},
					startDate = #{startDate},
					endDate = #{endDate}
			        
			""")
	public void doCreate(int id, String title, String body, String startDate, String endDate);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
}
