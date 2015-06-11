package com.zzti.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Object obj = request.getSession().getAttribute("id");
		int id = obj ==null?0:Integer.parseInt(obj.toString());
		if(id==0)
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
