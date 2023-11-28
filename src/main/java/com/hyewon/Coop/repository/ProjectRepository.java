package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.Coop.vo.Project;


@Mapper
public interface ProjectRepository {
	
	@Insert("""
			INSERT INTO project
				SET startDate = #{startDate},
				    endDate = #{endDate},
					manager = #{manager},
					title = #{title},
			        `body` = #{body}
			        
			""")
	public void doCreate(String title, String body, int manager, String startDate, String endDate);

	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();


	@Select("""
			SELECT COUNT(*) AS projectCount
			FROM project AS p
			INNER JOIN project_member AS ptm ON p.id = ptm.project_id
			WHERE ptm.member_id = #{loginedMemberId};
			        
			""")
	public int getProjectCount(int loginedMemberId);


	@Select("""
		    SELECT id, 
		           title,
		           `body`, 
		           DATE_FORMAT(startDate, '%Y-%m-%d'),
		           DATE_FORMAT(endDate, '%Y-%m-%d')
		    FROM project
		    WHERE id = #{project_id};
		""")
	public Project getProjectById(int project_id);


	@Select("""
			SELECT p.* FROM project AS p
            INNER JOIN project_member AS ptm ON p.id = ptm.project_id
            WHERE ptm.member_id = #{loginedMemberId}
			ORDER BY p.id DESC
			LIMIT #{limitStart}, #{itemsInAPage}

			""")
	public List<Project> getProjects(int limitStart, int itemsInAPage, int loginedMemberId);

	@Select("""
			SELECT COUNT(*) AS projectCount
			FROM project
			WHERE manager = #{loginedMemberId}
			        
			""")
	public int getProjectManagerCount(int loginedMemberId);

	@Select("""
			SELECT *
			FROM project
            WHERE manager = #{loginedMemberId}
			ORDER BY id DESC
			LIMIT #{limitStart}, #{itemsInAPage}

			""")
	public List<Project> getProjectsManager(int limitStart, int itemsInAPage, int loginedMemberId);

    @Delete("""
    		DELETE FROM project
			WHERE id = #{id}
    		""")
	public void deleteProject(int id);

    @Update("""
			UPDATE project
				SET startDate = #{startDate},
				    endDate = #{endDate},
					title = #{title},
			        `body` = #{body}
			        
			""")
	public void doModify(String title, String body, String startDate, String endDate);
	
	


	
}
