package com.zzti.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.PasswordChangeRequest;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;
import com.zzti.utils.Common;
import com.zzti.utils.DateUtils;
import com.zzti.utils.DateUtils.DateStyle;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ResetPasswordForm;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String guid = request.getParameter("guid").trim();
		if(guid==null || guid.equals("")|| guid.length()!=36)
		{			
			request.setAttribute("message", "参数错误!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//get a record from database by id
		TResult<PasswordChangeRequest> result = new com.zzti.business.PasswordChangeRequestBusiness().getModel(guid);
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		ObjectMapper mapper = new ObjectMapper();
		PasswordChangeRequest data = mapper.convertValue(result.getT(), PasswordChangeRequest.class);
		
		//compare date 
		Date date = DateUtils.StringToDate(data.getAddTime(), DateStyle.YYYY_MM_DD_HH_MM_SS);
		date = DateUtils.addHour(date, 1);		
		if(date.before(new Date()))//invalid
		{
			request.setAttribute("message", "链接已经失效!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		ResetPasswordForm form = WebUtils.requestToBean(request, ResetPasswordForm.class);
		boolean flag = form.validate();
		if(!flag)//void
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/reset_password.jsp").forward(request, response);
			return;
		}
		
		//update passwordchangerequest status
		Result result1 = new com.zzti.business.PasswordChangeRequestBusiness().update(data);
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//reset contact password
		Contact contact = new Contact();
		contact.setEmail(data.getEmail());
		contact.setPassword(Common.getMD5(form.getConfirmpassword()));
		result1 = new com.zzti.business.ContactBusiness().resetPwd(contact);
		if(result1.getResult()!=1)
		{
			request.setAttribute("message", result1.getMessage());
		}
		else
		{
			request.setAttribute("message", String.format("重置密码成功,点击<a href='%s/servlet/LoginUIServlet'>返回</a>登录...",request.getContextPath()));
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
