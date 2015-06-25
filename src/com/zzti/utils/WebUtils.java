package com.zzti.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class WebUtils {

	public static <T> T requestToBean(HttpServletRequest request,
			Class<T> beanClass) {
		try {
			// 1/创建要封装数据的Bean
			T bean = beanClass.newInstance();
			// 2/把request中的数据库封装到Bean
			Boolean getMethod = request.getMethod().equalsIgnoreCase("get")?true:false;
			Enumeration<String> e =getMethod?request.getAttributeNames(): request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				String value = getMethod ? (String) request.getAttribute(name): request.getParameter(name);
				
				BeanUtils.setProperty(bean, name, value);
			}

			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> T requestToBean(HttpServletRequest request,
			Class<T> beanClass,String root) {
		try {
			// 1/创建要封装数据的Bean
			T bean = beanClass.newInstance();
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
	                String name = item.getFieldName();
	                String value = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
	                // ... (do your job here)
	                BeanUtils.setProperty(bean, name, value);
	            } else {
	                // Process form file field (input type="file").
	                String fieldName = item.getFieldName();
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContent = item.getInputStream();
	                // ... (do your job here)
	                if(fileContent==null || fileName==null || fileName.trim().equals(""))
	                	continue;
	                //save image	                
	                fileName= String.format("%d%s",new Date().getTime(),fileName.substring(fileName.lastIndexOf(".")));
	                //System.out.println(fileName);	           
	                String filePath = String.format("%s/%s/%s",root,Common.ImagePath,fileName);
	                System.out.println(filePath);

	                FileOutputStream out=new FileOutputStream(new File(filePath));
	                byte[] byteBuffer = new byte[1024];
	                int length = 0;
	                while ((fileContent != null) && ((length = fileContent.read(byteBuffer)) != -1)){
	                	out.write(byteBuffer,0,length);
	                }
	                out.flush();
	                out.close();
	                fileContent.close();
	                BeanUtils.setProperty(bean, fieldName, String.format("/%s/%s",Common.ImagePath,fileName));	                
	            }
	        }

			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void copyBean(Object src, Object dest) {
		/*
		 * formbean private String personCode; private String personName;
		 * private String did; private String password; private String
		 * password1;
		 * 
		 * protected int did; protected int id; protected String password;
		 * protected String personCode; protected String personName;
		 */
		try {

			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * <p>
	 * Discription:HttpServletRequest获取客户端IP方法
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getHeader("Proxy-Client-IP");
		//System.out.println(ip);
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getHeader("WL-Proxy-Client-IP");
		//System.out.println(ip);
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getRemoteAddr();
		//System.out.println(ip);
		return ip;
	}
}
