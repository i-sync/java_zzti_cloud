package com.zzti.business;

import java.net.URI; 

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget; 
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

public class Common {
	private static WebTarget target;
	static
	{
		ClientConfig config = new ClientConfig();	
		Client client = ClientBuilder.newClient(config);
		target = client.target(getBaseURI());
	}
	public Common() {
		// TODO Auto-generated constructor stub
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(com.zzti.utils.Common.ServiceURL).build();
	}
	
	/*
	 * post method 
	 */
	public static <T> T postT(String path,String acceptType ,Object obj,Class<T> classType)
	{
		T t = null;
		try
		{
			t = classType.newInstance();
			String data = new Gson().toJson(obj);
			//System.out.println("data:"+data);
			Form form = new Form();
			form.param("data", data);
			Response res = target.path(path).request().accept(acceptType).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
			t = res.readEntity(classType);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return t;
	}
	
	/*
	 * get method
	 */
	public static <T> T getT(String path,String acceptType,Class<T> classType)
	{
		T t = null;
		try
		{
			t = classType.newInstance();
			Response res = target.path(path).request().accept(acceptType).get();
			t = res.readEntity(classType);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return t;
	}
}
