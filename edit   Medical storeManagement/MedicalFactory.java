package com.capgemini.medicalstoremanagement.factory;

import com.capgemini.medicalstoremanagement.service.impl.AdminServiceImpl;
import com.capgemini.medicalstoremanagement.service.impl.VisitorServiceImp;
import com.capgemini.medicalstoremangement.dao.UserDAO;
import com.capgemini.medicalstoremangement.dao.impl.UserDAOImp;
import com.capgemini.medicalstoremangement.service.AdminService;
import com.capgemini.medicalstoremangement.service.VisitorService;

public class MedicalFactory {
	public static AdminService getUsers() {
		AdminService adminDAO = new AdminServiceImpl();
		return adminDAO;
	}

	public static VisitorService getInstance() {
		VisitorService visitorInterface = new VisitorServiceImp();
		return visitorInterface;
	}

	public static UserDAO searchingForMedicine() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO displayOrderDetails() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;

	}

	public static UserDAO changePassword() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;

	}

	public static UserDAO addingToCart() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO deletingFromCart() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO placeOrder() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;

	}

	public static UserDAO insertUser() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO loginUser() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO sendMessage() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

	public static UserDAO totalAmount() {
		UserDAO userDAO = new UserDAOImp();
		return userDAO;
	}

}
