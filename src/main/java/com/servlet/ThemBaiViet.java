package com.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;
@MultipartConfig
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		Video entity = new Video();
		
		try {
			Part part = request.getPart("anh");
			
			String realPath = request.getServletContext().getRealPath("/imgs");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
			}
			
			part.write(realPath+"/"+fileName);
			
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setPoster(fileName);
			entity.setActive(1);
			entity.setViews(0);
		} catch (Exception e) {
			request.setAttribute("checkForm", 1);
			request.getRequestDispatcher("/views/thembaiviet.jsp").forward(request, response);
			return;
		}
		this.videoDAO.store(entity);
		response.sendRedirect(request.getContextPath()+"/thembaiviet");
	}

}
