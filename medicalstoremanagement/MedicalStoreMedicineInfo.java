package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class MedicalStoreMedicineInfo {
	private int medicine_id;
	private String medicine_name;
	private double medicine_price;
	private Date medicine_expdate;
	private Date medicine_mfgdate;
	private String medicine_company;

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public double getMedicine_price() {
		return medicine_price;
	}

	public void setMedicine_price(double medicine_price) {
		this.medicine_price = medicine_price;
	}

	public Date getMedicine_expdate() {
		return medicine_expdate;
	}

	public void setMedicine_expdate(Date medicine_expdate) {
		this.medicine_expdate = medicine_expdate;
	}

	public Date getMedicine_mfgdate() {
		return medicine_mfgdate;
	}

	public void setMedicine_mfgdate(Date medicine_mfgdate) {
		this.medicine_mfgdate = medicine_mfgdate;
	}

	public String getMedicine_company() {
		return medicine_company;
	}

	public void setMedicine_company(String medicine_company) {
		this.medicine_company = medicine_company;
	}

}// end of class
