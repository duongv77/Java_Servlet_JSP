package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.entity.User;
import com.layout.BaseLayOut;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dangnhap")
public class DangNhap extends BaseLayOut   {
    private UserDAO userDAO;
    public DangNhap() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User entity = this.userDAO.login(email, password);
		if(entity ==  null) {
			request.setAttribute("error", 1);
			request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user", entity);
			response.sendRedirect(request.getContextPath()+ "/home");
		}
	}

}
