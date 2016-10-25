package edu.bicheva.OnlineShop.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.bicheva.OnlineShop.model.*;
import edu.bicheva.OnlineShop.web.JsonResponse;

public class TestAjax extends HttpServlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestAjax.class);

	private static final long serialVersionUID = 6760786041186324131L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		LOG.debug("Main method execution started");
		
		String action = req.getParameter("action");
		LOG.debug("Define action: action --> {}", action);

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		GoodsModel goodsModel = new GoodsModel();
		PrintWriter out = resp.getWriter();
		
		JsonResponse jsonResponse = new JsonResponse();
		
		if(action.equalsIgnoreCase("find")){
			out.print(gson.toJson(goodsModel.find()));
			out.flush();
			out.close();
		}else if(action.equalsIgnoreCase("findAll")){
			out.print(gson.toJson(goodsModel.findAll()));
			out.flush();
			out.close();
		}else if(action.equalsIgnoreCase("login")){
				String login = getParameter(req, "login");
				String pass = getParameter(req, "password");
				if(login == null || login.isEmpty()){
					jsonResponse.setStatus("ERROR");
					jsonResponse.setResult("ERROR message --> login");
					LOG.debug("Define an error with login");
				}else if(pass == null || pass.isEmpty()){
					jsonResponse.setStatus("ERROR");
					jsonResponse.setResult("ERROR message --> password");
					LOG.debug("Define an error with password");
				}else{
					jsonResponse.setStatus("SUCCESS");
					jsonResponse.setResult("You have logged successful!");
					LOG.debug("User loged with login {} and password {}", login, pass);
				}
				
				out.print(gson.toJson(jsonResponse));
				out.flush();
				out.close();
				
		}
		
		LOG.debug("Main method execution finished");
	}

	private String getParameter(HttpServletRequest request, String paramName) {
		String param = request.getParameter(paramName);
		return param;
	}
}
