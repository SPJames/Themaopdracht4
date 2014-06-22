package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.financien.Factuur;

public class KortingWijzigen extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int korting = Integer.parseInt(req.getParameter("korting"));
		int factId = Integer.parseInt(req.getParameter("id"));
		RequestDispatcher rd = null;
		@SuppressWarnings("unchecked")
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) req
				.getServletContext().getAttribute("alleFacturen");
		
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == factId){
				f.setKorting(korting);
			}
		}
		rd = req.getRequestDispatcher("factuur.jsp");
		rd.forward(req, resp);
	}

}
