package com.vy.bo;

import java.sql.Date;

import lombok.Data;
@Data
public class AdvanceSalayReasonBO {
	private String reason;
	private Date date;
	private int id;
	private int is_checked;
}
