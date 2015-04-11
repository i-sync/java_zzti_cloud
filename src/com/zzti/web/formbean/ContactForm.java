package com.zzti.web.formbean;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.zzti.utils.RegexUtil;
import com.zzti.utils.StringUtils;

public class ContactForm {

	public ContactForm() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private int cid;
	private String cname;
	private String phone;
	private String email;
	private String living;
	private String company;
	private String remark;
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	/**
	 * 验证表单
	 * 
	 * @return
	 */
	public boolean validate() {
		boolean flag = true;
		// 验证姓名
		if (this.name == null || this.name.trim().equals("")) {
			flag = false;
			this.errors.put("name", "姓名不能为空!");
		}
		// 验证班级
		if (this.cid == 0) {
			flag = false;
			this.errors.put("cid", "请选择班级!");
		}
		// 验证手机号
		if (this.phone == null || this.phone.trim().equals("")) {
			flag = false;
			this.errors.put("phone", "手机号不能为空!");
		} else// 验证手机号是否正确
		{
			if (!RegexUtil.isPhone(this.phone)) {
				flag = false;
				this.errors.put("phone", "请输入正确的手机号码!");
			}
		}
		// 验证邮箱（可空）
		if (this.email != null && !this.email.trim().equals("")) {
			if (!RegexUtil.isEmail(this.email)) {
				flag = false;
				this.errors.put("email", "请输入正确的邮箱地址!");
			}
		}

		return flag;
	}
}
