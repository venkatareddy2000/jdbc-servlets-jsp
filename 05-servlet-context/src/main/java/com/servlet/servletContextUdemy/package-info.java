package com.servlet.servletContextUdemy;
/*
 * The ServletContext is a fundamental interface in the Java Servlet API. It
 * represents a communication link between the servlet container (such as Tomcat
 * or Jetty) and the servlets running within it. Servlets are Java classes that
 * handle HTTP requests and generate HTTP responses, and they typically run
 * within a servlet container.
 * 
 * The ServletContext provides a way for servlets to:
 * 
 * Share information: Servlets can use the ServletContext to share data and
 * resources with each other. For example, one servlet can store data in the
 * ServletContext, and other servlets can retrieve that data.
 * 
 * Access configuration parameters: Servlets can access configuration parameters
 * defined in the web application's deployment descriptor (web.xml) through the
 * ServletContext. This allows for the external configuration of servlet
 * behavior.
 * 
 * Perform logging: Servlets can use the ServletContext to log information,
 * warnings, and errors.
 * 
 * Interact with the container: Servlets can use the ServletContext to interact
 * with the servlet container itself. For example, they can obtain information
 * about the container's version or the names of servlets declared in the
 * application.
 * 
 * context params are name value pairs similar to the InitParams, but the only
 * difference is that the init params are available only to a particular servlet
 * as we are configuring at the servlet level, where as the context params can
 * be accessed by servlet present in the application as we are configuring the
 * context params at application level
 * 
 * 
 */