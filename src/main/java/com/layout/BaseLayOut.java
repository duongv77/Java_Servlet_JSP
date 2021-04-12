package com.layout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseLayOut
 */
@WebServlet("/baselayout")
public class BaseLayOut extends HttpServlet {
    public BaseLayOut() {
        super();
    }

	protected void render(HttpServletRequest request,HttpServletResponse response,String views) throws ServletException, IOException {
		request.setAttribute("views", views);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
}
