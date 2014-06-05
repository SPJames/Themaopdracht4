package Klusbeheer;

import java.io.IOException;

import klantenbinding.Auto;
import financien.*;

/**
 * in deze klasse worden de gegevens van een klus ingevuld/bewerkt
 */
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

	/**
	 * de klus wordt aangemaakt, de klus krijgt een auto waarvoor de klus is
	 * een beschrijving van wat het probleem is/wat er gedaan moet worden
	 * het type klus (onderhoud, tanken, parkeren)
	 * en een idnummer als identintificatie. dit nummer wordt automatisch bijgewerkt
	 * @param a de auto waarvoor de klus is
	 * @param b de beschrijving van de klus
	 * @param type het type klus
	 * @param id het id nummer van de klus
	 */
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

	//kan deze methode verwijdert worden?
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

	/**
	 * deze methode vraagt het klusnummer op
	 * @return het klusnummer
	 */
	public int getKlusNummer() {
		return klusnummer;
	}

	/**
	 * deze methode vult het klusnummer in
	 * @param kn het klusnummer
	 */
	public void setKlusNummer(int kn) {
		klusnummer = kn;
	}

	/**
	 * deze methode vraagt de beschrijving op
	 * @return de beschrijving
	 */
	public String getBeschrijving() {
		return beschrijving;
	}

	/**
	 * deze methode vult de beschrijving in
	 * @param b de beschrijving
	 */
	public void setBeschrijving(String b) {
		beschrijving = b;
	}

	/**
	 * deze methode vraagt op hoeveel soorten onderdelen er zijn gebruikt
	 * @return het aantal gebruikte soorten onderdelen
	 */
	public int getAantalOnderdelen() {
		return aantalOnderdelen;
	}

	/**
	 * deze methode vult in hoeveel soorten onderdelen er zijn gebruikt
	 * @param aO het aantal gebruikte onderdelen
	 */
	public void setAantalOnderdelen(int aO) {
		aantalOnderdelen = aO;
	}

	/**
	 * deze methode geeft aan wat voor type klus het is
	 * @param dt het diensttype
	 */
	public void setHetType(String dt) {
		if (dt.equals("Onderhoud")) {
			hetType = new Onderhoud();
		} else if (dt.equals("Parkeren")) {
			hetType = new Parkeren();
		} else if (dt.equals("Tanken")) {
			hetType = new Tanken();
		}
	}

	/**
	 * deze methode vraagt het diensttype op
	 * @return het diensttype
	 */
	public DienstType getHetType() {
		return hetType;
	}

	/**
	 * deze methode vraagt de werknemer op die aan deze klus gaat werken
	 * @return de naam van de werknemer
	 */
	public String getWerknemer() {
		return werknemer;
	}

	/**
	 * deze methode vult in welke werknemer er aan deze klus gaat werken
	 * @param wn de naam van de werknemer
	 */
	public void setWerknemer(String wn) {
		werknemer = wn;
	}

	/**
	 * deze methode geeft het klusnummer weer in een string
	 * @return het klusnummer in een string
	 */
	public String toString() {
		String s = "" + getKlusNummer();
		return s;
	}

	/**
	 * deze methode vraagt de parkeerplaats van de auto op
	 * @return de parkeerplaats
	 */
	public int getParkeerplaats() {
		return parkeerplaats;
	}

	/**
	 * deze methode vult de parkeerplaats van de auto in
	 * @param parkeerplaats de parkeerplaats
	 */
	public void setParkeerplaats(int parkeerplaats) {
		this.parkeerplaats = parkeerplaats;
	}

	/**
	 * deze methode vraagt de auto die bij deze klus hoort op
	 * @return de auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * deze methode vult de auto in die bij deze klus hoort
	 * @param auto de auto
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	/**
	 * deze methode vraagt een boolean op die aangeeft of de klus is afgerond
	 * @return een boolean
	 */
	public boolean isKlusafgerond() {
		return klusafgerond;
	}

	/**
	 * deze methode vult de boolean in die aangeeft of de klus is afgerond
	 * @param klusafgerond de waarde voor de boolean
	 */
	public void setKlusafgerond(boolean klusafgerond) {
		this.klusafgerond = klusafgerond;
	}

	/**
	 * deze methode vraagt het klantnummer op van de eigenaar van de auto
	 * @return het klantnummer
	 */
	public int getKlantID() {
		return klantID;
	}

	/**
	 * deze methode vult het klantnummer in van de eigenaar van de auto
	 * @param klantID het klantnummer
	 */
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
}
