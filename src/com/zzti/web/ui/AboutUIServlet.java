package com.zzti.web.ui;

import com.zzti.common.HttpBaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutUIServlet
 */
@WebServlet("/AboutUIServlet")
public class AboutUIServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpBaseServlet#HttpBaseServlet()
     */
    public AboutUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	request.getRequestDispatcher("/WEB-INF/jsp/about.jsp").forward(request, response);
    }

}
