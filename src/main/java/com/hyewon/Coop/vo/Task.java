package com.hyewon.Coop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	private int id;
	private String title;
	private String body;
	private String startDate;
	private String endDate;
	private String finishDate;
	private int member_id;
	private int project_id;
	private int status;
	private String projectName;
	private String memberName;
	private String memberDepart;
	public String getForPrintBody() {
		return this.body.replaceAll("\n", "<br />");
	}
	

}