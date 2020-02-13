package com.capgemini.medicalstoremangement.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.medicalstoremangement.dao.UserDAO;
import com.capgemini.medicalstoremangement.dto.MedicinePojo;
import com.capgemini.medicalstoremangement.dto.OrderPojo;
import com.capgemini.medicalstoremangement.dto.ShoppingCartPojo;
import com.capgemini.medicalstoremangement.dto.UserPojo;
import com.capgemini.medicalstoremangement.dto.UserRegistrationPojo;

public class UserDAOImp implements UserDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	FileInputStream input = null;
	Properties pro;
	MedicinePojo msmi;
	UserPojo msui;
	ShoppingCartPojo scp;
	OrderPojo op;
	UserRegistrationPojo ur;

	public UserDAOImp() {
		try {
			input = new FileInputStream("db.properties");
			pro = new Properties();
			pro.load(input);
			Class.forName(pro.getProperty("name")).newInstance();
		} catch (Exception e) {

		}

	}

	@Override
	public boolean loginUser(String userName, String userPassword) {
		boolean isLogged = false;
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("loginUser"));
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("userName").equals(userName) && rs.getString("userPassword").equals(userPassword)) {
					isLogged = true;
				} else {

				}
			}

		} catch (Exception e) {

		}

		return isLogged;

	}

	@Override
	public void insertUser(int userId, String userName, String userAddress, int userPincode, Date userDob,
			String userDisease, int medicineId, Date userMedBookingDate, String userPassword, int userBookingId,
			long userMobNo) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("insertUser"));
			pstmt.setInt(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userAddress);
			pstmt.setInt(4, userPincode);
			pstmt.setDate(5, userDob);
			pstmt.setString(6, userDisease);
			pstmt.setInt(7, medicineId);
			pstmt.setDate(8, userMedBookingDate);
			pstmt.setString(9, userPassword);
			pstmt.setInt(10, userBookingId);
			pstmt.setLong(11, userMobNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
                e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
						pstmt.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}// end of user insert

	@Override
	public void changePassword(String userPassword, int userId) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("changePassword"));
			pstmt.setString(1, userPassword);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}// end of changePassword method

	public List<MedicinePojo> searchingForMedicine(String medicineName) {
		List<MedicinePojo> list = new ArrayList<MedicinePojo>();

		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("searchMedicine"));
			pstmt.setString(1, medicineName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				msmi = new MedicinePojo();
				msmi.setMedicineName(rs.getString("medicine_name"));
				msmi.setMedicinePrice(rs.getDouble("medicine_price"));
				list.add(msmi);
			}
			return list;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;

	}// end of UserSearchMedicine method

	@Override
	public void addingToCart(String medicineName, int quantity) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("addToCart"));
			pstmt.setInt(1, quantity);
			pstmt.setString(2, medicineName);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}// end of addingTOCart

	@Override
	public void deletingFromCart(String medicineName) {

		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("deleteFromCart"));
			pstmt.setString(1, medicineName);
			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public void placeOrder(String medicineName) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("placeOrder"));
			pstmt.setString(1, medicineName);

			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}// end of placeOrder

	public String totalAmount() {

		String sum = null;
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(pro.getProperty("totalAmount"));

			if (rs.next()) {
				sum = rs.getString("quantity");

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return sum;

	}// end of totalAmount

	@Override
	public List<OrderPojo> displayOrderDetails() {
		List<OrderPojo> list1 = new ArrayList<OrderPojo>();

		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(pro.getProperty("displayOrderDetails"));

			while (rs.next()) {
				op = new OrderPojo();

				op.setMedicineName(rs.getString("medicineName"));
				op.setMedicinePrice(rs.getDouble("medicinePrice"));

				list1.add(op);
			}
			return list1;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}

	@Override
	public void sendMessage(int messageId, int userId, String userName, int medicineId, String userMessage) {
		try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
			pstmt = conn.prepareStatement(pro.getProperty("sendMessage"));

			pstmt.setInt(1, messageId);
			pstmt.setInt(2, userId);
			pstmt.setString(3, userName);
			pstmt.setInt(4, medicineId);
			pstmt.setString(5, userMessage);

			int rs = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
