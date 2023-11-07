package com.servlets.basics;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("serial")
public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * By default the request.getParameter will return a string, so we are parsing
		 * into the long below
		 */
		/*
		 * The string which we are passing in the getParameter method must match with
		 * the name of the field present in the html file
		 */
		Long num1 = Long.parseLong(request.getParameter("number1"));
		Long num2 = Long.parseLong(request.getParameter("number2"));

		PrintWriter out = response.getWriter();
		out.println("The addition of two numbers is : " + (num1 + num2));
	}

}
