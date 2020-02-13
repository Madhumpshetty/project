package com.capgemini.medicalstoremanagement.service.impl;

import java.util.List;

import com.capgemini.medicalstoremangement.dao.AdminDAO;
import com.capgemini.medicalstoremangement.dao.impl.AdminDAOImp;
import com.capgemini.medicalstoremangement.dto.MedSPojo;
import com.capgemini.medicalstoremangement.dto.MedicinePojo;
import com.capgemini.medicalstoremangement.dto.MessagePojo;
import com.capgemini.medicalstoremangement.dto.MessageSPojo;
import com.capgemini.medicalstoremangement.dto.UserSPojo;
import com.capgemini.medicalstoremangement.dto.UserPojo;
import com.capgemini.medicalstoremangement.service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDAOImp adaoi = new AdminDAOImp();

	@Override
	public List<UserPojo> displayUsers() {
		return adaoi.displayUser();
	}

	@Override
	public List<MessagePojo> displayMessages() {
		return adaoi.displayMessages();
	}

	@Override
	public void replyUserMessages() {
		adaoi.replyMessage(MessageSPojo.getAdminMessage(), MessageSPojo.getMessageId());
	}

	@Override
	public void insertMedicine() {
		adaoi.insMedicine(MedSPojo.getMedicineId(), MedSPojo.getMedicineName(), MedSPojo.getMedicinePrice(),
				MedSPojo.getMedicineExpdate(), MedSPojo.getMedicineCompany(), MedSPojo.getMedicineMfgdate(),
				MedSPojo.getStock());
	}

	@Override
	public void updateMedNameId() {
		adaoi.updateMedicine(MedSPojo.getMedicineName(), MedSPojo.getMedicineId());

	}

	@Override
	public void deleteMedicine() {
		adaoi.deleteMedicine(MedSPojo.getMedicineName());
	}

	@Override
	public void deleteUsers() {

		adaoi.deleteUser(UserSPojo.getUserName());

	}

	@Override
	public List<MedicinePojo> displayMedicine() {
		return adaoi.displayMedicine();

	}

}
