package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class MedicinePojo {
	private static int medicineId;
	private static String medicineName;
	private static double medicinePrice;
	private static Date medicineExpDate;
	private static Date medicineMfgDate;
	private static String medicineCompany;

	public static int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		MedicinePojo.medicineId = medicineId;
	}

	public static String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		MedicinePojo.medicineName = medicineName;
	}

	public static double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		MedicinePojo.medicinePrice = medicinePrice;
	}

	public static Date getMedicineExpDate() {
		return medicineExpDate;
	}

	public void setMedicineExpDate(Date medicineExpDate) {
		MedicinePojo.medicineExpDate = medicineExpDate;
	}

	public static Date getMedicineMfgDate() {
		return medicineMfgDate;
	}

	public void setMedicineMfgDate(Date medicineMfgDate) {
		MedicinePojo.medicineMfgDate = medicineMfgDate;
	}

	public static String getMedicineCompany() {
		return medicineCompany;
	}

	public void setMedicineCompany(String medicineCompany) {
		MedicinePojo.medicineCompany = medicineCompany;
	}

}// end of class
