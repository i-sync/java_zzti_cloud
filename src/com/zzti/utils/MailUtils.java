package com.zzti.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	private String host;
	private String port;
	private String from;

	public MailUtils() {
		host = Common.EmailHost;
		port = Common.EmailPort;
		from = Common.EmailFrom;
	}

	/**
	 * send email
	 * 
	 * @param to
	 * @param title
	 * @param content
	 */
	public void SendEmail(String to, String title, String content) {
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.put("mail.smtp.auth", false);

		//properties.setProperty("mail.transport.protocol", "smtp");
		//properties.setProperty("mail.smtp.localhost", host); // HELO host
		//properties.setProperty("mail.smtp.allow8bitmime","true");	    
	    
		//properties.setProperty("mail.smtp.socketFactory.port", port);//465
		//properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		//properties.setProperty("mail.smtp.auth", "true");
		//Authenticator auth = new SMTPAuthenticator(from, "51168888");
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		
		try {
			Transport transport = session.getTransport("smtp");
			transport.connect();
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject(title);

			// Now set the actual message
			//message.setText(content);
			// Send the actual HTML message, as big as you like
			message.setContent(content, "text/html;charset=UTF-8");
			
			//message.saveChanges();
			// Send message
			//Transport.send(message);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}

class SMTPAuthenticator extends javax.mail.Authenticator {
	private String strUser;
	private String strPwd;

	public SMTPAuthenticator(String user, String password) {
		this.strUser = user;
		this.strPwd = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(strUser, strPwd);
	}
}
