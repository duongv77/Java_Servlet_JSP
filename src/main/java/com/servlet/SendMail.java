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

import com.dao.ShareDAO;
import com.dao.VideoDAO;
import com.entity.Share;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/sendmail")
public class SendMail extends BaseLayOut {
	private VideoDAO videoDAO; 
	private ShareDAO shareDAO;
	int idVideo;
    public SendMail() {
        super();
        this.videoDAO = new VideoDAO(); 
        this.shareDAO = new ShareDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =(User) request.getAttribute("user");
		String id = request.getParameter("id");
		idVideo = Integer.parseInt(id);
		Video video = this.videoDAO.findByID(idVideo);
		request.setAttribute("video", video);
		System.out.println("ở doget" + id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/sharebaiviet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			String username = "duongdeptrai.0hutthuoc@gmail.com";
			String password = "22042001d";
			return new PasswordAuthentication(username, password);
		}
		});
		String nguoiNhan = request.getParameter("nguoinhan");
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			
			message.setFrom(new InternetAddress("duongdeptrai.0hutthuoc@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, nguoiNhan);
			message.setSubject("Dưỡng Đẹp Trai", "utf-8");
			message.setText( "Dưỡng Đẹp Trai code không bug", "utf-8","html");
			message.setReplyTo(message.getFrom()); 
			Transport.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
	
		User user = (User) request.getSession().getAttribute("user");
		
		Video video = this.videoDAO.findByID(idVideo);
		System.out.println("user" + user.getId());
		System.out.println("video" + video.getId());
		Share entity = new Share();
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		
		try {
			entity.setSharedate(date+"");
			entity.setUser(user);
			entity.setVideo(video);
			entity.setEmail(nguoiNhan);
			
			System.out.println("email"+entity.getEmail());
			System.out.println("date"+entity.getSharedate());
			System.out.println("user id"+entity.getUser().getId());
			System.out.println("id video"+entity.getVideo().getId());
			this.shareDAO.store(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/home");
	}
	

}
