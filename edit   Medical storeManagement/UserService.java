package com.capgemini.medicalstoremangement.service;

import java.sql.Date;

public interface UserService {
	public boolean login(String userName, String userPasssword);
	
	public void insertUser();

	public void sendMessage();

	public void changePass();

	public void searchingMedicine(String medicineName);

	public void displayOrders();

	public void deleteProduct(String medicineName);

	public void addProduct(String medicineName, int quantity);

	public void placingOrder(String medicineName);

	public String calculateAmount();

//	public void userRegistering(int userId,String userName,String userPassword,String userEmail,long userMobNo,Date userDob);
}
