package com.zzti.web.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.bean.PasswordChangeRequest;
import com.zzti.bean.Result;
import com.zzti.utils.MailUtils;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ForgotPasswordForm;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ForgotPasswordForm form = WebUtils.requestToBean(request, ForgotPasswordForm.class);
		if(!form.validate())
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/forgot_password.jsp").forward(request, response);
			return;
		}
		
		//check email if exist
		boolean flag = new com.zzti.business.ContactBusiness().emailExist(form.getEmail());
		if(!flag)
		{
			form.getErrors().put("email", "邮箱不存在!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/forgot_password.jsp").forward(request,response);
			return;
		}
		
		String guid = UUID.randomUUID().toString();
		//add the record to database
		PasswordChangeRequest data = new PasswordChangeRequest(guid,form.getEmail());
		Result result= new com.zzti.business.PasswordChangeRequestBusiness().add(data);
		if(result.getResult()!=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/message_noheader.jsp").forward(request, response);
			return;
		}
		//send an email
		String content =String.format("<html><body><p><strong>亲爱的用户：</strong></p><br/>"
				+ "<p>&nbsp;&nbsp;&nbsp;&nbsp;您好!,感谢您使用通讯录服务，您正在进行重置密码，若非本人操作请忽略此邮件...</p>"
				+ "<p>请点击此链接进行密码重置:"
				+ "	<a href='%1$s://%2$s:%3$s%4$s/servlet/ResetPasswordUIServlet?guid=%5$s'>%1$s://%2$s:%3$s%4$s/servlet/ResetPasswordUIServlet?guid=%5$s</a>"
				+ "	<span style='margin:0px;padding:0px;margin-left:10px;line-height:30px;font-size:14px;color:#979797;'>(为了保障您帐号的安全性，请在1小时内完成验证.)</span>"
				+ "</p></body></html>",request.getScheme(),request.getServerName(),request.getServerPort(),request.getContextPath(),guid);
		//System.out.println(content);
		new MailUtils().SendEmail(data.getEmail(), "通讯录--密码重置", content);
		
		//success 
		request.setAttribute("message", "邮件发送成功，请查收邮件...");
		request.getRequestDispatcher("/WEB-INF/jsp/message_noheader.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
