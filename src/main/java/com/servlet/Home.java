package com.servlet;

import java.io.IOException;
import java.util.List;

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
		
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");
		int page = pageStr ==null? 1 : Integer.parseInt(pageStr);
		int limit = limitStr ==null? 5 : Integer.parseInt(pageStr);
		
		int offset = limit*(page-1);
		request.setAttribute("page", page);
		List<Video> ListVideo = this.videoDAO.paginate(offset, limit);
		request.setAttribute("user", user);
		request.setAttribute("ListVideo", ListVideo);
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
