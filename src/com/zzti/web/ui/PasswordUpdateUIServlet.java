package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.common.HttpBaseServlet;

/**
 * Servlet implementation class PasswordUpdateUIServlet
 */
@WebServlet("/PasswordUpdateUIServlet")
public class PasswordUpdateUIServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordUpdateUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
	}
}
