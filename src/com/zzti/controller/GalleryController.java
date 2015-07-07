package com.zzti.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.Gallery;
import com.zzti.bean.ListResult;
import com.zzti.bean.Login;
import com.zzti.bean.Page;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;
import com.zzti.business.GalleryBusiness;
import com.zzti.utils.Common;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.GalleryForm;

@Controller
@RequestMapping(value = { "/gallery", "/" })
public class GalleryController {
	
	@Autowired
	ServletContext context;

	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public String getList(
			@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
			ModelMap model) {
		Page page = new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(Common.GalleryPageSize);
		
		Gallery data= new Gallery();
		data.setPage(page);
		
		ListResult<Gallery> result = new GalleryBusiness().getList(data);
		if (result.getResult() != 1) {
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		int total = Integer.parseInt(result.getObj().toString());
		total =(int) Math.ceil((total*1.0)/page.getPageSize());
		page.setTotalCount(total);
		model.addAttribute("list", result.getList());
		model.addAttribute("page", page);
		//request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return "index";
	}

	@Login
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGallery(ModelMap model)
	{
		return "gallery_add";
	}

	@Login
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGallery(@RequestParam(value="picture") MultipartFile file, ModelMap model, HttpServletRequest request)
	{
		String root =context.getRealPath(File.separator);
		GalleryForm form = WebUtils.requestToBean(request, GalleryForm.class);
		form.setPicture(file.isEmpty()?"":file.getOriginalFilename());
		boolean flag = form.validate();
		if(!flag)
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/gallery/gallery_add.jsp").forward(request, response);
			return "gallery_add";
		}
		if(!file.isEmpty())
		{
			try {
				form.setPicture(WebUtils.saveFile(file.getInputStream(), file.getOriginalFilename(), root));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//get user
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact contact = mapper.convertValue(obj, Contact.class);
					
		Gallery data = new Gallery();
		WebUtils.copyBean(form, data);
		data.setCid(contact.getId());//set create userid and username
		data.setCname(contact.getName());
		Result result= new GalleryBusiness().add(data);
		if(result.getResult() !=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
		return "redirect:/gallery/list";
	}

	@Login
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGallery(@RequestParam int id, ModelMap model)
	{
		//根据ID获取对象
		Gallery data =  new Gallery();
		data.setId(id);
		
		TResult<Gallery> result = new GalleryBusiness().getModel(data);
		if(result.getResult()!=1)//如果获取失败
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		GalleryForm form = new GalleryForm();
		WebUtils.copyBean(result.getT(),form);
		model.addAttribute("form", form);
		
		//request.getRequestDispatcher("/WEB-INF/jsp/gallery/gallery_update.jsp").forward(request, response);
		return "gallery_update";
	}
	
	@Login
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String updateGallery(@RequestParam(value="picture",required = false) MultipartFile file, ModelMap model, HttpServletRequest request)
	{
		String root =context.getRealPath(File.separator);	
		GalleryForm form = WebUtils.requestToBean(request,GalleryForm.class);
		form.setPicture(file.isEmpty()?"":file.getOriginalFilename());
		boolean flag = form.validate();
		if(!flag)
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/gallery/gallery_add.jsp").forward(request, response);
			return "gallery_update";
		}
		if(!file.isEmpty())
		{
			try {
				form.setPicture(WebUtils.saveFile(file.getInputStream(), file.getOriginalFilename(), root));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
		return "redirect:/gallery/list";
	}

	@Login
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGallery(@PathVariable int id, ModelMap model)
	{
		Gallery data = new Gallery();
		data.setId(id);
		Result result = new GalleryBusiness().delete(data);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
		return "redirect:/gallery/list";
	}
}
