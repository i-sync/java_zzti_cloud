package com.zzti.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class PasswordForm {
	
	private String oldpassword;
	private String newpassword;
	private String confirmpassword;
	private Map<String,String> errors =new HashMap<String,String>();
	
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
		if(this.oldpassword==null || this.oldpassword.trim().equals(""))
		{
			flag =false;
			this.errors.put("oldpassword", "旧密码不能为空!");
		}
		if(this.newpassword==null || this.newpassword.trim().equals(""))
		{
			flag = false;
			this.errors.put("newpassword", "新密码不能为空!");
		}
		if(this.confirmpassword==null || this.confirmpassword.trim().equals(""))
		{
			flag = false;
			this.errors.put("confirmpassword", "确认密码不能为空!");
		}
		else if(this.newpassword!=null && !this.newpassword.trim().equals(this.confirmpassword.trim()))
		{
			flag =false;
			this.errors.put("confirmpassword", "两次密码不一致!");
		}
		return flag;
	}
	
}
