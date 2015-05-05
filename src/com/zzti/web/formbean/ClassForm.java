package com.zzti.web.formbean;

import java.util.HashMap;
import java.util.Map;

import com.ctc.wstx.util.StringUtil;
import com.zzti.utils.StringUtils;

public class ClassForm {

	public ClassForm() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private String vocational;
	private Map<String, String> errors = new HashMap<String, String>();

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
<<<<<<< HEAD
	 * 楠岃瘉
=======
	 * 验证
	 * 
>>>>>>> f168441e13d90241f3f0ba83388b887e152f7f8d
	 * @return
	 */
	public boolean validate() {
		boolean flag = true;
<<<<<<< HEAD
		if(this.name ==null ||this.name.trim().equals(""))
		{
			this.errors.put("name", "鍚嶇О涓嶈兘涓虹┖");
			flag =false;
		}
		if(this.vocational ==null || this.vocational.trim().equals(""))
		{
			this.errors.put("vocational", "涓撲笟涓嶈兘涓虹┖");
=======
		if (this.name == null || this.name.trim().equals("")) {
			this.errors.put("name", "名称不能为空!");
			flag = false;
		}
		if (this.vocational == null || this.vocational.trim().equals("")) {
			this.errors.put("vocational", "专业不能为空!");
>>>>>>> f168441e13d90241f3f0ba83388b887e152f7f8d
			flag = false;
		}

		return flag;
	}
}
