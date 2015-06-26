package com.zzti.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class CharsetEncodingFilter implements Filter {

	private  String defaultcharacter = null;
	private String encoding = null;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setCharacterEncoding(encoding);
		if (request.getMethod().equalsIgnoreCase("get"))
		{
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				String value = request.getParameter(name);			
				value = new String(value.getBytes(defaultcharacter),encoding);
				request.setAttribute(name, value);
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
		servletResponse.setCharacterEncoding(encoding);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encode");
		this.defaultcharacter = filterConfig.getInitParameter("default");
		// System.out.println(this.encoding);
	}

}
