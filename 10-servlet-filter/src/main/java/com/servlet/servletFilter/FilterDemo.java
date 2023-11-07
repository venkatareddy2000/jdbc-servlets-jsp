package com.servlet.servletFilter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterDemo
 */
/*
 * configuring the Filter using annotation
 * 
 * The uri in the WebFilter annotation has to be same as the uri of the servlet
 * which we want to call for processing. If we give * for the uri in the
 * WebServlet annotation then it will be applicable to all the servlets present
 * in the application
 */
@WebFilter("/filterServlet")
public class FilterDemo extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5862074772570472844L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("pre filtering");
		chain.doFilter(request, response);
		out.println("post processing");
	}

}
