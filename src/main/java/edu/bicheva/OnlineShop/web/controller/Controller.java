package edu.bicheva.OnlineShop.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 6760786041186324131L;
	
	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccess(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccess(request,response);
	}

	private void proccess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LOG.debug("Execute main controller");
		
		String url = request.getRequestURI();
		
		LOG.info("URL {}", url);
		 
		if(url.endsWith("catalog")){
			String path = "/WEB-INF/jsp/catalog.jsp";
			LOG.debug("Forward to path {}", path);
			request.getRequestDispatcher(path).forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath().concat("/"));
		}
	}
}
