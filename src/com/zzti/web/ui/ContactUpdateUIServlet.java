package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.business.ContactBusiness;
import com.zzti.service.Class;
import com.zzti.service.Contact;
import com.zzti.service.ListResult;
import com.zzti.service.TResult;
import com.zzti.utils.RegexUtil;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ContactForm;

/**
 * Servlet implementation class ContactUpdateUIServlet
 */
@WebServlet("/ContactUpdateUIServlet")
public class ContactUpdateUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//判断参数是否正确
		if (!RegexUtil.isInteger(id)) {
			request.setAttribute("message", "参数错误！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		//获取班级列表
		ListResult<Class> result = new ClassBusiness().getList();
		if (result.getResult() != 1) {
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("list", result.getList());
		
		//获取联系对象 
		Contact data = new Contact();
		data.setId(Integer.parseInt(id));
		TResult<Contact> result1 = new ContactBusiness().getModel(data);
		if(result1.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		ContactForm form = new ContactForm();
		WebUtils.copyBean(result1.getT(),form);
		request.setAttribute("form", form);
		
		request.getRequestDispatcher("/WEB-INF/jsp/contact/contact_update.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
