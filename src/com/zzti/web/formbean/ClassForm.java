package com.zzti.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class ClassForm {

	public ClassForm() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private String vocational;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVocational() {
		return vocational;
	}
	public void setVocational(String vocational) {
		this.vocational = vocational;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	/**
	 * 验证
	 * @return
	 */
	public boolean validate()
	{
		boolean flag = true;
		if(this.name ==null ||this.name.trim().equals(""))
		{
			this.errors.put("name", "名称不能为空");
			flag =false;
		}
		if(this.vocational ==null || this.vocational.trim().equals(""))
		{
			this.errors.put("vocational", "专业不能为空");
			flag = false;
		}
		
		return flag;
	}
}
