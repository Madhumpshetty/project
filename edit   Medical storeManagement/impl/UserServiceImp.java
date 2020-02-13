package com.capgemini.medicalstoremanagement.service.impl;

import java.sql.Date;

import com.capgemini.medicalstoremangement.dao.impl.UserDAOImp;
import com.capgemini.medicalstoremangement.dto.MessageSPojo;
import com.capgemini.medicalstoremangement.dto.UserSPojo;
import com.capgemini.medicalstoremangement.service.UserService;

public class UserServiceImp implements UserService {

	UserDAOImp udai = new UserDAOImp();

	@Override
	public boolean login(String userName, String userPasssword) {

		return udai.loginUser(userName, userPasssword);
	}

	@Override
	public void insertUser() {
		udai.insertUser(UserSPojo.getUserId(), UserSPojo.getUserName(), UserSPojo.getUserAddress(),
				UserSPojo.getUserPincode(), UserSPojo.getUserDob(), UserSPojo.getUserDisease(),
				UserSPojo.getMedicineId(), UserSPojo.getUserMedBookingDate(), UserSPojo.getUserPassword(),
				UserSPojo.getUserBookingId(), UserSPojo.getUserMobNo());

	}

	@Override
	public void changePass() {
		udai.changePassword(UserSPojo.getUserPassword(), UserSPojo.getUserId());
	}

	@Override
	public void searchingMedicine(String medicineName) {
		udai.searchingForMedicine(medicineName);

	}

	@Override
	public void displayOrders() {
		udai.displayOrderDetails();
	}

	@Override
	public void deleteProduct(String medicineName) {

		udai.deletingFromCart(medicineName);
	}

	@Override
	public void addProduct(String medicineName, int quantity) {

		udai.addingToCart(medicineName, quantity);
	}

	@Override
	public void placingOrder(String medicineName) {

		udai.placeOrder(medicineName);

	}

	@Override
	public String calculateAmount() {

		return udai.totalAmount();

	}

	@Override
	public void sendMessage() {
		udai.sendMessage(MessageSPojo.getMessageId(), MessageSPojo.getUserId(), MessageSPojo.getUserMessage(),
				MessageSPojo.getMedicineId(), MessageSPojo.getUserMessage());

	}

}
