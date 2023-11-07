package com.servlet.interServletCommunication;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SquareServlet
 */
@WebServlet("/squareServlet")
public class SquareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Invoking doPost method in SquareServlet");
		int additionResult = (int) request.getAttribute("additionResult");
		int squareResult = additionResult * additionResult;
		System.out.println("Square Calculated successfully!!");
		request.setAttribute("squareResult", squareResult);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/additionServlet");
		requestDispatcher.forward(request, response);
	}

}
