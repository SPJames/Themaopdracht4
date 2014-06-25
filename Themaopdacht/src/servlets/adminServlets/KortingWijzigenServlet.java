package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.financien.Factuur;

public class KortingWijzigenServlet extends HttpServlet{
	
	/**
	 * In deze servlet wordt korting aan een factuur toegevoegd
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Het id  van de factuur waar in gewerkt wordt is doorgegeven.
	 * Het factuur met dat id wordt opgezocht en daar wordt de korting neergezet.
	 * De factuur klasse berekent automatisch de nieuwe totaalprijs.
	 * De gebruiker wordt teruggestuurt naar de factuur waarin gewerkt werd.
	 * Deze factuur is meteen aangepast
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int korting = Integer.parseInt(req.getParameter("korting"));
		int factId = Integer.parseInt(req.getParameter("id"));
		RequestDispatcher rd = null;
		@SuppressWarnings("unchecked")
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) req.getServletContext().getAttribute("alleFacturen");
		
		//factuur opzoeken
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == factId){
				f.setKorting(korting);
				req.setAttribute("id", f.getFactuurNummer());
			}
		}
		rd = req.getRequestDispatcher("factuurberekenen.jsp"); //terug naar de factuur
		rd.forward(req, resp);
	}
}