package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class AdminUser
 */
@WebServlet("/admin/user")
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    public AdminUser() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =(User) request.getSession().getAttribute("user");
		System.out.println(userDAO.fullUser());
		request.setAttribute("listUser", userDAO.fullUser());
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/admin/adminuser.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
