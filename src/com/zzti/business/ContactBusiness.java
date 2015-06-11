package com.zzti.business;

import javax.ws.rs.core.MediaType;

import com.zzti.bean.Contact;
import com.zzti.bean.ListResult;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;

public class ContactBusiness {
	//private ContactSEI service = Common.getInstace().getService();
	public ContactBusiness() {
	}
	
	/**
	 * login
	 * @param data
	 * @return
	 */
	public TResult<Contact> login(Contact data)
	{
		return Common.postT("/contact/login", MediaType.APPLICATION_JSON, data, TResult.class);
	}
	
	/**
	 * check email if exist
	 * @param email
	 * @return
	 */
	public Boolean emailExist(String email)
	{		
		return Common.getT("/contact/email/"+email, MediaType.TEXT_PLAIN, Boolean.class);
	}
	
	/**
	 * add contact
	 * @param data
	 * @return
	 */
	public Result add(Contact data)
	{
		return Common.postT("/contact/add", MediaType.APPLICATION_JSON, data, Result.class);
	}
	/**
	 * update contact
	 * @param data
	 * @return
	 */
	public Result update (Contact data)
	{
		return Common.postT("/contact/update", MediaType.APPLICATION_JSON, data, Result.class);
	}
	
	/**
	 * update contact password
	 * @param data
	 * @return
	 */
	public Result updatePwd(Contact data)
	{
		return Common.postT("/contact/updatepwd", MediaType.APPLICATION_JSON, data, Result.class);
	}
	
	/**
	 * delete contact
	 * @param data
	 * @return
	 */
	public Result delete(Contact data)
	{
		return Common.postT("/contact/delete", MediaType.APPLICATION_JSON, data, Result.class);
	}
	/**
	 * get contact model
	 * @param data
	 * @return
	 */
	public TResult<Contact> getModel(Contact data)
	{
		return  Common.postT("/contact/model", MediaType.APPLICATION_JSON, data, TResult.class);
	}
	/**
	 * get contact list 
	 * @param data
	 * @return
	 */
	public ListResult<Contact> getList(Contact data)
	{
		return Common.postT("/contact/list", MediaType.APPLICATION_JSON, data, ListResult.class);
	}

}
