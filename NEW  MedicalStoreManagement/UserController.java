package com.capgemini.medicalstoremanagement.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.medicalstoremanagement.dao.UserDAO;
import com.capgemini.medicalstoremanagement.dto.MedicinePojo;
import com.capgemini.medicalstoremanagement.dto.MedicinePojoUser;
import com.capgemini.medicalstoremanagement.dto.OrderPojo;
import com.capgemini.medicalstoremanagement.dto.ShoppingCartPojo;
import com.capgemini.medicalstoremanagement.dto.UserPojo;
import com.capgemini.medicalstoremanagement.dto.UserRegistration;
import com.capgemini.medicalstoremanagement.serviceimpl.ServiceImp;
import com.capgemini.medicalstoremanagment.factory.UserFactory;

public class UserController {
	static Logger log = LogManager.getLogger("user");

	public static void main(String[] args) {
		ServiceImp si = new ServiceImp();
		UserPojo info = new UserPojo();
		OrderPojo op = new OrderPojo();
		MedicinePojoUser mpu = new MedicinePojoUser();
		ShoppingCartPojo scp = new ShoppingCartPojo();
		UserRegistration ur = new UserRegistration();
		UserDAO udao = UserFactory.searchingForMedicine();
		UserDAO udao1 = UserFactory.displayOrderDetails();
		UserDAO udao2 = UserFactory.addingToCart();

		Scanner scanner = new Scanner(System.in);

		int b = 0;
		while (b != (1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)) {
			log.info("Press 1 to UserRegistration");
			log.info("Press 2 to SearchMedicine ");
			log.info("Press 3 to ChangePassword");
			log.info("Press 4 to AddProduct");
			log.info("press 5 to DeleteProduct");
			log.info("Press 6 to PlaceOrder");
			log.info("Press 7 to ViewOrder");
			log.info("press 8 to Payment");
			log.info("Press 9 to Go back to home");
			log.info("Please enter your choice");
			log.info("-----------------------");

			b = scanner.nextInt();
			switch (b) {
//			case 1: {
//				
//				log.info("enter user id");
//				int id = scanner.nextInt();
//
//				log.info("enter the user name");
//				String name = scanner.next();
//
//				log.info("enter user password");
//				String pwd = scanner.next();
//
//				log.info("enter the email");
//				String mail = scanner.next();
//
//				log.info("enter the mobile number");
//				long num = scanner.nextLong();
//
//				log.info("enter the date of birth");
//				Date date = Date.valueOf(scanner.next());
//                
//				
//				log.info("--------------------");
//			}
//			break;
			case 2: {

				log.info("Enter medicine to be searched");
				String medicineName = scanner.next();

				List<MedicinePojoUser> list = udao.searchingForMedicine(medicineName);

				log.info(list);
				log.info("---------------");
				break;
			}
			case 3: {

				log.info("Enter password to change");
				String userPass = scanner.next();
				info.setUserPassword(userPass);
				log.info("Enter  the userId");
				int userId = scanner.nextInt();
				info.setUserId(userId);
				si.changePass();
				log.info("Password is changed");
				log.info("----------------");
				break;
			}
			case 4: {
				log.info("Enter the medicine to be added to cart");
				String name = scanner.next();
				log.info("Enter the required quantity");
				Integer quan = scanner.nextInt();
				si.addProduct(name, quan);
				log.info("Product is added to cart");
				log.info("------------------");
				break;

			}
			case 5: {
				log.info("Enter the medicine name to be deleted");
				String name = scanner.next();
				si.deleteProduct(name);
				log.info("Product is deleted from cart");
				log.info("------------------");
				break;
			}
			case 6: {
				log.info("Enter the medicine name to be place for order");
				String name = scanner.next();
				si.placingOrder(name);
				log.info("press 1 to order the product");
				int num = scanner.nextInt();
				if (num == 1) {
					String res = si.calculateAmount();
					log.info("Total amount to be paid");
					log.info(res);
					log.info("-------------------");
				}

				break;
			}

			case 7: {
				List<OrderPojo> list1 = udao1.displayOrderDetails();
				for (OrderPojo p : list1) {
					log.info(p.getMedicineName());
					log.info(p.getMedicinePrice());
                    log.info("------------------");
				}
				
				break;
			}

			}

		}

	}// end of main

}// end of class
