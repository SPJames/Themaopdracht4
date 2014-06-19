package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.voorraadbeheer.Onderdeel;

public class OnderdeelToevoegenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[3];
		
		userinfo[0] = req.getParameter("artikelnaam");
		userinfo[1] = req.getParameter("aantal");
		userinfo[2] = req.getParameter("PrijsArtikel");
		Onderdeel onderdeel = null;
		
		boolean error = false;	//leeg veld
		boolean error2 = false;	//bestaat al
		
		for(int i = 0;  i < 3; i++){
			if(userinfo[i].equals(null) || userinfo[i].equals("")){
				error = true;
			}
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) sc.getAttribute("alleOnderdelen");
		
		RequestDispatcher rd = null;
		for(Onderdeel o : onderdelen){
			if(o.getNaam() == userinfo[0])
			{
				error2 = true;
			}
		}
		
		onderdeel = new Onderdeel(Integer.parseInt(userinfo[1]), userinfo[0], Double.parseDouble(userinfo[2]));
		if(error){
			req.setAttribute("error", "één of meerdere velden waren leeg");
			rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
		}
		if(error2){
			req.setAttribute("error", "Dit onderdeel bestaat al, ga naar onderdeel wijzigen om dit onderdeel aan te passen");
			rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
		}
		if(!error && !error2){
			onderdelen.add(onderdeel);
			req.setAttribute("msgs", "Onderdeel succesvol toegevoegd!");
			rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
		}
		rd.forward(req,resp);
	}
}