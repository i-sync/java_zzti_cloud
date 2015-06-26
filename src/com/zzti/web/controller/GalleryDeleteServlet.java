package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.bean.Gallery;
import com.zzti.bean.Result;
import com.zzti.business.GalleryBusiness;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.RegexUtil;

/**
 * Servlet implementation class GalleryDeleteServlet
 */
@WebServlet("/GalleryDeleteServlet")
public class GalleryDeleteServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpBaseServlet#HttpBaseServlet()
     */
    public GalleryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDeal(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		// 判断参数是否正确
		if (!RegexUtil.isInteger(id)) {
			request.setAttribute("message", "参数错误！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,
					response);
			return;
		}
		
		Gallery data = new Gallery();
		data.setId(Integer.parseInt(id));
		Result result = new GalleryBusiness().delete(data);
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,
					response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
	}

}
