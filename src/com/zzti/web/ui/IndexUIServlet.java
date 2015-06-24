package com.zzti.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.zzti.bean.Gallery;
import com.zzti.bean.Gallery;
import com.zzti.bean.ListResult;
import com.zzti.bean.Page;
import com.zzti.bean.TResult;
import com.zzti.business.GalleryBusiness;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.Common;

/**
 * Servlet implementation class IndexUIServlet
 */
@WebServlet("/IndexUIServlet")
public class IndexUIServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageIndex = request.getParameter("pageIndex") == null ? 1 : Integer
				.parseInt(request.getParameter("pageIndex"));
		Page page = new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(Common.GalleryPageSize);
		
		Gallery data= new Gallery();
		data.setPage(page);
		
		ListResult<Gallery> result = new GalleryBusiness().getList(data);
		if (result.getResult() != 1) {
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		int total = Integer.parseInt(result.getObj().toString());
		total =(int) Math.ceil((total*1.0)/page.getPageSize());
		page.setTotalCount(total);
		request.setAttribute("list", result.getList());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}
}
