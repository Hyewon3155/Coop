package com.hyewon.introduce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
	private int id;
	private int year;
	private String name;
	private String subject;
	private String semester;
	private int credit;
	private String rank;
	private double grade;
	private int total_credit;
	private double average_grade;
}