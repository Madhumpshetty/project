package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class UserRegistration {
	private static int userId;
	private static String userName;
	private static String userPassword;
	private static String userEmail;
	private static long userMobNo;
	private static Date userDob;

	public static int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		UserRegistration.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		UserRegistration.userPassword = userPassword;
	}

	public static String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public static long getUserMobNo() {
		return userMobNo;
	}

	public static void setUserMobNo(long userMobNo) {
		UserRegistration.userMobNo = userMobNo;
	}

	public static Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

}
