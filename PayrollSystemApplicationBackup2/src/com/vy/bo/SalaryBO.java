package com.vy.bo;

import lombok.Data;

@Data
public class SalaryBO {
	private double ctc;
	private double basicSal;
	private double hra;
	private double ma;
	private double ta;
	private double pf;
	private double ca;
	private double sa;
	private double incomeTax;
	private double proffesionalTax;
	private double gratuity;
	private double contributionAmt;
	private double netSalary;
	private int id;
	private int month;
	private double grossSal;
	private double taxableAmt;

}
