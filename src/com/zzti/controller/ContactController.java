package com.zzti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzti.bean.Class;
import com.zzti.bean.Contact;
import com.zzti.bean.ListResult;
import com.zzti.bean.Page;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;
import com.zzti.business.ClassBusiness;
import com.zzti.business.ContactBusiness;
import com.zzti.utils.Common;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ContactForm;
import com.zzti.bean.Login;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Login
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "phone", defaultValue = "") String phone,
			@RequestParam(value = "cid", defaultValue = "0") int cid,
			@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
			ModelMap model) {
		ContactForm form = new ContactForm();// WebUtils.requestToBean(request,
												// ContactForm.class);
		form.setName(name);
		form.setPhone(phone);
		form.setCid(cid);
		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		model.addAttribute("form", form);
		//int pageIndex = request.getParameter("pageIndex") == null ? 1 : Integer
		//		.parseInt(request.getParameter("pageIndex"));
		Page page = new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(Common.PageSize);
		data.setPage(page);
		// 获取班级列表
		/*ListResult<com.zzti.bean.Class> result = new ClassBusiness()
				.getList();
		if (result.getResult() != 1) {
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		model.addAttribute("cList", result.getList());*/

		// 查询联系人列表
		ListResult<Contact> result1 = new ContactBusiness().getList(data);
		if (result1.getResult() != 1) {
			model.addAttribute("message", result1.getMessage());
			return "message";
		}
		int total = Integer.parseInt(result1.getObj().toString());
		total =(int) Math.ceil((total*1.0)/page.getPageSize());
		page.setTotalCount(total);
		model.addAttribute("list", result1.getList());
		model.addAttribute("page", page);
		
		return "contact_list";
	}
	
	/**
	 * get class list
	 */
	@ModelAttribute(value = "cList")
	public List<com.zzti.bean.Class> getClassList()
	{
		//获取班级列表 
		ListResult<com.zzti.bean.Class> result = new ClassBusiness().getList();
		return result.getList();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addContact(ModelMap model)
	{
		//获取班级列表
		/*ListResult<Class> result = new ClassBusiness().getList();
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		model.addAttribute("list", result.getList());*/
		return "contact_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute com.zzti.web.formbean.ContactForm form ,HttpServletRequest request, ModelMap model)
	{
		boolean flag = form.validate();
		//验证
		if(!flag)
		{
			//获取班级列表 
			/*ListResult<com.zzti.bean.Class> result = new ClassBusiness().getList();
			if(result.getResult()!=1)
			{
				model.addAttribute("message", result.getMessage());
				return "message";
			}
			model.addAttribute("list", result.getList());*/
			//表单
			model.addAttribute("form", form);
			return "contact_add";
		}
		
		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		data.setIp(WebUtils.getRemoteAddress(request));
		//添加联系人
		Result result = new ContactBusiness().add(data);
		switch(result.getResult())
		{
			case -2://email exist
				//错误信息
				form.getErrors().put("email", result.getMessage());
				//获取班级列表 
				/*ListResult<com.zzti.bean.Class> result2 = new ClassBusiness().getList();				
				model.addAttribute("list", result2.getList());*/				
				
				//表单
				model.addAttribute("form", form);
				return "contact_add";
			case -1://说明用户名已存在
				//错误信息
				form.getErrors().put("name", result.getMessage());
				//获取班级列表 
				/*ListResult<com.zzti.bean.Class> result1 = new ClassBusiness().getList();				
				model.addAttribute("list", result1.getList());*/				
				
				//表单
				model.addAttribute("form", form);
				return "contact_add";
			case 0:
				model.addAttribute("message", result.getMessage());
				return "message";
			default://default success
				//添加成功  跳转到列表页面
				return "redirect:/contact/list";		
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateContact(@RequestParam int id, ModelMap model)
	{
		//获取班级列表
		/*ListResult<Class> result = new ClassBusiness().getList();
		if (result.getResult() != 1) {
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		model.addAttribute("list", result.getList());*/
		
		//获取联系对象 
		Contact data = new Contact();
		data.setId(id);
		TResult<Contact> result1 = new ContactBusiness().getModel(data);
		if(result1.getResult()!=1)
		{
			model.addAttribute("message", result1.getMessage());
			return "message";
		}
		ContactForm form = new ContactForm();
		WebUtils.copyBean(result1.getT(),form);
		model.addAttribute("form", form);
		
		return "contact_update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String saveUpdateContact(@ModelAttribute com.zzti.web.formbean.ContactForm form ,HttpServletRequest request, ModelMap model)
	{
		boolean flag = form.validate();
		//验证
		if(!flag)
		{
			//获取班级列表 
			/*ListResult<com.zzti.bean.Class> result = new ClassBusiness().getList();
			if(result.getResult()!=1)
			{
				model.addAttribute("message", result.getMessage());
				return "message";
			}
			model.addAttribute("list", result.getList());*/
			//表单
			model.addAttribute("form", form);
			return "contact_update";
		}
		
		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		data.setIp(WebUtils.getRemoteAddress(request));
		//修改联系人
		Result result = new ContactBusiness().update(data);
		switch(result.getResult())
		{
			case -2://email exist
				//错误信息
				form.getErrors().put("email", result.getMessage());
				//获取班级列表 
				/*ListResult<com.zzti.bean.Class> result2 = new ClassBusiness().getList();				
				model.addAttribute("list", result2.getList());*/				
				
				//表单
				model.addAttribute("form", form);
				return "contact_update";
			case -1://说明用户名已存在
				//错误信息
				form.getErrors().put("name", result.getMessage());
				//获取班级列表 
				/*ListResult<com.zzti.bean.Class> result1 = new ClassBusiness().getList();				
				model.addAttribute("list", result1.getList());*/				
				
				//表单
				model.addAttribute("form", form);
				return "contact_update";
			case 0:
				model.addAttribute("message", result.getMessage());
				return "message";
			default://default success
				//添加成功  跳转到列表页面
				return "redirect:/contact/list";		
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)	
	public String deleteContact(@PathVariable int id, ModelMap model)
	{
		Contact data = new Contact();
		data.setId(id);
		Result result = new ContactBusiness().delete(data);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		return "redirect:/contact/list";
	}
}
