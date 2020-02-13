package com.capgemini.medicalstoremanagement.service.impl;

import java.util.List;

import com.capgemini.medicalstoremangement.dao.impl.VisitorDAOImp;
import com.capgemini.medicalstoremangement.service.VisitorService;

public class VisitorServiceImp implements VisitorService {
	VisitorDAOImp visitor = new VisitorDAOImp();

	@Override
	public List detailsInfo() {
		return visitor.detailsInfo();

	}

	@Override
	public List medicineInfo() {
		return visitor.medicineInfo();
	}

}
