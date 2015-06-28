package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.Result;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.Common;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.PasswordForm;

/**
 * Servlet implementation class PasswordUpdateServlet
 */
@WebServlet("/PasswordUpdateServlet")
public class PasswordUpdateServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordForm form = WebUtils.requestToBean(request, PasswordForm.class);
		boolean flag = form.validate();
		if(!flag)//void
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
			return;
		}
		
		//get user id ,and get user info form database		
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact data = mapper.convertValue(obj, Contact.class);
		
		//oldpasswrod not match user password
		if(!Common.getMD5(form.getOldpassword()).equals(data.getPassword()))
		{
			form.getErrors().put("oldpassword", "旧密码输入错误!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
			return;
		}
		
		data.setPassword(Common.getMD5(form.getConfirmpassword()));
		Result result = new com.zzti.business.ContactBusiness().updatePwd(data);
		if(result.getResult()!=1)//update error
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;			
		}
		//password update success
		response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
	}
}
