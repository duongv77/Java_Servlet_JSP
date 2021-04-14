package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;

@WebServlet("/thembaiviet")
public class ThemBaiViet extends BaseLayOut {
	private VideoDAO videoDAO;
    public ThemBaiViet() {
        super();
        this.videoDAO = new VideoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/thembaiviet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video entity = new Video();
		String anh = request.getParameter("anh");
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setPoster("./anh/"+anh);
			entity.setActive(1);
			entity.setViews(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.videoDAO.store(entity);
		response.sendRedirect(request.getContextPath()+"/thembaiviet");
	}

}
