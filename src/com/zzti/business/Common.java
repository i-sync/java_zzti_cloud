package com.zzti.business;

import com.zzti.service.ContactSEI;
import com.zzti.service.ContactService;


public class Common {

	private static Common instace = new Common();
	private ContactSEI service;

	public Common() {
		// TODO Auto-generated constructor stub
		service = new ContactService().getServicePort();
	}

	public static Common getInstace() {
		return instace;
	}

	public ContactSEI getService() {
		return this.service;
	}

}
