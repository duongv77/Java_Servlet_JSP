package com.admin;

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
import com.entity.Video;

/**
 * Servlet implementation class AdminBaiVietUpdate
 */
@MultipartConfig
@WebServlet("/admin/baiviet/update")
public class AdminBaiVietUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
    public AdminBaiVietUpdate() {
        super();
        this.videoDAO = new VideoDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSTR = request.getParameter("id");
		if(idSTR==null) {
			//400 bad req
		}
		int id = Integer.parseInt(idSTR);
		Video video = this.videoDAO.findByID(id);
		request.setAttribute("entityVideo", video);
		request.getRequestDispatcher("/views/admin/adminbaivietupdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Video entity = new Video();
		int id = Integer.parseInt(request.getParameter("id"));
		Video entityPre = this.videoDAO.findByID(id);
		
		
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			System.out.println(entity.getActive());
			if(request.getPart("poster").getSubmittedFileName()=="") {
				entity.setPoster(entityPre.getPoster());
			}else {
				Part part = request.getPart("poster");
				
				String realPath = request.getServletContext().getRealPath("/imgs");
				String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
				
				if(!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				
				part.write(realPath+"/"+fileName);
				entity.setPoster(fileName);
			}
			
			entity.setViews(entityPre.getViews());
			entity.setId(entityPre.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.videoDAO.update(entity);
		
		response.sendRedirect(request.getContextPath() + "/admin/baiviet");
	}

}
