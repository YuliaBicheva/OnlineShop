package edu.bicheva.OnlineShop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxController extends HttpServlet {

	private static final long serialVersionUID = -7118519606834049024L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccess(request, response);
	}


	private void proccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		int num1 = Integer.valueOf(request.getParameter("number1"));
		int num2 = Integer.valueOf(request.getParameter("number2"));
		
		PrintWriter out = response.getWriter();
		int result = num1 + num2;
		out.println(result);
	}
}
