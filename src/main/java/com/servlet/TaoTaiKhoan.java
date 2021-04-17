package com.servlet;

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

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/taotaikhoan")
public class TaoTaiKhoan extends HttpServlet {
	private UserDAO userDAO;
    public TaoTaiKhoan() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/taotaikhoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		if(email=="" || password=="" || fullname=="") {
			int check = 1;
			request.setAttribute("check", check);
			request.getRequestDispatcher("/views/taotaikhoan.jsp").forward(request, response);
			return;
		}
		
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setAdmin(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.userDAO.store(entity);
		
		// Gửi mail chào mừng
		
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
			message.setRecipients(Message.RecipientType.TO, email);
			message.setSubject("Dưỡng Đẹp Trai", "utf-8");
			message.setText( "Bạn đã đăng kí tài khoản thành công.Chào mừng bạn đến với Dưỡng Đẹp Trai code không bug", "utf-8","html");
			message.setReplyTo(message.getFrom()); 
			Transport.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
		int check = 1;
		request.setAttribute("check", check);
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}

}
