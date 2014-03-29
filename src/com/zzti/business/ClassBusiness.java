package com.zzti.business;

import com.zzti.service.ContactSEI;
import com.zzti.service.ListResult;
import com.zzti.service.Result;
import com.zzti.service.TResult;

public class ClassBusiness {
	private ContactSEI service = Common.getInstace().getService();
	
	/**
	 * 添加班级对象
	 * @param data
	 * @return
	 */
	public Result add(com.zzti.service.Class data)
	{
		return service.classAdd(data);
	}
	/**
	 * 修改班级对象
	 * @param data
	 * @return
	 */
	public Result update(com.zzti.service.Class data)
	{
		return service.classUpdate(data);
	}
	/**
	 * 删除班级对象
	 * @param data
	 * @return
	 */
	public Result delete(com.zzti.service.Class data)
	{
		return service.classDelete(data);
	}
	/**
	 * 获取班级对象
	 * @param data
	 * @return
	 */
	public TResult<com.zzti.service.Class> getModel(com.zzti.service.Class data)
	{
		return service.classGetModel(data);
	}
	/**
	 * 获取班级对象列表
	 * @return
	 */
	public ListResult<com.zzti.service.Class> getList()
	{
		return service.classGetList();
	}
}
