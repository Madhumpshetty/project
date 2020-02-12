package com.capgemini.medicalstoremanagement.dto;

import java.sql.Date;

public class UserPojo {
	private static int userId;
	private static String userName;
	private static long userMobNo;
	private static String userAddress;
	private static int userPincode;
	private static Date userDob;
	private static String userDisease;
	private static int medicineId;
	private static Date userMedBookingDate;
	private static String userPassword;
	private static int userBookingId;

	public static int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getUserMobNo() {
		return userMobNo;
	}

	public void setUserMobNo(long userMobNo) {
		this.userMobNo = userMobNo;
	}

	public static String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public static int getUserPincode() {
		return userPincode;
	}

	public void setUserPincode(int userPincode) {
		this.userPincode = userPincode;
	}

	public static Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public static String getUserDisease() {
		return userDisease;
	}

	public void setUserDisease(String userDisease) {
		this.userDisease = userDisease;
	}

	public static int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public static Date getUserMedBookingDate() {
		return userMedBookingDate;
	}

	public void setUserMedBookingDate(Date userMedBookingDate) {
		this.userMedBookingDate = userMedBookingDate;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public static int getUserBookingId() {
		return userBookingId;
	}

	public void setUserBookingId(int userBookingId) {
		this.userBookingId = userBookingId;
	}

}
