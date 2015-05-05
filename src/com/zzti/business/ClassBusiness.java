package com.zzti.business;

import javax.ws.rs.core.MediaType;
 
import com.zzti.bean.ListResult;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;

public class ClassBusiness {
	//private ContactSEI service = Common.getInstace().getService();
	
	/**
	 * add class
	 * @param data
	 * @return
	 */
	public Result add(com.zzti.bean.Class data)
	{
		//return service.classAdd(data);
		return Common.postT("/class/add", MediaType.APPLICATION_JSON, data,Result.class);
	}
	/**
	 * update class object
	 * @param data
	 * @return
	 */
	public Result update(com.zzti.bean.Class data)
	{
		return Common.postT("/class/update", MediaType.APPLICATION_JSON, data,Result.class);
	}
	/**
	 * delete class object
	 * @param data
	 * @return
	 */
	public Result delete(com.zzti.bean.Class data)
	{
		return Common.postT("/class/detele", MediaType.APPLICATION_JSON, data,Result.class);
	}
	/**
	 * get class object 
	 * @param data
	 * @return
	 */
	public com.zzti.bean.TResult<com.zzti.bean.Class> getModel(com.zzti.bean.Class data)
	{
		return Common.postT("/class/model", MediaType.APPLICATION_JSON, data,com.zzti.bean.TResult.class);
	}
	/**
	 * get class list
	 * @return
	 */
	public com.zzti.bean.ListResult<com.zzti.bean.Class> getList()
	{
		return Common.getT("/class/list", MediaType.APPLICATION_JSON,com.zzti.bean.ListResult.class);
	}
}
