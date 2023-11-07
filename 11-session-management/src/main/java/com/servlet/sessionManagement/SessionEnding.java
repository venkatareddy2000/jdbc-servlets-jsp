package com.servlet.sessionManagement;

public class SessionEnding {
	/*
	 * When you are done with a user's session data, you have several options −
	 * 
	 * Remove a particular attribute − You can call public void
	 * removeAttribute(String name) method to delete the value associated with a
	 * particular key.
	 * 
	 * Delete the whole session − You can call public void invalidate() method to
	 * discard an entire session.
	 * 
	 * Setting Session timeout − You can call public void setMaxInactiveInterval(int
	 * interval) method to set the timeout for a session individually.
	 * 
	 * Log the user out − The servers that support servlets 2.4, you can call logout
	 * to log the client out of the Web server and invalidate all sessions belonging
	 * to all the users.
	 * 
	 * web.xml Configuration − If you are using Tomcat, apart from the above
	 * mentioned methods, you can configure session time out in web.xml file as
	 * follows.
	 * 
	 * <session-config> <session-timeout>15</session-timeout> </session-config> The
	 * timeout is expressed as minutes, and overrides the default timeout which is
	 * 30 minutes in Tomcat.
	 * 
	 * The getMaxInactiveInterval( ) method in a servlet returns the timeout period
	 * for that session in seconds. So if your session is configured in web.xml for
	 * 15 minutes, getMaxInactiveInterval( ) returns 900.
	 */

}
