package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.bean.Class;
import com.zzti.bean.Result;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.RegexUtil;

/**
 * Servlet implementation class ClassDeleteServlet
 */
@WebServlet("/ClassDeleteServlet")
public class ClassDeleteServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doDeal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		// 判断参数是否正确
		if (!RegexUtil.isInteger(id)) {
			request.setAttribute("message", "参数错误！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,
					response);
			return;
		}
		
		Class data = new Class();
		data.setId(Integer.parseInt(id));
		Result result = new ClassBusiness().delete(data);
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/servlet/ClassListUIServlet");
	}
}
