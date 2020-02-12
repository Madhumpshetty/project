package com.capgemini.medicalstoremanagement.serviceimpl;

import java.util.Date;

import com.capgemini.medicalstoremanagement.dao.UserDAO;
import com.capgemini.medicalstoremanagement.daoimpl.UserDAOImp;
import com.capgemini.medicalstoremanagement.dto.MedicinePojoUser;
import com.capgemini.medicalstoremanagement.dto.OrderPojo;
import com.capgemini.medicalstoremanagement.dto.ShoppingCartPojo;
import com.capgemini.medicalstoremanagement.dto.UserPojo;
import com.capgemini.medicalstoremanagement.service.UserService;

public class ServiceImp implements UserService {

	UserDAOImp udai = new UserDAOImp();

	@Override
	public void changePass() {
		udai.changePassword(UserPojo.getUserPassword(), UserPojo.getUserId());
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
	public void userRegistering(int userId, String userName, String userPassword, String userEmail, long userMobNo,
			Date userDob) {
		udai.userRegistration(userId, userName, userPassword, userEmail, userMobNo, userDob);
	}

}
