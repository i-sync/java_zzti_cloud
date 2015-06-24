package com.zzti.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;

/**
 * Servlet implementation class HttpBaseServlet
 */
@WebServlet("/HttpBaseServlet")
public abstract class HttpBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpBaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//check user is login
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact data = mapper.convertValue(obj, Contact.class);
		if(data ==null)
		{
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
			return ;
		}
		doDeal(request,response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	protected abstract void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
