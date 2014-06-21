package servlets.monteurServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.email.KlusAfgerondEmail;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Parkeerplaats;

/**
 * In deze servlet kan een klus worden afgerond.
 */
public class KlusAfrondenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * De klusstatus wordt op afgerond gezet en er verschijnt een bericht dat de
	 * klus succesvol is afgerond. De monteur wordt doorgestuurd naar de
	 * klussenlijst.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("alleKlussen");
		Parkeerplaats[] parkeer = (Parkeerplaats[]) req.getServletContext().getAttribute("alleParkeerplaatsen");
		// auto vrijgeven + parkeerplaats resetten
		int id = Integer.parseInt(req.getParameter("id"));
		for (Klus k : klussen) {
			if (id == k.getKlusNummer()) {
				k.setKlusafgerond(true);
				k.getAuto().setInReparatie(false);
				for(int i=0; i<50; i++) {
					if(parkeer[i] == null) {
						break;
					} else if (parkeer[i].getAuto().getKenteken().equals(k.getAuto().getKenteken())){
						System.out.println(parkeer[i].getAuto().getKenteken());
						parkeer[i] = null;
					}
				}
				req.setAttribute("msgs", "Klus " + id + " succesvol afgerond");

				// klanten gegevens ophalen voor email
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) req
						.getServletContext().getAttribute("alleUsers");

				Klant klant = null;
				for (Klant kl : klanten) {
					if (k.getKlantID() == kl.getId()) {
						klant = kl;
					}
				}

				@SuppressWarnings("unused")
				KlusAfgerondEmail m = new KlusAfgerondEmail((klant.getEmail()), klant.getNaam());
			}
		}

		req.getRequestDispatcher("klussenlijst.jsp").forward(req, resp);

	}

}
