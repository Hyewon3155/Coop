package com.hyewon.Coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hyewon.Coop.vo.File;

@Mapper
public interface FileRepository {
	
	@Insert("""
			INSERT INTO `file`
				SET regDate = NOW(),
					member_id = #{loginedMemberId},
			        project_id = #{project_id},
			        title = #{title},
			        file_savedPath = #{savedPath},
			        `body` = #{body},
			        original_fileName = #{orgName}
			        
			""")
	public void doReference(int loginedMemberId, int project_id, String title, String savedPath, String body, String orgName);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
	@Select("""
			SELECT COUNT(*)
			FROM `file`
			WHERE project_id = #{id}
			""")
	public int getReferenceCount(int id);

	@Select("""
			SELECT A.*, M.name AS writerName
		    FROM `file` AS A
		    INNER JOIN `member` AS M
		    ON A.member_id = M.id
		    WHERE A.project_id = #{id}
			ORDER BY A.id DESC
			LIMIT #{limitStart}, #{itemsInAPage}

			""")
	public List<File> getReferences(int limitStart, int itemsInAPage, int id);

	@Select("""
			SELECT A.*, M.name AS writerName, M.depart AS departName
		    FROM `file` AS A
		    INNER JOIN `member` AS M
		    ON A.member_id = M.id
		    WHERE A.id = #{id}
			""")
	public File getFileById(int id);

	@Insert("""
			 UPDATE `file`
				SET updateDate = NOW(),
					member_id = #{loginedMemberId},
			        title = #{title},
			        file_savedPath = #{savedPath},
			        `body` = #{body},
			        original_fileName = #{orgName}
			        
			""")
	public void doReferenceModify(int loginedMemberId, String title, String savedPath, String body, String orgName);

	@Delete("""
			DELETE FROM `file`
			WHERE id = #{id}
			""")
	public void referenceDelete(int id);


	
}
