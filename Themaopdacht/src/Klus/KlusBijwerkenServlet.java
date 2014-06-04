package Klus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import klantenbinding.Auto;
import Klusbeheer.Klus;

public class KlusBijwerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String[] userinfo = new String[3];
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) req.getServletContext()
				.getAttribute("allKlussen");

		userinfo[0] = req.getParameter("klusid");// klusid voor foreign key
		userinfo[1] = req.getParameter("diensttype");
		userinfo[2] = req.getParameter("comments");
		Auto auto = null;

		Klus klus = null;
		for (Klus k : Klussen) {
			// klus invoer ophalen
			if (k.getKlusNummer() == Integer.parseInt(userinfo[0])) {
				klus = k;
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<Auto> autos = (ArrayList<Auto>) req.getServletContext()
				.getAttribute("allAutos");
		for (Auto a : autos) {
			if (a.getKenteken().equals(req.getParameter("auto"))) {
				auto = a;
			}
		}

		RequestDispatcher rd = null;
		for (int i = 0; i < 3; i++) {
			// foutmelding
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("msgs", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("monteur/klusaanpassen.jsp");
				break;
			} else {
				if (i == 1) {
					klus.setHetType(userinfo[1]);
				} else if (i == 2) {
					klus.setBeschrijving(userinfo[2]);
					req.setAttribute("msgs", "Klus succesvol aangepast.");
					rd = req.getRequestDispatcher("monteur/klussenlijst.jsp");
					auto.setInReparatie(true);
				}
			}
		}

		
		rd.forward(req, resp);
	}
}