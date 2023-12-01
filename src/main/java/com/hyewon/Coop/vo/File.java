package com.hyewon.Coop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
	private int id;
	private String title;
	private String body;
	private String regDate;
	private String updateDate;
	private String writerName;
	private int member_id;
	private int project_id;
	private String file_savedPath;
	public String getForPrintBody() {
		return this.body.replaceAll("\n", "<br />");
	}
	

}