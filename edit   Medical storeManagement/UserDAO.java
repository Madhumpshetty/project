package com.capgemini.medicalstoremangement.dao;

import java.sql.Date;
import java.util.List;

import com.capgemini.medicalstoremangement.dto.MedicinePojo;
import com.capgemini.medicalstoremangement.dto.OrderPojo;
import com.capgemini.medicalstoremangement.dto.ShoppingCartPojo;
import com.capgemini.medicalstoremangement.dto.UserPojo;

public interface UserDAO {

	public boolean loginUser(String userName, String userPassword);

	public void insertUser(int userId, String userName, String userAddress, int userPincode, Date userDob,
			String userDisease, int medicineId, Date userMedBookingDate, String userPassword, int userBookingId,
			long userMobNo);

	public void changePassword(String userPassword, int userId);

	public List<MedicinePojo> searchingForMedicine(String medicineName);

	public List<OrderPojo> displayOrderDetails();

	public void addingToCart(String medicineName, int quantity);

	public void deletingFromCart(String medicineName);

	public void placeOrder(String medicineName);

	public String totalAmount();

	public void sendMessage(int messageId, int userId, String userName, int medicineId, String userMessage);
}
