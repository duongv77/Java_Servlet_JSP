package com.servlet;

import java.io.IOException;
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		if(email=="" || password=="" || fullname=="") {
			int check = 1;
			request.setAttribute("check", check);
			request.getRequestDispatcher("/views/taotaikhoan.jsp").forward(request, response);
		}
		
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setAdmin(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.userDAO.store(entity);
		
		int check = 1;
		request.setAttribute("check", check);
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}

}
