package com.hyewon.Coop.vo;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	private int id;
	private String startDate;
	private String endDate;
	private int manager;
	private String title;
	private String body;

	private List<Member> teamMembers;
	public String getForPrintBody() {
		return this.body.replaceAll("\n", "<br />");
}
   
	
}