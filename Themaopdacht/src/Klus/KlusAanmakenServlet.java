package Klus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import klantenbinding.Auto;
import Klusbeheer.Klus;

public class KlusAanmakenServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String[] userinfo = new String[5];
		boolean error = false;
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("allKlussen");
		
		userinfo[0] = req.getParameter("klantid");//userid voor foreign key
		System.out.println("User ID klus aanmaken" + userinfo[0]);
		userinfo[1] = req.getParameter("name");//username voor foreign key
		userinfo[2] = req.getParameter("diensttype");
		userinfo[3] = req.getParameter("comments");
		Auto auto = null;
		
		@SuppressWarnings("unchecked")
		ArrayList<Auto> autos = (ArrayList<Auto>) req.getServletContext().getAttribute("allAutos");
		for(Auto a : autos) {
			if (a.getKenteken().equals(req.getParameter("auto"))) {
				auto = a;
			}
		}
		
		
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
			int plek = -1;
			Klus k = new Klus(auto, userinfo[3], userinfo[2], Integer.parseInt(userinfo[0]));
			//k.schrijfWeg(userinfo);
			Klussen.add(k);
			Parkeerplaats[] parkeer = (Parkeerplaats[]) req.getServletContext().getAttribute("allParkeerplaatsen");
			for (Parkeerplaats p : parkeer) {
				if (p == null) {
					plek = Arrays.asList(parkeer).indexOf(p);
					parkeer[plek] = new Parkeerplaats(auto);
					break;
				}
			}
			if(plek == -1) {
				plek = -2;
			} else {
				k.setParkeerplaats(plek);
				req.setAttribute("plek", (plek + 1));
			}

			if(plek == -2) {
				req.setAttribute("msgs", "Er is op dit moment geen plek beschikbaar. Probeer het later nog eens.");	
				rd = req.getRequestDispatcher("afspraakmaken.jsp");
			} else {
				rd = req.getRequestDispatcher("index.jsp");
				auto.setInReparatie(true);
			}
		}
		rd.forward(req,resp);
	}
	
}
