package com.servlet;

import java.io.IOException;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.auth.GuiMail;
import com.dao.UserDAO;
import com.utils.HibenateUtil;

/**
 * Servlet implementation class KhoiPhucUser
 */
@WebServlet("/khoiphucuser")
public class KhoiPhucUser extends GuiMail {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    public KhoiPhucUser() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/khoiphucmatkhau.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		if(email=="") {
			int check = 1;
			request.setAttribute("check", check);
			request.getRequestDispatcher("/views/khoiphucmatkhau.jsp").forward(request, response);
			return;
		}
		if(this.userDAO.setMK(email)==1) {
			request.setAttribute("resetMK", 1);
		}
		String noiDung = "Mật khẩu mới của bạn là : 1234.";
		this.guiMail(email, noiDung);
		
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}
	
	public void guiMailMK(String email) {
		
	}
	
}
