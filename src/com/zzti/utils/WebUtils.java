package com.zzti.utils;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

	public static <T> T requestToBean(HttpServletRequest request,
			Class<T> beanClass) {
		try {
			// 1/创建要封装数据的Bean
			T bean = beanClass.newInstance();
			// 2/把request中的数据库封装到Bean
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
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
		System.out.println(ip);
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getHeader("WL-Proxy-Client-IP");
		System.out.println(ip);
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getRemoteAddr();
		System.out.println(ip);
		return ip;
	}
}
