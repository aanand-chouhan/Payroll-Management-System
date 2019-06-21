package com.vy.dto;

import lombok.Data;

@Data
public class SalaryDTO {
	private long ctc;
	private double basicSal;
	private double hra;
	private double ma;
	private double ta;
	private double pf;
	private double ca;	
	private double sa;
	private double incomeTax;
	private double proffesionalTax;
	private double taxablAmt;
	private int month;
	private double gratuity;
	private double netSalary;
	private double grossSalary;
	private int id;
}
