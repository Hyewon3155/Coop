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
	private int writer;
	private int project_id;
	private int status;
	

}