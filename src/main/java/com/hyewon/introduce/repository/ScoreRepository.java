package com.hyewon.introduce.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.introduce.vo.Score;

@Mapper
public interface ScoreRepository {
	
	@Insert("""
			INSERT INTO score
				SET `name` = #{name},
				    `subject` = #{subject},
				    `year` = #{year},
				    semester = #{semester},
				    credit = #{credit},
					`rank` = #{rank},
					grade = #{grade}
			        
			""")
	public void doJoin(String name, String subject, int year, String semester, int credit, String rank, double grade);
	
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT * 
				FROM score
			    WHERE id = #{id}

			"""
			)
	public Score getScoreById(int id);

	@Update("""
			UPDATE score
				SET `name` = #{name},
				    `subject` = #{subject},
				    semester = #{semester},
				    credit = #{credit},
					`rank` = #{rank},
					grade = #{grade}
				WHERE id = #{id}

			""")


	public void doModify(int id, String name, String subject, String semester, int credit, String rank, double grade);

	@Select("""
            SELECT s.year, s.semester, 
            (SELECT SUM(credit) FROM score WHERE year = s.year AND semester = s.semester) AS total_credit 
            FROM score s;
            """)
	public List<Score> getTotalScores();
	




	
}
