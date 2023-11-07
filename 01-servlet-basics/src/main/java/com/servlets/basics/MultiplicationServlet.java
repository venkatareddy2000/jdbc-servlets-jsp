package com.servlets.basics;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("serial")
public class MultiplicationServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		Integer number1 = Integer.parseInt(request.getParameter("number1"));
		Integer number2 = Integer.parseInt(request.getParameter("number2"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>The multiplication of the given two numbers is : </h1>" + (number1 * number2));
		out.print("</body>");
		out.print("</html>");

	}

}
