package com.zzti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzti.bean.Class;
import com.zzti.bean.ListResult;
import com.zzti.bean.Login;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;
import com.zzti.business.ClassBusiness;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ClassForm;

@Controller
@RequestMapping("/class")
public class ClassController {

	@Login
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(ModelMap model)
	{
		//获取班级列表 
		ListResult<com.zzti.bean.Class> result = new ClassBusiness().getList();
		if(result.getResult()==0)
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		model.addAttribute("list", result.getList());
		return "class_list";
	}

	@Login
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addClass(ModelMap model)
	{		
		return "class_add";
	}

	@Login
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveClass(@ModelAttribute com.zzti.web.formbean.ClassForm form, ModelMap model)
	{
		boolean flag = form.validate();
		if(!flag)
		{
			model.addAttribute("form", form);
			return "class_add";
		}
		
		Class data = new Class();
		WebUtils.copyBean(form, data);
		Result result= new ClassBusiness().add(data);
		if(result.getResult() !=1)
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		return "redirect:/class/list";
	}

	@Login
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateClass(@RequestParam int id,ModelMap model)
	{
		//根据ID获取对象
		Class data =  new Class(id);
		//data.setId(id);
		
		TResult<Class> result = new ClassBusiness().getModel(data);
		if(result.getResult()!=1)//如果获取失败
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		//把结果转换为formbean
		ClassForm form = new ClassForm();
		WebUtils.copyBean(result.getT(), form);
		model.addAttribute("form", form);
		
		return "class_update";
	}
	
	@Login
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String saveUpdateClass(@ModelAttribute com.zzti.web.formbean.ClassForm form, ModelMap model)
	{
		boolean flag = form.validate();
		if(!flag)
		{
			model.addAttribute("form", form);
			return "class_update";
		}
		
		Class data = new Class();
		WebUtils.copyBean(form, data);
		Result result= new ClassBusiness().update(data);
		if(result.getResult() !=1)
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		return "redirect:/class/list";
	}

	@Login
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteClass(@PathVariable int id, ModelMap model)
	{
		//根据ID获取对象
		Class data =  new Class(id);
		//data.setId(id);
		
		Result result = new ClassBusiness().delete(data);
		if(result.getResult()!=1)//如果获取失败
		{
			model.addAttribute("message", result.getMessage());
			return "message";
		}
		return "redirect:/class/list";
	}
}
