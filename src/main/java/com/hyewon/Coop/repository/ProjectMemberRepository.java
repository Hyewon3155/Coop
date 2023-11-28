package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.Coop.vo.Member;

@Mapper
public interface ProjectMemberRepository {
	
	@Insert("""
			INSERT INTO project_member
				SET regDate = NOW(),
					project_id = #{project_id},
					member_id = #{member_id}
			""")
	public void doManagerJoin(int project_id, int member_id);

	@Insert("""
			INSERT INTO project_member
				SET regDate = NOW(),
					project_id = #{project_id},
					member_id = #{id}
			""")
	public void join(int id, int project_id);

	 @Delete("""
	    		DELETE FROM project_member
				WHERE id = #{id}
	    	""")
	public void deleteProjectById(int id);
	 
	 @Select("""
				SELECT member_id
				    FROM project_member
				    WHERE project_id = #{project_id}
				""")
	public List<Integer> getProjectMembers(int id);
	
	

	
}
