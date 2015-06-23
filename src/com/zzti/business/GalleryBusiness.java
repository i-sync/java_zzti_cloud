package com.zzti.business;

import javax.ws.rs.core.MediaType;

import com.zzti.bean.Gallery;
import com.zzti.bean.ListResult;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;

public class GalleryBusiness {
	/**
	 * add Gallery
	 * @param data
	 * @return
	 */
	public Result add(Gallery data)
	{
		return Common.postT("/gallery/add", MediaType.APPLICATION_JSON, data, Result.class);
	}
	/**
	 * update Gallery
	 * @param data
	 * @return
	 */
	public Result update (Gallery data)
	{
		return Common.postT("/gallery/update", MediaType.APPLICATION_JSON, data, Result.class);
	}
	
	/**
	 * delete Gallery
	 * @param data
	 * @return
	 */
	public Result delete(Gallery data)
	{
		return Common.postT("/gallery/delete", MediaType.APPLICATION_JSON, data, Result.class);
	}
	/**
	 * get Gallery model
	 * @param data
	 * @return
	 */
	public TResult<Gallery> getModel(Gallery data)
	{
		return  Common.postT("/gallery/model", MediaType.APPLICATION_JSON, data, TResult.class);
	}
	/**
	 * get Gallery list 
	 * @param data
	 * @return
	 */
	public ListResult<Gallery> getList(Gallery data)
	{
		return Common.postT("/gallery/list", MediaType.APPLICATION_JSON, data, ListResult.class);
	}
}
