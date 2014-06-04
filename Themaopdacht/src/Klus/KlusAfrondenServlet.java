package Klus;

import java.io.IOException;
//import java.util.ArrayList;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Klus;

public class KlusAfrondenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("allKlussen");
		int id = Integer.parseInt(req.getParameter("id"));
		for (Klus k : klussen) {
			if (id == k.getKlusNummer()) {
				k.setKlusafgerond(true);
				req.setAttribute("msgs", "klus "+id+" succesvol afgerond");
			}
		}
		
		RequestDispatcher rd = null;

		rd = req.getRequestDispatcher("monteur/klussenlijst.jsp");
		rd.forward(req, resp);
	}

}
