package com.capgemini.medicalstoremanagement.dto;

public class PaymentPojo {
	private int userId;
	private double medicinePrice;
	private String paymentType;
	private String status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
 
}
