package com.zzti.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PasswordChangeRequest implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5696687533586780324L;
	public PasswordChangeRequest(){}
	public PasswordChangeRequest(String id,String email)
	{
		this.id = id;
		this.email = email;
	}
	private String id;
	private String addTime;
	private String email;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
