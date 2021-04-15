package com.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FavoriteDAO;
import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class DissLikeBaiViet
 */
@WebServlet("/disslikebaiviet")
public class DissLikeBaiViet extends HttpServlet {
	private FavoriteDAO favoriteDAO;
	private VideoDAO videoDAO;
    public DissLikeBaiViet() {
        super();
        this.favoriteDAO = new FavoriteDAO();
        this.videoDAO = new VideoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSTR = request.getParameter("id");
		
		User user=(User)request.getSession().getAttribute("user");
		
		if(idSTR==null) {
			//400 bad req
		}
		int idBV = Integer.parseInt(idSTR);
//		Video video = videoDAO.findByID(idBV);
//		System.out.println(video.getTitle());
		this.favoriteDAO.delete(user.getId(), idBV);
		response.sendRedirect(request.getContextPath()+"/yeuthich");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
