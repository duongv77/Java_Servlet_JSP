package com.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class AdminUserUpdate
 */
@MultipartConfig
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		
		
		User entity = new User();
		int id =Integer.parseInt(request.getParameter("id"));
		User entityPre = this.userDAO.findByID(id);
		
		try {
			if(request.getPart("avatar").getSubmittedFileName()=="") {
				System.out.println("if");
				entity.setAvatar(entityPre.getAvatar());
			}else {
				System.out.println("else");
				
				Part part = request.getPart("avatar");
				
				String realPath = request.getServletContext().getRealPath("/imgs");
				String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
				
				if(!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				
				part.write(realPath+"/"+fileName);
				entity.setAvatar(fileName);
			}
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setEmail(entityPre.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.userDAO.update(entity);
		
		response.sendRedirect(request.getContextPath()+"/admin/user");
	}

}
