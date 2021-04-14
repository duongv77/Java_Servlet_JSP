package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;
import com.utils.HibenateUtil;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends BaseLayOut {
	private VideoDAO videoDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        
        this.videoDAO = new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =(User) request.getSession().getAttribute("user");
		String pageSTR = request.getParameter("page");
		int page = pageSTR == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int first = page == 1 ? 0 : (page-1)*6;
		
		request.setAttribute("page", page);
		TypedQuery<Video> query = HibenateUtil.getSession().createNamedQuery("OderVideoDESC", Video.class);
		query.setFirstResult(first);
		query.setMaxResults(6);
		List<Video> listVideo = query.getResultList();
		request.setAttribute("user", user);
		request.setAttribute("ListVideo", listVideo);
		String views = "/views/home.jsp";
		render(request, response, views);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
