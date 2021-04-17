package com.auth;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuiMail
 */
@WebServlet("/GuiMail")
public class GuiMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuiMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void guiMail(String nguoiNhan,String noiDung) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			String username = "dd22042001@gmail.com";
			String password = "22042001d";
			return new PasswordAuthentication(username, password);
		}
		});
		MimeMessage message = new MimeMessage(session);
		
		try {
			
			message.setFrom(new InternetAddress("dd22042001@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, nguoiNhan);
			message.setSubject("Dưỡng Đẹp Trai", "utf-8");
			message.setText( noiDung, "utf-8","html");
			message.setReplyTo(message.getFrom()); 
			Transport.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
	}

}
