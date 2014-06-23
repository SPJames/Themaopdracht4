package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.financien.Factuur;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

public class VerwijderOnderdeelBrandstof extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		String OofB = req.getParameter("OofB");
		String type = req.getParameter("key");
		@SuppressWarnings("unchecked")
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) req.getServletContext().getAttribute("alleFacturen");
		RequestDispatcher rd = null;
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				if(OofB.equals("O")){
					for(Map.Entry<Onderdeel, Integer> entry: f.getKlus().getGebruikteOnderdelen().entrySet()){
						if(entry.getKey().getNaam().equals(type)){
							f.getKlus().getGebruikteOnderdelen().remove(entry.getKey());
							break;
						}
					}
				}else{
					for(Map.Entry<Brandstof, Double> entry: f.getKlus().getGebruikteBrandstof().entrySet()){
						if(entry.getKey().getBrandstofType().equals(type)){
							f.getKlus().getGebruikteOnderdelen().remove(entry.getKey());
							break;
						}
					}
				}
			}
		}
		rd = req.getRequestDispatcher("wijzigfactuur.jsp?id="+id+"");
		rd.forward(req, resp);
	}
	
}
