package com.servlet.initParameters;
/*
 * <!-- Init params are name value pairs that are passed to a servlet through
 * the web.xml file or through the annotations.
 * 
 * We create these init params inside a servlet element and can create n number
 * of init params.
 * 
 * When we create the init params in the servlet element the server container
 * will pass these init params to the ServletConfig interface during the
 * initialization of the servlet and we need to retrieve these init params
 * values using the init name by creating an object for the ServletConfig
 * interface.
 * 
 * To retrieve the init param value we need to call the getInitParameter method
 * using the ServletConfig object and need to pass the Init param name to the
 * method -->
 */