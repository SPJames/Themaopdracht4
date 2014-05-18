package Klus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Klus;

public class KlusAanmakenServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String[] userinfo = new String[5];
		boolean error = false;
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) req.getServletContext()
				.getAttribute("allKlussen");
		
		userinfo[0] = req.getParameter("klantid");//userid voor foreign key
		userinfo[1] = req.getParameter("name");//username voor foreign key
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
			rd = req.getRequestDispatcher("afspraakmaken.jsp");
		}else{
			Klus k = new Klus(userinfo[2],userinfo[4], userinfo[3]);
			k.schrijfWeg(userinfo);
			Klussen.add(k);
			rd = req.getRequestDispatcher("index.jsp");
			
		}
		rd.forward(req,resp);
	}
	
}
