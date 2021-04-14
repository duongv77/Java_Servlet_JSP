package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;
import com.utils.HibenateUtil;

@WebServlet("/yeuthich")
public class YeuThich extends BaseLayOut {
    
    public YeuThich() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user"); 
		request.setAttribute("user", user);
		TypedQuery<Video> query = HibenateUtil.getSession().createNamedQuery("VideoLike", Video.class);
		query.setParameter("userID", user.getId());
		List<Video> video = query.getResultList();
		request.setAttribute("ListVideo", video);
		String views = "/views/yeuthich.jsp";
		render(request, response, views);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
