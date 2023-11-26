package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyewon.Coop.vo.Notice;

@Mapper
public interface NoticeRepository {
	
	@Insert("""
			INSERT INTO notice
				SET regDate = NOW(),
					updateDate = NOW(),
					memberId = #{memberId},
					title = #{title},
			        `body` = #{body},
			        company = #{company}
			        
			""")
	public void doWrite(int memberId, String company, String title, String body);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
	@Select("""
			SELECT COUNT(*)
			FROM notice
			WHERE company = #{company}
			""")
	public int getNoticeCount(String company);
	
	@Select("""
			SELECT A.*, M.name AS writerName
		    FROM notice AS A
		    INNER JOIN `member` AS M
		    ON A.memberId = M.id
		    WHERE A.company = #{company}
			ORDER BY A.id DESC
			LIMIT #{limitStart}, #{itemsInAPage}

			""")
	public List<Notice> getNotices(int limitStart, int itemsInAPage, String company);

	@Select("""
			SELECT A.*, M.name AS writerName, M.depart AS departName
		    FROM notice AS A
		    INNER JOIN `member` AS M
		    ON A.memberId = M.id
		    WHERE A.id = #{id}
			""")
	public Notice getNoticeById(int id);
	
	@Update("""
			UPDATE notice
				SET updateDate = NOW(),
					title = #{title},
			        `body` = #{body}
				WHERE id = #{id}
			""")
	public void doModify(int id, String title, String body);

	@Delete("""
			DELETE FROM notice
			WHERE id = #{id}
			""")
	
	public void doDelete(int id);
	
	@Select("""
			SELECT title, regDate, id
		    FROM notice
		    WHERE company = #{company}
			ORDER BY id DESC
			LIMIT 3

			""")
	public List<Notice> getHomeNotices(String company);
	
	


	
}
