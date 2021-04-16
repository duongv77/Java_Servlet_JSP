package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class AdminUserUpdate
 */
@WebServlet("/admin/user/update")
public class AdminUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    public AdminUserUpdate() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		
		User entityUser = this.userDAO.findByID(id);
		request.setAttribute("entityUser", entityUser);
		request.getRequestDispatcher("/views/admin/adminuserupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
