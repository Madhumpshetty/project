package com.capgemini.medicalstoremanagement.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.capgemini.medicalstoremanagement.dao.UserDAO;
import com.capgemini.medicalstoremanagement.dto.MedicinePojo;
import com.capgemini.medicalstoremanagement.dto.MedicinePojoUser;
import com.capgemini.medicalstoremanagement.dto.OrderPojo;
import com.capgemini.medicalstoremanagement.dto.UserPojo;
import com.capgemini.medicalstoremanagement.dto.UserRegistration;
import com.capgemini.medicalstoremanagement.dto.PaymentPojo;
import com.capgemini.medicalstoremanagement.dto.ShoppingCartPojo;

public class UserDAOImp implements UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	Properties pro;

	MedicinePojoUser msmi;
	UserPojo msui;
	ShoppingCartPojo scp;
	OrderPojo op;
	UserRegistration ur;

	@Override
	public void userRegistration(int userId, String userName, String userPassword, String userEmail, long userMobNo,
			Date userDob) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into userregistration values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, UserRegistration.getUserId());
			pstmt.setString(2, UserRegistration.getUserName());
			pstmt.setString(3, UserRegistration.getUserPassword());
			pstmt.setString(4, UserRegistration.getUserEmail());
			pstmt.setLong(5, UserRegistration.getUserMobNo());
			pstmt.setDate(6, UserRegistration.getUserDob());

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

	}// end of registration

	@Override
	public void changePassword(String userPassword, int userId) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "update medicalstoreuserinfo set userPassword=?	 where userId=?";
			pstmt = conn.prepareStatement(query);

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

	public List<MedicinePojoUser> searchingForMedicine(String medicineName) {
		List<MedicinePojoUser> list = new ArrayList<MedicinePojoUser>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "Select  * from medicalstoremedicineinfo where medicineName=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, medicineName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				msmi = new MedicinePojoUser();
				msmi.setMedicineName(rs.getString("medicineName"));
				msmi.setMedicinePrice(rs.getDouble("medicinePrice"));
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
		return list;

	}// end of UserSearchMedicine method

	@Override
	public void addingToCart(String medicineName, int quantity) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into  shoppingcart (medicineId,medicineName,medicinePrice,quantity) select medicineId,medicineName,medicinePrice,? from medicalstoremedicineinfo where medicineName=?";
			pstmt = conn.prepareStatement(query);
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

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "delete from shoppingcart where medicineName=?";
			pstmt = conn.prepareStatement(query);
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
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into  userorderdetails (medicineName,medicinePrice) select medicineName,medicinePrice from shoppingcart where medicineName=?";
			pstmt = conn.prepareStatement(query);
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
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "Select sum(quantity*medicinePrice) as quantity from  shoppingcart";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

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

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "Select  * from userorderdetails ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

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

}// end of class
