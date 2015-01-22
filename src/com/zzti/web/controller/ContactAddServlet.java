package com.zzti.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import com.zzti.business.ClassBusiness;
import com.zzti.business.ContactBusiness;
import com.zzti.service.Contact;
import com.zzti.service.ListResult;
import com.zzti.service.Result;
import com.zzti.utils.DateUtils;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ContactForm;

/**
 * Servlet implementation class ContactAddServlet
 */
@WebServlet("/ContactAddServlet")
public class ContactAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactForm form = WebUtils.requestToBean(request, ContactForm.class);
		boolean flag = form.validate();
		//验证
		if(!flag)
		{
			//获取班级列表 
			ListResult<com.zzti.service.Class> result = new ClassBusiness().getList();
			if(result.getResult()!=1)
			{
				request.setAttribute("message", result.getMessage());
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			request.setAttribute("list", result.getList());
			//表单
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/contact/contact_add.jsp").forward(request, response);
			return;
		}
		
		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		data.setIp(WebUtils.getRemoteAddress(request));
		//添加联系人
		Result result = new ContactBusiness().add(data);
		if(result.getResult()!=1)
		{
			if(result.getResult()==-1)//说明用户名已存在
			{
				//错误信息
				form.getErrors().put("name", result.getMessage());
				//获取班级列表 
				ListResult<com.zzti.service.Class> result1 = new ClassBusiness().getList();				
				request.setAttribute("list", result1.getList());				
				
				//表单
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/jsp/contact/contact_add.jsp").forward(request, response);
				return;
			}
			
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//添加成功  跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/servlet/ContactListUIServlet");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
