package com.zzti.web.ui;

import com.zzti.bean.Gallery;
import com.zzti.bean.TResult;
import com.zzti.business.GalleryBusiness;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.RegexUtil;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.GalleryForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GalleryUpdateUIServlet
 */
@WebServlet("/GalleryUpdateUIServlet")
public class GalleryUpdateUIServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpBaseServlet#HttpBaseServlet()
     */
    public GalleryUpdateUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDeal(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		//判断参数是否正确
		if(!RegexUtil.isInteger(id))
		{
			request.setAttribute("message", "参数错误！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//根据ID获取对象
		Gallery data =  new Gallery();
		data.setId(Integer.parseInt(id));
		
		TResult<Gallery> result = new GalleryBusiness().getModel(data);
		if(result.getResult()!=1)//如果获取失败
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		GalleryForm form = new GalleryForm();
		WebUtils.copyBean(result.getT(),form);
		request.setAttribute("form", form);
		
		request.getRequestDispatcher("/WEB-INF/jsp/gallery/gallery_update.jsp")
				.forward(request, response);
	}

}
