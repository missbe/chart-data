package cn.missbe.service.impl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jListener  implements ServletContextListener {

	 public static final String log4jDir = "log";
	 public void contextDestroyed(ServletContextEvent servletcontextevent) {
	      System.getProperties().remove(log4jDir);
	 }

	 public void contextInitialized(ServletContextEvent servletcontextevent) {
	  String log4jdir = servletcontextevent.getServletContext().getRealPath("/");
	  System.out.println("log4:"+log4jdir);
	  System.setProperty(log4jDir, log4jdir);
	 }
}
