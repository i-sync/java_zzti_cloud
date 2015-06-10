package com.zzti.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class LoginForm {
	private String phone;
	private String password;
	private Map<String,String> errors =new HashMap<String,String>();
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	/**
	 * validate form data
	 * @return
	 */
	public boolean validate()
	{
		boolean flag =true;
		if(this.phone==null || this.phone.trim().equals(""))
		{
			flag =false;
			this.errors.put("phone", "手机号不能为空!");
		}
		if(this.password==null || this.password.trim().equals(""))
		{
			flag = false;
			this.errors.put("password", "密码不能为空!");
		}
		return flag;
	}
}
