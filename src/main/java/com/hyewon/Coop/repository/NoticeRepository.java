package com.hyewon.Coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hyewon.Coop.vo.Notice;

@Mapper
public interface NoticeRepository {
	
	@Insert("""
			INSERT INTO notice
				SET regDate = NOW(),
					updateDate = NOW(),
					memberId = #{memberId},
					title = #{title},
			        `body` = #{body}
			        
			""")
	public void doWrite(int memberId, String title, String body);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
	@Select("""
			SELECT COUNT(*)
			FROM notice
			""")
	public int getNoticeCount();
	
	@Select("""
			SELECT A.*, M.name AS writerName
		    FROM notice AS A
		    INNER JOIN `member` AS M
		    ON A.memberId = M.id
		    WHERE 1 = 1
			ORDER BY A.id DESC
			LIMIT #{limitStart}, #{itemsInAPage}

			""")
	public List<Notice> getNotices(int limitStart, int itemsInAPage);

	@Select("""
			SELECT A.*, M.name AS writerName, M.depart AS departName
		    FROM notice AS A
		    INNER JOIN `member` AS M
		    ON A.memberId = M.id
		    WHERE A.id = #{id}
			""")
	public Notice getNoticeById(int id);


	
}
