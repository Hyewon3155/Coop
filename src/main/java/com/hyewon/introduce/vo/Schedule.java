package com.hyewon.introduce.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
	private int id;
	private int event_member;
	private String event_date;
	private String event_name;
	private String event_body;
	private String event_color;
}