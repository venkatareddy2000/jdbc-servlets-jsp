package com.servlet.sessionManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * The tomcat will automatically create cookies and retrieving those cookies
		 * here
		 */
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}
		/* Adding a cookie manually */
		//response.addCookie(new Cookie("venky", "123"));

		String userName = request.getParameter("userName");
		/* creating a session object */
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='targetServlet'>Click on the link to check the user name</a>");
	}
	/*
	 * The entire time from a login into the application to logout from the
	 * application is called session.
	 * 
	 * Session tracking is a mechanism used in web development to maintain the state
	 * or context of a user's interactions with a web application across multiple
	 * HTTP requests and responses. In other words, it allows the web server to
	 * remember and recognize a specific user as they navigate through different
	 * pages or perform actions within the web application. Session tracking is
	 * essential for building stateful web applications, where user-specific
	 * information needs to be preserved during their visit.
	 */

}
