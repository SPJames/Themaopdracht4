package Klusbeheer;

import java.io.IOException;

import klantenbinding.Auto;
import financien.*;

public class Klus {
	private Auto auto;
	private String beschrijving;
	private String werknemer;
	private int aantalOnderdelen;
	private int klantID;
	private DienstType hetType;
	private int parkeerplaats;
	private static int nummer = 1;
	private int klusnummer;
	private boolean klusafgerond = false;

	public Klus(Auto a, String b, String type, int id) {
		klusnummer = nummer++;
		setAuto(a);
		beschrijving = b;
		if (type.equals("rep")) {
			hetType = new Onderhoud();
		} else if (type.equals("park")) {
			hetType = new Parkeren();
		} else if (type.equals("tank")) {
			hetType = new Tanken();
		}
		klantID = id;
	}

	public void schrijfWeg(String[] Klus) throws IOException {
		// FileWriter fw = new
		// FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/afspraken.dat",
		// true);
		//
		// fw.write("\n"+ id++ +":"+
		// Klus[0]+";"+Klus[1]+","+Klus[2]+"."+Klus[3]+"|"+Klus[4]+"/");
		// fw.flush();
		// fw.close();
	}

	public int getKlusNummer() {
		return klusnummer;
	}

	public void setKlusNummer(int kn) {
		klusnummer = kn;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String b) {
		beschrijving = b;
	}

	public int getAantalOnderdelen() {
		return aantalOnderdelen;
	}

	public void setAantalOnderdelen(int aO) {
		aantalOnderdelen = aO;
	}

	public void setHetType(String dt) {
		if (dt.equals("Onderhoud")) {
			hetType = new Onderhoud();
		} else if (dt.equals("Parkeren")) {
			hetType = new Parkeren();
		} else if (dt.equals("Tanken")) {
			hetType = new Tanken();
		}
	}

	public DienstType getHetType() {
		return hetType;
	}

	public String getWerknemer() {
		return werknemer;
	}

	public void setWerknemer(String wn) {
		werknemer = wn;
	}

	public String toString() {
		String s = "" + getKlusNummer();
		return s;
	}

	public int getParkeerplaats() {
		return parkeerplaats;
	}

	public void setParkeerplaats(int parkeerplaats) {
		this.parkeerplaats = parkeerplaats;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public boolean isKlusafgerond() {
		return klusafgerond;
	}

	public void setKlusafgerond(boolean klusafgerond) {
		this.klusafgerond = klusafgerond;
	}

	public int getKlantID() {
		return klantID;
	}

	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
}
