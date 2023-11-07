package com.servlet.interServletCommunication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/additionServlet")
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
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		int additionResult = num1 + num2;
		request.setAttribute("additionResult", additionResult);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/squareServlet");
		requestDispatcher.include(request, response);
		int squareResult = (int) request.getAttribute("squareResult");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("The addition of two numbers is: " + additionResult);

		if (squareResult > 0) {
			out.println(" and the square of two numbers is: " + squareResult);
		} else {
			out.println(" (Square result is not available)");
		}
		out.println("</html>");
		out.println("</body>");
	}

}
