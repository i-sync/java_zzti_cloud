package com.zzti.web.formbean;

import java.awt.Image;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zzti.utils.RegexUtil;

public class GalleryForm {

	public GalleryForm() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int cid;
	private String cname;
	private String title;
	private String caption;
	private String content;
	private String picture;
	private Date addDate;
	private Date updateDate;
	private Map<String, String> errors = new HashMap<String, String>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	/**
	 * 验证表单
	 * @return
	 */
	public boolean validate() {
		boolean flag = true;
		//
		if(this.title==null|| this.title.trim().equals(""))
		{
			flag=false;
			this.errors.put("title", "名称不能为空！");
		}
		//
		if(this.caption ==null || this.caption.trim().equals(""))
		{
			flag=false;
			this.errors.put("caption", "标题不能为空!");
		}
		//
		if ((this.picture == null ||this.picture.trim().equals("")) && this.id == 0)
		{
			flag= false;
			this.errors.put("picture", "图片不可为空！");
		} 
		return flag;
	}
}
