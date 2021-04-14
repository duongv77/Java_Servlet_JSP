package com.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FavoriteDAO;
import com.dao.VideoDAO;
import com.entity.Favorite;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;

/**
 * Servlet implementation class LikeBaiViet
 */
@WebServlet("/likevideo")
public class LikeBaiViet extends BaseLayOut {
	private FavoriteDAO fvDAO;
	private VideoDAO videoDAO;
    public LikeBaiViet() {
        super();
        this.fvDAO = new FavoriteDAO();
        this.videoDAO = new VideoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video video = this.videoDAO.findByID(id);
		Favorite entity = new Favorite();
		User user =(User) request.getSession().getAttribute("user");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		try {
			entity.setUser(user);
			entity.setVideo(video);
			entity.setLikedate(date+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fvDAO.store(entity);
		response.sendRedirect(request.getContextPath() + "/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
