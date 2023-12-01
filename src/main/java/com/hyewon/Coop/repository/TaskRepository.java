package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.Coop.vo.Task;

@Mapper
public interface TaskRepository {

	@Insert("""
			INSERT INTO task
				SET member_id = #{member_id},
					project_id = #{project_id},
					title = #{title},
					`body` = #{body},
					startDate = #{startDate},
					endDate = #{endDate}
			        
			""")
	public void doCreate(int member_id, int project_id, String title, String body, String startDate, String endDate);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
	
	@Select("""
		    SELECT task.*, project.title AS projectName
			    FROM task
			    INNER JOIN project ON task.project_id = project.id
			    WHERE task.`status` <= 2
			    AND task.member_id = #{loginedMemberId}
			    ORDER BY task.endDate ASC, task.startDate ASC
		""")

	public List<Task> getToDosByMemberId(int loginedMemberId);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.`status` = 3
				AND task.member_id = #{loginedMemberId}
				ORDER BY finishDate DESC
			        
			""")
	public List<Task> getDonesByMemberId(int loginedMemberId);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.`status` <= 2
				AND task.member_id = #{loginedMemberId}
				ORDER BY task.startDate ASC
			        
			""")
	public List<Task> sortByStartDateAsc(int loginedMemberId);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.`status` <= 2
				AND task.member_id = #{loginedMemberId}
				ORDER BY task.startDate DESC
			        
			""")
	public List<Task> sortByStartDateDesc(int loginedMemberId);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.`status` <= 2
				AND task.member_id = #{loginedMemberId}
				ORDER BY task.endDate ASC
			        
			""")
	public List<Task> sortByEndDateAsc(int loginedMemberId);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.`status` <= 2
				AND task.member_id = #{loginedMemberId}
				ORDER BY task.endDate DESC
			        
			""")
	public List<Task> sortByEndDateDesc(int loginedMemberId);

	@Select("""
		   SELECT task.*, project.title AS projectName, member.name AS memberName, member.depart AS memberDepart
				FROM task
			    INNER JOIN project ON task.project_id = project.id
			    INNER JOIN member ON task.member_id = member.id
				WHERE 
			    task.`status` <= 2
			    AND task.member_id = #{member_id}
			    AND task.project_id = #{project_id}
				ORDER BY 
			    task.endDate ASC, 
			    task.startDate ASC;
		""")
	public List<Task> getToDosForWork(int member_id, int project_id);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.member_id = #{member_id}
				AND task.project_id = #{project_id}
				ORDER BY task.startDate ASC
			        
			""")
	public List<Task> sortByStartDateAscMember(int member_id, int project_id);

	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.member_id = #{member_id}
				AND task.project_id = #{project_id}
				ORDER BY task.startDate DESC
			        
			""")
	public List<Task> sortByStartDateDescMember(int member_id, int project_id);
	
	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.member_id = #{member_id}
				AND task.project_id = #{project_id}
				ORDER BY task.startDate ASC
			        
			""")
	public List<Task> sortByEndDateAscMember(int member_id, int project_id);
	
	@Select("""
		    SELECT task.*, project.title AS projectName
				FROM task
				INNER JOIN project ON task.project_id = project.id
				WHERE task.member_id = #{member_id}
				AND task.project_id = #{project_id}
				ORDER BY task.startDate DESC
			        
			""")
	public List<Task> sortByEndDateDescMember(int member_id, int project_id);

	@Update("""
			UPDATE task
			   SET `status` = ${newStatus}
			   WHERE id = #{toDoId}
			""")

	public void changeStatus(int toDoId, int newStatus);
	
}
