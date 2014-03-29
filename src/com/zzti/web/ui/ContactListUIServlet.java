package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.business.ContactBusiness;
import com.zzti.service.Contact;
import com.zzti.service.ListResult;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ContactForm;

/**
 * Servlet implementation class ContactListUIServlet
 */
@WebServlet("/ContactListUIServlet")
public class ContactListUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactListUIServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactForm form = WebUtils.requestToBean(request, ContactForm.class);
		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		request.setAttribute("form", form);
		
		//获取班级列表
		ListResult<com.zzti.service.Class> result = new ClassBusiness().getList();
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("cList", result.getList());
		
		//查询联系人列表
		ListResult<Contact> result1 = new ContactBusiness().getList(data);
		if(result1.getResult()!=1)
		{
			request.setAttribute("message", result1.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("list", result1.getList());
		
		request.getRequestDispatcher("/WEB-INF/jsp/contact/contact_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
