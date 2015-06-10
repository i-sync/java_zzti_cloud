package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.TResult;
import com.zzti.utils.Common;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.LoginForm;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object obj = request.getSession().getAttribute("id");
		int id = obj ==null?0:Integer.parseInt(obj.toString());
		if(id!=0)
		{
			response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");	
			return;
		}
		
		LoginForm form = WebUtils.requestToBean(request, LoginForm.class);
		boolean flag = form.validate();
		if(!flag)//void
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/").forward(request, response);
			return;
		}
		Contact data = new Contact();
		data.setPhone(form.getPhone());
		data.setPassword(Common.getMD5(form.getPassword()));
		System.out.println("-------password-------->"+Common.getMD5(form.getPassword()));
		TResult<Contact> result = new com.zzti.business.ContactBusiness().login(data);
		if(result ==null)
		{
			request.setAttribute("message","未知异常");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		switch(result.getResult())
		{
			case -2://输入的密码错误!
				form.getErrors().put("password", result.getMessage());
				request.setAttribute("form", form);
				request.getRequestDispatcher("/").forward(request, response);
				break;
			case -1://输入的手机号不存在!
				form.getErrors().put("phone", result.getMessage());
				request.setAttribute("form", form);
				request.getRequestDispatcher("/").forward(request, response);
				break;
			case 0://Exception
				request.setAttribute("message", result.getMessage());
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				break;
			default://default success
				ObjectMapper mapper = new ObjectMapper();
				data = mapper.convertValue(result.getT(), Contact.class);
				HttpSession session = request.getSession();
				System.out.println(data.getId());
				session.setAttribute("id", data.getId());
				//登录成功  跳转到首页
				response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");	
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
