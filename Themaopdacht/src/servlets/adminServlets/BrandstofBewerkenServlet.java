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

public class BrandstofBewerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[4];
			
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");
		
		userinfo[0] = req.getParameter("artikelid");
		userinfo[1] = req.getParameter("type");
		userinfo[2] = req.getParameter("aantal");
		userinfo[3] = req.getParameter("PrijsLiter");
		int aantal = Integer.parseInt(userinfo[2]);
		System.out.println(aantal);
		Brandstof brandstof = null;
		RequestDispatcher rd = null;
			
		for(Brandstof b : brandstoffen){
			if(b.getTsic() == Integer.parseInt(userinfo[0]))
			{
				brandstof = b;
			}
		}
			
		for (int i = 0; i < 4; i++) {
			// foutmelding
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("msgs", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("brandstofbewerken.jsp");
				break;
			} else {
				if (i == 2) {
					brandstof.setLiter(aantal);
				} else if (i==3) {
					brandstof.setPrijsPerLiter(Double.parseDouble(userinfo[3]));
					req.setAttribute("msgs", "Brandstof succesvol aangepast!");
					rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
				}
			}
		}
		rd.forward(req,resp);
	}
}