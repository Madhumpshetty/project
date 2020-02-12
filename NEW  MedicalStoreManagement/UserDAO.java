package com.capgemini.medicalstoremanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.medicalstoremanagement.dto.MedicinePojo;
import com.capgemini.medicalstoremanagement.dto.MedicinePojoUser;
import com.capgemini.medicalstoremanagement.dto.OrderPojo;
import com.capgemini.medicalstoremanagement.dto.UserPojo;
import com.capgemini.medicalstoremanagement.dto.PaymentPojo;
import com.capgemini.medicalstoremanagement.dto.ShoppingCartPojo;

public interface UserDAO {
	UserPojo up = new UserPojo();
	MedicinePojoUser mpu = new MedicinePojoUser();
	OrderPojo op = new OrderPojo();
	ShoppingCartPojo sc = new ShoppingCartPojo();

	public void userRegistration(int userId, String userName, String userPassword, String userEmail, long userMobNo,
			Date userDob);

	public void changePassword(String userPassword, int userId);

	public List<MedicinePojoUser> searchingForMedicine(String medicineName);

	public List<OrderPojo> displayOrderDetails();

	public void addingToCart(String medicineName, int quantity);

	public void deletingFromCart(String medicineName);

	public void placeOrder(String medicineName);

	public String totalAmount();

}
