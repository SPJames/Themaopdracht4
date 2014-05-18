package klantenbinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Klant {
	private String naam;
	private String adres;
	private String postcode;
	private String email;
	private Calendar laatstBezocht;
	private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public Klant(String nm, String ad, String pc, String em) {
		setNaam(nm);
		setAdres(ad);
		setPostcode(pc);
		setEmail(em);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String nm) {
		naam = nm;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String ad) {
		adres = ad;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String pc) {
		postcode = pc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String em) {
		email = em;
	}

	public String getLaatstBezocht() {
		if (laatstBezocht != null) {
			return df.format(laatstBezocht.getTime());
		} else {
			String s = "Geen datum beschikbaar";
			return s;
		}
	}

	public void setLaatstBezocht(Calendar nd) {
		laatstBezocht = nd;
	}

	public ArrayList<Auto> getAlleAutos() {
		return alleAutos;
	}

	public void voegAutoToe(Auto nwA) {
		if (!heeftAuto(nwA.getKenteken())) { // auto kan alleen toegevoegd
												// worden als deze nog niet
												// geregistreerd is
			alleAutos.add(nwA);
		}
	}

	public boolean heeftAuto(String kt) {
		boolean result = false;
		if (zoekAuto(kt) != null) {
			result = true;
		}
		return result;
	}

	public Auto zoekAuto(String kt) {
		Auto result = null;
		for (Auto a : alleAutos) {
			if (a.getKenteken().equals(kt)) {
				result = a;
			}
		}
		return result;
	}

	public boolean verwijderAuto(Auto exA) { // auto kan alleen verwijdert
												// worden als deze geregistreerd
												// is
		boolean result = false;
		if (heeftAuto(exA.getKenteken())) {
			result = true;
			alleAutos.remove(exA);
		}
		return result;
	}

	public int aantalAutos() {
		if (alleAutos.size() != 0) {
			return alleAutos.size();
		} else {
			return 0;
		}
	}

	public String toString() {
		String s = getNaam() + "";
		return s;
	}
}