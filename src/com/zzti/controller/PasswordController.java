package com.zzti.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzti.bean.Contact;
import com.zzti.bean.Login;
import com.zzti.bean.PasswordChangeRequest;
import com.zzti.bean.Result;
import com.zzti.bean.TResult;
import com.zzti.utils.Common;
import com.zzti.utils.DateUtils;
import com.zzti.utils.MailUtils;
import com.zzti.utils.DateUtils.DateStyle;
import com.zzti.web.formbean.ResetPasswordForm;

@Controller
@RequestMapping("/password")
public class PasswordController {
	
	@RequestMapping(value = "forgot", method = RequestMethod.GET)
	public String forgotPassword(ModelMap model) {
		return "forgot_password";
	}
	
	
	@RequestMapping(value="forgot",method= RequestMethod.POST)
	public String forgotPassword(@ModelAttribute com.zzti.web.formbean.ForgotPasswordForm form, ModelMap model,HttpServletRequest request)
	{
		//ForgotPasswordForm form = WebUtils.requestToBean(request, ForgotPasswordForm.class);
		if(!form.validate())
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/forgot_password.jsp").forward(request, response);
			return "forgot_password";
		}
		
		//check email if exist
		boolean flag = new com.zzti.business.ContactBusiness().emailExist(form.getEmail());
		if(!flag)
		{
			form.getErrors().put("email", "邮箱不存在!");
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/forgot_password.jsp").forward(request,response);
			return "forgot_password";
		}
		
		String guid = UUID.randomUUID().toString();
		//add the record to database
		PasswordChangeRequest data = new PasswordChangeRequest(guid,form.getEmail());
		Result result= new com.zzti.business.PasswordChangeRequestBusiness().add(data);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		//send an email
		String content =String.format("<html><body><p><strong>亲爱的用户：</strong></p><br/>"
				+ "<p>&nbsp;&nbsp;&nbsp;&nbsp;您好!,感谢您使用通讯录服务，您正在进行重置密码，若非本人操作请忽略此邮件...</p>"
				+ "<p>请点击此链接进行密码重置:"
				+ "	<a href='%1$s://%2$s:%3$s%4$s/password/reset?guid=%5$s'>%1$s://%2$s:%3$s%4$s/password/reset?guid=%5$s</a>"
				+ "	<span style='margin:0px;padding:0px;margin-left:10px;line-height:30px;font-size:14px;color:#979797;'>(为了保障您帐号的安全性，请在1小时内完成验证.)</span>"
				+ "</p></body></html>",request.getScheme(),request.getServerName(),request.getServerPort(),request.getContextPath(),guid);
		//System.out.println(content);
		new MailUtils().SendEmail(data.getEmail(), "通讯录--密码重置", content);
		
		//success 
		model.addAttribute("message", "邮件发送成功，请查收邮件...");
		//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		return "message";
	}
	
	
	@RequestMapping(value = "reset", method = RequestMethod.GET)
	public String resetPassword(@RequestParam String guid ,ModelMap model) {
		//String guid = request.getParameter("guid");
		if(guid==null || guid.trim().equals("")|| guid.trim().length()!=36)
		{			
			model.addAttribute("message", "参数错误!");
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		//get a record from database by id
		TResult<PasswordChangeRequest> result = new com.zzti.business.PasswordChangeRequestBusiness().getModel(guid);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		ObjectMapper mapper = new ObjectMapper();
		PasswordChangeRequest data = mapper.convertValue(result.getT(), PasswordChangeRequest.class);
		
		//compare date 
		Date date = DateUtils.StringToDate(data.getAddTime(), DateStyle.YYYY_MM_DD_HH_MM_SS);
		date = DateUtils.addHour(date, 1);	
		if(date.before(new Date()))//invalid
		{
			model.addAttribute("message", "链接已经失效!");
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		return "reset_password";
		//request.getRequestDispatcher("/WEB-INF/jsp/reset_password.jsp").forward(request, response);
	}
	
	@RequestMapping(value = "reset", method = RequestMethod.POST)
	public String resetPassword(@ModelAttribute ResetPasswordForm form, @RequestParam String guid ,ModelMap model, HttpServletRequest request) {
		//String guid = request.getParameter("guid");
		if(guid==null || guid.trim().equals("")|| guid.trim().length()!=36)
		{			
			model.addAttribute("message", "参数错误!");
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		//get a record from database by id
		TResult<PasswordChangeRequest> result = new com.zzti.business.PasswordChangeRequestBusiness().getModel(guid);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		ObjectMapper mapper = new ObjectMapper();
		PasswordChangeRequest data = mapper.convertValue(result.getT(), PasswordChangeRequest.class);
		
		//compare date 
		Date date = DateUtils.StringToDate(data.getAddTime(), DateStyle.YYYY_MM_DD_HH_MM_SS);
		date = DateUtils.addHour(date, 1);	
		if(date.before(new Date()))//invalid
		{
			model.addAttribute("message", "链接已经失效!");
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		
		boolean flag = form.validate();
		if(!flag)//void
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/reset_password.jsp").forward(request, response);
			return "reset_password";
		}
		
		//update passwordchangerequest status
		Result result1 = new com.zzti.business.PasswordChangeRequestBusiness().update(data);
		if(result.getResult()!=1)
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";
		}
		
		//reset contact password
		Contact contact = new Contact();
		contact.setEmail(data.getEmail());
		contact.setPassword(Common.getMD5(form.getConfirmpassword()));
		result1 = new com.zzti.business.ContactBusiness().resetPwd(contact);
		if(result1.getResult()!=1)
		{
			model.addAttribute("message", result1.getMessage());
		}
		else
		{
			model.addAttribute("message", String.format("重置密码成功,点击<a href='%s/login'>返回</a>登录...",request.getContextPath()));
		}
		//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		return "message";
	}

	@Login
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatePassword(ModelMap model)
	{
		return "password_update";		
	}

	@Login
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePasswrod(@ModelAttribute com.zzti.web.formbean.PasswordForm form ,ModelMap model, HttpServletRequest request)
	{
		boolean flag = form.validate();
		if(!flag)//void
		{
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
			return "password_update";
		}
		
		//get user id ,and get user info form database		
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Contact data = mapper.convertValue(obj, Contact.class);
		
		//oldpasswrod not match user password
		if(!Common.getMD5(form.getOldpassword()).equals(data.getPassword()))
		{
			form.getErrors().put("oldpassword", "旧密码输入错误!");
			model.addAttribute("form", form);
			//request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
			return "password_update";
		}
		
		data.setPassword(Common.getMD5(form.getConfirmpassword()));
		Result result = new com.zzti.business.ContactBusiness().updatePwd(data);
		if(result.getResult()!=1)//update error
		{
			model.addAttribute("message", result.getMessage());
			//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return "message";			
		}
		//password update success
		//response.sendRedirect(request.getContextPath()+"/servlet/IndexUIServlet");
		return "redirect:/gallery/list";
	}
}
