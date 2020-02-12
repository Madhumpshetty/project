package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class OrderPojo {

	private String medicineName;
	private double medicinePrice;

	public String getMedicineName() {
		return medicineName;
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

}
