package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.bean.Class;
import com.zzti.bean.TResult;
import com.zzti.utils.RegexUtil;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ClassForm;

/**
 * Servlet implementation class ClassUpdateUIServlet
 */
@WebServlet("/ClassUpdateUIServlet")
public class ClassUpdateUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassUpdateUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		//判断参数是否正确
		if(!RegexUtil.isInteger(id))
		{
			request.setAttribute("message", "参数错误！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//根据ID获取对象
		Class data =  new Class();
		data.setId(Integer.parseInt(id));
		
		TResult<Class> result = new ClassBusiness().getModel(data);
		if(result.getResult()!=1)//如果获取失败
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//把结果转换为formbean
		ClassForm form = new ClassForm();
		WebUtils.copyBean(result.getT(), form);
		request.setAttribute("form", form);
		
		//response.sendRedirect(request.getContextPath()+"/");
		request.getRequestDispatcher("/WEB-INF/jsp/class/class_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
