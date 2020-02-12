package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class MedicinePojoUser {
	private int medicineId;
	private String medicineName;
	private double medicinePrice;
	private Date medicineExpDate;
	private Date medicineMfgDate;
	private String medicineCompany;
	private int stock;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	@Override
	public String toString() {
		return "MedicinePojoUser [medicineName=" + medicineName + ", medicinePrice="
				+ medicinePrice +  "]";
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public Date getMedicineExpDate() {
		return medicineExpDate;
	}

	public void setMedicineExpDate(Date medicineExpDate) {
		this.medicineExpDate = medicineExpDate;
	}

	public Date getMedicineMfgDate() {
		return medicineMfgDate;
	}

	public void setMedicineMfgDate(Date medicineMfgDate) {
		this.medicineMfgDate = medicineMfgDate;
	}

	public String getMedicineCompany() {
		return medicineCompany;
	}

	public void setMedicineCompany(String medicineCompany) {
		this.medicineCompany = medicineCompany;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
