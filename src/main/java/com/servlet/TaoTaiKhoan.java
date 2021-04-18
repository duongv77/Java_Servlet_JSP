package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.auth.GuiMail;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/taotaikhoan")
public class TaoTaiKhoan extends GuiMail {
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
			int checkNull = 1;
			request.setAttribute("checkNull", checkNull);
			request.getRequestDispatcher("/views/taotaikhoan.jsp").forward(request, response);
			return;
		}
		if(this.userDAO.kiemTraUser(email)!=null) {
			request.setAttribute("checkAcount", 1);
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
		
		String noiDung = "Bạn đã đăng kí tài khoản thành công với "
						+"Username: "+email+ " Password: "+password
						+" Chào mừng bạn đến với Dưỡng Đẹp Trai code không bug";
		this.guiMail(email, noiDung);
		
		int checkCreateUserSuccess = 1;
		request.setAttribute("checkCreateUserSuccess", checkCreateUserSuccess);
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}

}
