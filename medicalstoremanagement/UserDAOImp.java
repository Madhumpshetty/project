package com.capgemini.medicalstoremanagement.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.medicalstoremanagement.dao.UserDAO;

public class UserDAOImp implements UserDAO {

	@Override
	public void changePassword() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		String[] args = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "update medicalstoreuserinfo set userPassword=? where userId=?";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			int rs = pstmt.executeUpdate();
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

	@Override
	public void userRegistration() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String[] args = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into  userregistration values(?,?,?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			int rs = pstmt.executeUpdate();
			System.out.println(rs);

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

	}// end of userRegistration method

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/medicalstore_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "Select * from medicalstoremedicineinfo where medicineName = ?";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String MedicineName = rs.getString("medicineName");
				System.out.println("medicineName");
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
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}// end of UserSearchMedicine method

}// end of class
