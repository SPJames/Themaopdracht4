package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.voorraadbeheer.Brandstof;

public class BrandstofToevoegenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[3];
		
		userinfo[0] = req.getParameter("type");
		userinfo[1] = req.getParameter("aantal");
		userinfo[2] = req.getParameter("PrijsLiter");
		Brandstof brandstof = null;
		
		boolean error = false;	//leeg veld
		boolean error2 = false;	//bestaat al
		
		for(int i = 0;  i < 3; i++){
			if(userinfo[i].equals(null) || userinfo[i].equals("")){
				error = true;
			}
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");
		
		RequestDispatcher rd = null;
		for(Brandstof b : brandstoffen){
			if(b.getBrandstofType() == userinfo[0])
			{
				error2 = true;
			}
		}
		
		brandstof = new Brandstof(userinfo[0], Integer.parseInt(userinfo[1]), Double.parseDouble(userinfo[2]));
		if(error){
			req.setAttribute("msgs", "één of meerdere velden waren leeg");
			rd = req.getRequestDispatcher("brandstoftoevoegen.jsp");
		}
		if(error2){
			req.setAttribute("msgs", "Dit brandstoftype bestaat al, ga naar brandstof wijzigen om dit type aan te passen");
			rd = req.getRequestDispatcher("brandstoftoevoegen.jsp");
		}
		if(!error && !error2){
			brandstoffen.add(brandstof);
			req.setAttribute("msgs", "Brandstof succesvol toegevoegd!");
			rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
		}
		rd.forward(req,resp);
	}
}