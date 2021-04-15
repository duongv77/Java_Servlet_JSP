package com.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.entity.Video;

/**
 * Servlet implementation class XoaBaiViet
 */
@WebServlet("/chitietbaiviet/xoabaiviet")
public class XoaBaiViet extends HttpServlet {
	private VideoDAO videoDAO;
    public XoaBaiViet() {
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
		
		response.sendRedirect(request.getContextPath() + "/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
