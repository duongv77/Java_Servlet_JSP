package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class AdminBaiVietDelete
 */
@WebServlet("/admin/baiviet/delete")
public class AdminBaiVietDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoDAO videoDAO;
    public AdminBaiVietDelete() {
        super();
        this.videoDAO = new VideoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSTR = request.getParameter("id");
		if(idSTR==null) {
			//400 bad req
		}
		int id = Integer.parseInt(idSTR);
		Video entity = new Video();
		entity.setId(id);
		this.videoDAO.delete(entity);
		
		User user =(User) request.getSession().getAttribute("user");
		request.setAttribute("deleteOke", 1);
		request.setAttribute("listVideo", this.videoDAO.fullVideo());
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/admin/adminbaiviet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
