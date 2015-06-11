package com.zzti.business;

import javax.ws.rs.core.MediaType;

import com.zzti.bean.PasswordChangeRequest;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;

public class PasswordChangeRequestBusiness {
	public PasswordChangeRequestBusiness(){}
	
	/**
	 * add a record
	 * @param data
	 * @return
	 */
	public Result add(PasswordChangeRequest data)
	{
		return Common.postT("/passwordchangerequest/add", MediaType.APPLICATION_JSON, data, Result.class);
	}
	
	/**
	 * update a record
	 * @param data
	 * @return
	 */
	public Result update(PasswordChangeRequest data)
	{
		return Common.postT("/passwordchangerequest/update", MediaType.APPLICATION_JSON, data, Result.class);
	}
	
	/**
	 * get a model by id
	 * @param id
	 * @return
	 */
	public TResult<PasswordChangeRequest> getModel(String id)
	{
		return Common.getT("/passwordchangerequest/model/"+id, MediaType.APPLICATION_JSON, TResult.class);
	}
}
