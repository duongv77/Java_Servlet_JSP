package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;
import com.role.RoleConst;

/**
 * Servlet implementation class XemCT
 */
@WebServlet("/chitietbaiviet")
public class ChiTietBaiViet extends BaseLayOut {
	private VideoDAO videoDAO;
    public ChiTietBaiViet() {
        super();
        
        this.videoDAO = new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video entity = this.videoDAO.findByID(id);
		entity.setViews(entity.getViews()+1); //tăng views
		this.videoDAO.update(entity);
		User user =(User) request.getSession().getAttribute("user");
		request.setAttribute("video", entity);
		request.setAttribute("user", user);
		request.setAttribute("ADMIN", RoleConst.ROLE_ADMIN);
		String views = "/views/chitietbaiviet.jsp";
		render(request, response, views);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
