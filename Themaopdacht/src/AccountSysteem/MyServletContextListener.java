package AccountSysteem;

import java.util.ArrayList;

import javax.servlet.*;

import klantenbinding.Klant;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ArrayList<Klant> List = new ArrayList<Klant>();

		//users initaliseren
		
		sce.getServletContext().setAttribute("allUsers", List);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}