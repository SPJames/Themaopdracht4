package servlets.klantServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Auto;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Parkeerplaats;

public class KlusAanmakenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[5];
		boolean error = false;
		
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("alleKlussen");
		@SuppressWarnings("unchecked")
		ArrayList<Auto> autos = (ArrayList<Auto>) req.getServletContext().getAttribute("alleAutos");
		Parkeerplaats[] parkeer = (Parkeerplaats[]) req.getServletContext().getAttribute("alleParkeerplaatsen");

		userinfo[0] = req.getParameter("klantid");// userid voor foreign key
		userinfo[1] = req.getParameter("name");// username voor foreign key
		userinfo[2] = req.getParameter("diensttype");
		userinfo[3] = req.getParameter("comments");
		Auto auto = null;

		for (Auto a : autos) {
			if (a.getKenteken().equals(req.getParameter("auto"))) {
				auto = a;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error = true;
			}
		}

		RequestDispatcher rd = null;
		if (error) {
			// foutmelding
			req.setAttribute("msgs", "Input was empty");
			rd = req.getRequestDispatcher("afspraakmaken.jsp");
		} else if (!(auto.isInReparatie())) {
			// aanmaken nieuwe klus
			int plek = -1;
			Klus k = new Klus(auto, userinfo[3], userinfo[2],
					Integer.parseInt(userinfo[0]));
			// k.schrijfWeg(userinfo);
			Klussen.add(k);
			// parkeerplaats toewijzen
			
			for (Parkeerplaats p : parkeer) {
				if (p == null) {
					plek = Arrays.asList(parkeer).indexOf(p);
					parkeer[plek] = new Parkeerplaats(auto);
					break;
				}
			}
			if (plek == -1) {
				plek = -2;
			} else {
				k.setParkeerplaats(plek);
				req.setAttribute("msgs", "De klus is geregistreerd! Uw gereserveerde parkeerplek is " + (plek + 1));
			}
			if (plek == -2) {
				// foutmelding, als er geen parkeerplek is
				req.setAttribute("msgs", "Er is op dit moment geen plek beschikbaar. Probeer het later nog eens.");
				rd = req.getRequestDispatcher("afspraakmaken.jsp");
			} else {
				rd = req.getRequestDispatcher("../index.jsp");
				auto.setInReparatie(true);
			}
		} else if (auto.isInReparatie()){ 
			req.setAttribute("msgs", "Deze auto is al in reparatie!");
			rd = req.getRequestDispatcher("afspraakmaken.jsp");
		}
		rd.forward(req, resp);
	}

}