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
 * Servlet implementation class AdminUserDelete
 */
@WebServlet("/admin/user/delete")
public class AdminUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    public AdminUserDelete() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSTR =  request.getParameter("id");
		if(idSTR==null) {
			//400 bad req
		}
		int id = Integer.parseInt(idSTR);
		User entity = new User();
		entity.setId(id);
		this.userDAO.delete(entity);
		
		request.setAttribute("deleteOke", 1);
		User user =(User) request.getSession().getAttribute("user");
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
