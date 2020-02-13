package com.capgemini.medicalstoremangement.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.medicalstoremanagement.exceptions.TryToOrder;
import com.capgemini.medicalstoremanagement.factory.MedicalFactory;
import com.capgemini.medicalstoremanagement.service.impl.AdminServiceImpl;
import com.capgemini.medicalstoremanagement.service.impl.UserServiceImp;
import com.capgemini.medicalstoremangement.dao.UserDAO;
import com.capgemini.medicalstoremangement.dao.impl.AdminDAOImp;
import com.capgemini.medicalstoremangement.dto.MedSPojo;
import com.capgemini.medicalstoremangement.dto.MedicinePojo;
import com.capgemini.medicalstoremangement.dto.MessagePojo;
import com.capgemini.medicalstoremangement.dto.MessageSPojo;
import com.capgemini.medicalstoremangement.dto.OrderPojo;
import com.capgemini.medicalstoremangement.dto.UserPojo;
import com.capgemini.medicalstoremangement.dto.UserSPojo;
import com.capgemini.medicalstoremangement.dto.VisitorInfo;
import com.capgemini.medicalstoremangement.dto.VisitorMedicineInfo;
import com.capgemini.medicalstoremangement.service.AdminService;
import com.capgemini.medicalstoremangement.service.VisitorService;

public class AdminController {
	static Logger log = LogManager.getLogger("Medical Store Management");

	public static void main(String[] args) {
		AdminDAOImp adao1 = new AdminDAOImp();
		AdminServiceImpl asi = new AdminServiceImpl();
		MedicinePojo imp = new MedicinePojo();
		AdminService as = MedicalFactory.getUsers();
		UserPojo up = new UserPojo();
		MedSPojo msp = new MedSPojo();
		UserSPojo usp = new UserSPojo();
		MessageSPojo mspo = new MessageSPojo();
		Scanner scanner = new Scanner(System.in);
		LocalDateTime today = LocalDateTime.now();
		MedicalFactory factory = new MedicalFactory();
		VisitorService service = factory.getInstance();
		UserDAO udao = MedicalFactory.searchingForMedicine();
		UserServiceImp usi = new UserServiceImp();
		UserDAO udao1 = MedicalFactory.displayOrderDetails();

		int a = 0;
		log.info("Today's Date and Time = " + today);
		log.info(":::::::::::::::::::::::::::::::::::::::::MEDICAL STORE MANAGEMENT::::::::"
				+ "::::::::::::::::::::::::::::::::::");
		log.info("@ @ @ @ @---------------------------------------WELCOME-------------------"
				+ "--------------------------@ @ @ @ @\n");
//		log.info("n");
		while (a != (1 | 2 | 3 | 4)) {
			log.info("Press 1 to Admin");
			log.info("Press 2 to Visitor");
			log.info("press 3 to User login");
			a = scanner.nextInt();
			boolean value = true;
			int b = 0;
			switch (a) {
			case 1: {
				log.info("---Login-----");

				log.info("Enter Admin ID");
				String adminId = scanner.next();
				log.info("Enter Password");
				String adminPassword = scanner.next();
				boolean value1 = true;
				if (adminId.equals("admin123") && adminPassword.equals("admin123")) {
					log.info("*********************ADMIN***********************");

					while (value1) {
						log.info("================================================");
						log.info("	Press 1 to Display Users");
						log.info("	Press 2 to Display Medicines");
						log.info("	Press 3 to Display User Feedbacks ");
						log.info("	Press 4 to Insert Medicines");
						log.info("	Press 5 to Update Medicines");
						log.info("	Press 6 to Delete a Medicne");
						log.info("	Press 7 to Delete a User");
						log.info("	Press 8 to Reply a Feedback");
						log.info("	Press 9 to go back\n");
						b = scanner.nextInt();
						switch (b) {
						case 1: {
//						show all users
							List<UserPojo> list = as.displayUsers();
							for (UserPojo u : list) {
								log.info("User ID: " + u.getUserId());
								log.info("User Name:" + u.getUserName());
								log.info("User Address: " + u.getUserAddress());
								log.info("User Pincode: " + u.getUserPincode());
								log.info("User Date Of Birth: " + u.getUserDob());
								log.info("User Disease: " + u.getUserDisease());
//							log.info("User Medicine"+m.getMedicineId());
								log.info("User Booking Date: " + u.getUserMedBookingDate());
								log.info("User Booking ID: " + u.getUserBookingId());
								log.info("");

							}
							break;

						}
						case 2: {
							List<MedicinePojo> list2 = as.displayMedicine();
							for (MedicinePojo m : list2) {
								log.info("Medicine ID: " + m.getMedicineId());
								log.info("Medicine Name: " + m.getMedicineName());
								log.info("Medicine Mfg Date: " + m.getMedicineMfgdate());
								log.info("Medicine Exp Date: " + m.getMedicineExpdate());
								log.info("Medicine price: " + m.getMedicinePrice());
								log.info("Medicine Comapany: " + m.getMedicineCompany());
								log.info("------------------------------------------------------");
							}
							break;
						}
						case 3: {
//						display Messages
							List<MessagePojo> list2 = as.displayMessages();
							for (MessagePojo m2 : list2) {
								log.info("Message ID: " + m2.getMessageId());
								log.info("User ID: " + m2.getUserId());
								log.info("User Name: " + m2.getUserName());
								log.info("Medicine ID: " + m2.getMessageId());
								log.info("User Feedback: " + m2.getUserMessage());
								log.info("Admin Replay: " + m2.getAdminMessage());
								log.info("----------------------------------------");

							}
							break;
						}
						case 4: {
//						insert medicine
//						log.info("Medicie ID");
//						msp.setMedicineId(scanner.nextInt());
							log.info("Medicine Name");
							msp.setMedicineName(scanner.next());
							log.info("Medicine  Price");
							msp.setMedicinePrice(scanner.nextDouble());
							log.info("Medicine Exp Date");
							msp.setMedicineExpdate(Date.valueOf(scanner.next()));
							log.info("Med Company Name");
							msp.setMedicineCompany(scanner.next());
							log.info("Medicine Mfg Date");
							msp.setMedicineMfgdate(Date.valueOf(scanner.next()));
							log.info("Medicine stock");
							msp.setStock(scanner.nextInt());
							asi.insertMedicine();
							log.info("\n----Medicine Inserted----");
							break;
						}
						case 5: {
							log.info("Enter Medicine ID to Change Name");
							msp.setMedicineId(scanner.nextInt());
							log.info("Enter name to be Inserted");
							msp.setMedicineName(scanner.next());
							asi.updateMedNameId();
							log.info("\n----Medicine Name Updated----");
							break;
						}
						case 6: {
//						delete medicine
							log.info("Enter Medicine Name to Delete");
							msp.setMedicineName(scanner.next());
							asi.deleteMedicine();
							log.info("\n----Medicine Deleted----");
							break;
						}
						case 7: {
//						delete users
							log.info("Enter User Name to Delete");
							String userName = scanner.next();
							usp.setUserName(userName);
							asi.deleteUsers();
							log.info("\n ----User Deleted----");
							break;
						}
						case 8: {
//						replay User Messages
							log.info("Enter Reply for feedback");
							mspo.setAdminMessage(scanner.next());
							log.info("Enter User ID to Send");
							mspo.setMessageId(scanner.nextInt());
							asi.replyUserMessages();
							log.info("/n ----Reply Sent----");
							break;
						}
						case 9: {
							value1 = false;
							break;
						}
						default:
							log.info("invalid Entry");
							value1 = false;
							break;
						}
					}
				} else {
					value1 = false;
					log.info("Admin ID and Admin Password Doesn't match");

				}
				break;
			}
			case 2: {

				while (value) {
					log.info("********************VISITOR**********************");

					log.info("Press 1 to UserInformation: ");
					log.info("Press 2 to MedicineInformation: ");
					log.info("press 3 Try to order");
					log.info("Press 4 to Go Back to Home ");
					log.info("Please enter your choice..");
					log.info("........................................................");
					a = scanner.nextInt();
					switch (a) {
					case 1: {
						List<VisitorInfo> list = service.detailsInfo();

						for (VisitorInfo m : list) {
							log.info("User ID: " + m.getUserId());
							log.info("User Name" + m.getUserName());
							log.info("User Address: " + m.getUserAddress());
							log.info("User Pincode: " + m.getPincode());
							log.info("User Date Of Birth: " + m.getUserDob());
							log.info("User Disease: " + m.getUserDisease());
//							log.info("User Medicine"+m.getMedicineId());
							log.info("User Booking Date: " + m.getMedbookingDate());
							log.info("User Booking ID: " + m.getUserBookingId());
							log.info("------------------------------------------------------");
						}

						break;
					}
					case 2: {

						List<VisitorMedicineInfo> list1 = service.medicineInfo();
						for (VisitorMedicineInfo m1 : list1) {
							log.info(m1.getMedicineId());
							log.info(m1.getMedicineName());
							log.info(m1.getMedicineMfgDate());
							log.info(m1.getMedicineExpDate());
							log.info(m1.getMedicinePrice());
							log.info(m1.getMedicineCompany());
							log.info("------------------------------------------------------");
						}
						break;
					}

					case 3: {
						TryToOrder trytoorder = new TryToOrder();
						trytoorder.order("ertu");
						log.info("------------------------------------------------------");
						break;
					}
					case 4: {
						log.info("Go Back to Home");
						log.info("------------------------------------------------------");
						value = false;

						break;
					}
					default:
						log.info("Invalid");
						log.info("------------------------------------------------------");
						break;
					}
				}
				break;

			}

			case 3: {
				String name = null;
				log.info("enter the user name");
				name = scanner.next();

				log.info("enter the user password");
				String pwd = scanner.next();
				boolean b1 = usi.login(name, pwd);
				if (b1) {
					log.info("login is successfull");
					log.info("--------------------");
					while (value) {
						log.info("*********************USER***********************");
						log.info("================================================");
						log.info("Press 1 to InsertUser");
						log.info("Press 2 to SearchMedicine ");
						log.info("Press 3 to ChangePassword");
						log.info("Press 4 to AddProduct");
						log.info("press 5 to DeleteProduct");
						log.info("Press 6 to PlaceOrder");
						log.info("Press 7 for payment");
						log.info("Press 8 to ViewOrder");
						log.info("press 9 to SendMessage");
						log.info("Press 10 to Go back to home");
						log.info("Please enter your choice");
						log.info("-----------------------");
						int c = 0;
						c = scanner.nextInt();

						switch (c) {
						case 1: {
							log.info("Enter the user Id");
							usp.setUserId(scanner.nextInt());
							log.info("Enter the user name");
							usp.setUserName(scanner.next());
							log.info("Enter the user Address");
							usp.setUserAddress(scanner.next());
							log.info("Enter the pincode");
							usp.setUserPincode(scanner.nextInt());
							log.info("Enter the date of birth");
							usp.setUserDob(Date.valueOf(scanner.next()));
							log.info("Enter the user Disease");
							usp.setUserDisease(scanner.next());
							log.info("Enter the medicine Id");
							usp.setMedicineId(scanner.nextInt());
							log.info("Enter the booking date");
							usp.setUserMedBookingDate(Date.valueOf(scanner.next()));
							log.info("Enter the user password");
							usp.setUserPassword(scanner.next());
							log.info("Enter the booking Id");
							usp.setUserBookingId(scanner.nextInt());
							log.info("Enter the mobile number");
							usp.setUserMobNo(scanner.nextLong());
							usi.insertUser();
							break;
						}
						case 2: {
							log.info("Enter medicine to be searched");
							String medicineName = scanner.next();

							List<MedicinePojo> list = udao.searchingForMedicine(medicineName);
							for (MedicinePojo medicinePojo : list) {

								log.info("your medicine is present: " + medicinePojo.getMedicineName());
							}
							break;
						}
						case 3: {
							log.info("Enter password to change");
							usp.setUserPassword(scanner.next());
							log.info("Enter  the userId");
							usp.setUserId(scanner.nextInt());
							usi.changePass();
							log.info("Password is changed");
							log.info("----------------");
							break;
						}
						case 4: {
							log.info("Enter the medicine to be added to cart");
							name = scanner.next();
							log.info("Enter the required quantity");
							Integer quan = scanner.nextInt();
							usi.addProduct(name, quan);
							log.info("Product is added to cart");
							log.info("------------------");
							break;
						}
						case 5: {
							log.info("Enter the medicine name to be deleted");
							name = scanner.next();
							usi.deleteProduct(name);
							log.info("Product is deleted from cart");
							log.info("------------------");
							break;
						}
						case 6: {
							log.info("Enter the medicine name to be place for order");
							name = scanner.next();
							usi.placingOrder(name);
							log.info("press 1 to order the product");
							int num = scanner.nextInt();
							if (num == 1) {
								String res = usi.calculateAmount();
								log.info("Total amount to be paid");
								log.info(res);
								log.info("-------------------");
							}
							break;

						}
						case 7: {

						}
						case 8: {
							List<OrderPojo> list1 = udao1.displayOrderDetails();
							for (OrderPojo p : list1) {
								log.info(p.getMedicineName());
								log.info(p.getMedicinePrice());
								log.info("------------------");
							}

							break;

						}
						case 9: {
							log.info("Enter the message Id");
							mspo.setMessageId(scanner.nextInt());
							log.info("Enter the user Id");
							mspo.setUserId(scanner.nextInt());
							log.info("Enter the user name");
							mspo.setUserName(scanner.next());
							log.info("Enter the medicine Id");
							mspo.setMedicineId(scanner.nextInt());
							log.info("Enter the user message");
							mspo.setUserMessage(scanner.next());

							usi.sendMessage();
							log.info("/n ----Message Sent----");
							break;
						}

						case 10: {
							value = false;
							break;
						}
						default: {
							log.info("invalid");
						}
						}
					}
					break;
				} else {
					log.info("unsuccesfull");
					value = false;
				}

			}

			}
		}
	}
}

//		===============================================================================================================
