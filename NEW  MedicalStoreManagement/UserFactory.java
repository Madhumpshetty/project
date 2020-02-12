package com.capgemini.medicalstoremanagment.factory;

import com.capgemini.medicalstoremanagement.dao.UserDAO;
import com.capgemini.medicalstoremanagement.daoimpl.UserDAOImp;
import com.capgemini.medicalstoremanagement.serviceimpl.ServiceImp;

public class UserFactory {

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
}
