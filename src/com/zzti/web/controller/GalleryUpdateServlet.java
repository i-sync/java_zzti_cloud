package com.zzti.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.Gallery;
import com.zzti.bean.Result;
import com.zzti.business.GalleryBusiness;
import com.zzti.common.HttpBaseServlet;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.GalleryForm;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GalleryUpdateServlet
 */
@WebServlet("/GalleryUpdateServlet")
public class GalleryUpdateServlet extends HttpBaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpBaseServlet#HttpBaseServlet()
     */
    public GalleryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDeal(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String root =getServletContext().getRealPath(File.separator);
		GalleryForm form = WebUtils.requestToBean(request, GalleryForm.class,root);
		boolean flag = form.validate();
		if(!flag)
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/gallery/gallery_add.jsp").forward(request, response);
			return;
		}
		//get user
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact contact = mapper.convertValue(obj, Contact.class);
							
		Gallery data = new Gallery();
		WebUtils.copyBean(form, data);
		data.setCid(contact.getId());//set create userid and username
		data.setCname(contact.getName());
		Result result= new GalleryBusiness().update(data);
		if(result.getResult() !=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
	}

}
