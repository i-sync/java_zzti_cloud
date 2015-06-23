package com.zzti.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Gallery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1446025603161463132L;
	
	private int id;
	private int cid;
	private String cname;
	private String title;
	private String caption;
	private String content;
	private String picture;
	private Date addDate;
	private Date updateDate;
	private Page page;
	
	public Gallery(){}
	public Gallery(int cid,String cname,String title,String caption,String content,String picture,Date addDate,Date updateDate)
	{
		this.cid = cid;
		this.cname = cname;
		this.title =title;
		this.caption = caption;
		this.content = content;
		this.picture = picture;
		this.addDate = addDate;
		this.updateDate = updateDate;
	}
	
	public Gallery(int id,int cid,String cname,String title,String caption,String content,String picture,Date addDate,Date updateDate)
	{
		this(cid,cname,title,caption,content,picture,addDate,updateDate);
		this.id= id;
	}
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
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
