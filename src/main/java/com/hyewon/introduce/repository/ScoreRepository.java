package com.hyewon.introduce.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hyewon.introduce.vo.Score;

@Mapper
public interface ScoreRepository {
	
	@Insert("""
			INSERT INTO score
				SET `name` = #{name},
				    `subject` = #{subject},
				    semester = #{semester},
				    credit = #{credit},
					`rank` = #{rank},
					grade = #{grade}
			        
			""")
	public void doJoin(String name, String subject, String semester, int credit, String rank, double grade);
	
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT * 
				FROM score
			    WHERE id = #{id}

			"""
			)
	public Score getScoreById(int id);




	
}
