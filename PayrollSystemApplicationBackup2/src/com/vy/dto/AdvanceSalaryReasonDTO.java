package com.vy.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class AdvanceSalaryReasonDTO {
	private String reason;
	private Date date;
	private int id;
	private int is_checked;
}
