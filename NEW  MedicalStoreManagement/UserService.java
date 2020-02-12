package com.capgemini.medicalstoremanagement.service;

import java.util.Date;

import com.capgemini.medicalstoremanagement.dto.UserPojo;

public interface UserService {

	public void changePass();

	public void searchingMedicine(String medicineName);

	public void displayOrders();

	public void deleteProduct(String medicineName);

	public void addProduct(String medicineName, int quantity);

	public void placingOrder(String medicineName);

	public String calculateAmount();

	public void userRegistering(int userId,String userName,String userPassword,String userEmail,long userMobNo,Date userDob);
}
