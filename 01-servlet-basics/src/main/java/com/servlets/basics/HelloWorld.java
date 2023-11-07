package com.servlets.basics;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("serial")
/*
 * Instead of creating an url in the web.xml file, we can directly create
 * using @webservlet annotation in the servlet page itself and if we do so the
 * deployment instructor will be overriden with this @webservlet annotation
 */
/* We need to extend GenericServlet while creating the servlets */
public class HelloWorld extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * Telling the browser what kind of response we are going to send. In this
		 * servlet we are going to send the response in the form of html.
		 */
		response.setContentType("text/html");
		/*
		 * In Java servlets, the getWriter() method is used to obtain a PrintWriter
		 * object that allows you to send character text data as the response to an HTTP
		 * client, typically a web browser. This method is part of the ServletResponse
		 * interface, and servlets use it to write textual content directly to the
		 * response stream.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Venkata Reddy</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
