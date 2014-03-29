package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.service.ListResult;
import com.zzti.service.Result;

/**
 * Servlet implementation class ClassListUIServlet
 */
@WebServlet("/ClassListUIServlet")
public class ClassListUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListUIServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取班级列表 
		ListResult<com.zzti.service.Class> result = new ClassBusiness().getList();
		if(result.getResult()==0)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
		request.setAttribute("list", result.getList());
		request.getRequestDispatcher("/WEB-INF/jsp/class/class_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
