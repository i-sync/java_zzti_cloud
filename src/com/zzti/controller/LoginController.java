package com.zzti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.TResult;
import com.zzti.utils.Common;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact data = mapper.convertValue(obj, Contact.class);
		if(data !=null)
		{
			//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");	
			return "redirect:/gallery/list";
		}
		//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute com.zzti.web.formbean.LoginForm form, ModelMap model, HttpServletRequest request)
	{
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact data = mapper.convertValue(obj, Contact.class);
		if(data !=null)
		{
			//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");	
			return "redirect:/gallery/list";
		}
		
		//LoginForm form = WebUtils.requestToBean(request, LoginForm.class);
		boolean flag = form.validate();
		if(!flag)//void
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return "login";
		}
		data = new Contact();
		data.setPhone(form.getPhone());
		data.setPassword(Common.getMD5(form.getPassword()));
		TResult<Contact> result = new com.zzti.business.ContactBusiness().login(data);
		if(result ==null)
		{
			model.addAttribute("message","未知异常");
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		switch(result.getResult())
		{
			case -2://输入的密码错误!
				form.getErrors().put("password", result.getMessage());
				model.addAttribute("form", form);
				//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return "login";
				//break;
			case -1://输入的手机号不存在!
				form.getErrors().put("phone", result.getMessage());
				model.addAttribute("form", form);
				//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return "login";
				//break;
			case 0://Exception
				model.addAttribute("message", result.getMessage());
				//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return "message";
				//break;
			default://default success
				
				HttpSession session = request.getSession();
				//System.out.println(data.getId());
				session.setAttribute("user", result.getT());
				//登录成功  跳转到首页
				//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");	
				return "redirect:/gallery/list";
				//break;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		Object obj = request.getSession().getAttribute("user");
		if(obj!=null)
			request.getSession().removeAttribute("user");
		//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
		return "redirect:/gallery/list";
	}
}
