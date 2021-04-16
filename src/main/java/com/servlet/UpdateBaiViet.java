package com.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.VideoDAO;
import com.entity.User;
import com.entity.Video;
import com.layout.BaseLayOut;
import com.role.RoleConst;

@MultipartConfig
@WebServlet("/updatebaiviet")
public class UpdateBaiViet extends BaseLayOut {
	private VideoDAO videoDAO;
	
    public UpdateBaiViet() {
        super();
        this.videoDAO =  new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		int id = Integer.parseInt(request.getParameter("id"));
		Video entity = this.videoDAO.findByID(id);
		request.setAttribute("video", entity);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/capnhapbaiviet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Video entity = new Video();
		int id = Integer.parseInt(request.getParameter("id"));
		Video entityPre = this.videoDAO.findByID(id);
		
		
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			if(request.getParameter("anh")=="") {
				entity.setPoster(entityPre.getPoster());
			}else {
				Part part = request.getPart("anh");
				
				String realPath = request.getServletContext().getRealPath("/imgs");
				String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
				
				if(!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				
				part.write(realPath+"/"+fileName);
				entity.setPoster(fileName);
			}
			
			entity.setViews(entityPre.getViews());
			entity.setActive(entityPre.getActive());
			entity.setId(entityPre.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.videoDAO.update(entity);
		User user =(User) request.getSession().getAttribute("user");
		request.setAttribute("updateTC", 1);
		request.setAttribute("video", entity);
		request.setAttribute("user", user);
		request.setAttribute("ADMIN", RoleConst.ROLE_ADMIN);
		String views = "/views/chitietbaiviet.jsp";
		render(request, response, views);
	}

}
