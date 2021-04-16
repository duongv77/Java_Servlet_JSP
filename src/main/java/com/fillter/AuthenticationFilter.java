package com.fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {
    public AuthenticationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		try {
			User user =(User) httpRequest.getSession().getAttribute("user");
			if(user.getAdmin() == 1) {
				chain.doFilter(request, response);
			}else {
				HttpServletResponse httpServletResponse =(HttpServletResponse) response;
				httpServletResponse.sendRedirect("/ASSM/home");
				
			}
		} catch (Exception e) {
			HttpServletResponse httpServletResponse =(HttpServletResponse) response;
			httpServletResponse.sendRedirect("/ASSM/home");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
