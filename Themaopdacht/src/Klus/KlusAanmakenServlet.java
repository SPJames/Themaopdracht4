package Klus;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KlusAanmakenServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static int id = 1;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String[] userinfo = new String[5];
		boolean error = false;
		
		userinfo[0] = req.getParameter("klantid");
		userinfo[1] = req.getParameter("name");
		userinfo[2] = req.getParameter("title");
		userinfo[3] = req.getParameter("diensttype");
		userinfo[4] = req.getParameter("comments");
		
		for(int i = 0; i<4; i++){
			if(userinfo[i].equals("") || userinfo[i].equals(null)){
				error = true;
			}
		}

		RequestDispatcher rd = null; 
		if (error){
			req.setAttribute("msgs", "Input was empty");	
			rd = req.getRequestDispatcher("register.jsp");
		}else{
			FileWriter fw = new FileWriter("C:/xampp/tomcat/webapps/AccountSysteem/afspraken.dat", true);
			
			fw.write("\n"+ id++ +":"+ userinfo[0]+";"+userinfo[1]+","+userinfo[2]+"."+userinfo[3]+"|"+userinfo[4]+"/");
			fw.flush();
			fw.close();
			
			rd = req.getRequestDispatcher("index.jsp");
			
		}
		rd.forward(req,resp);
	}
	
}
