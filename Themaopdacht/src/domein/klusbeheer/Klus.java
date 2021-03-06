package domein.klusbeheer;

import java.io.Serializable;
import java.util.HashMap;

import domein.financien.*;
import domein.klantenbinding.Auto;
import domein.voorraadbeheer.*;

/**
 * in deze klasse worden de gegevens van een klus ingevuld/bewerkt
 */
public class Klus implements Serializable{
	private static final long serialVersionUID = 1L;
	private Auto auto;
	private String beschrijving;
	private String werknemer;
	private int klantID;
	private DienstType hetType;
	private int parkeerplaats;
	private static int nummer = 1;
	private int klusnummer;
	private boolean klusafgerond = false;
	private HashMap<Onderdeel, Integer> gebruikteOnderdelen = new HashMap<Onderdeel, Integer>();
	private HashMap<Brandstof, Double> gebruikteBrandstof = new HashMap<Brandstof, Double>();
	private int manuren;

	/**
	 * de klus wordt aangemaakt, de klus krijgt een auto mee waarvoor de klus is aangemaakt,
	 * een beschrijving van wat het probleem is/wat er gedaan moet worden,
	 * het type klus (onderhoud, tanken, parkeren)
	 * en een idnummer als identintificatie. dit nummer wordt automatisch bijgewerkt
	 * 
	 * @param a de auto waarvoor de klus is
	 * @param b de beschrijving van de klus
	 * @param type het type klus
	 * @param id het id nummer van de klus
	 */
	public Klus(Auto a, String b, String type, int id) {
		klusnummer = nummer++; //het automatisch bijwerken
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
		manuren = 0;
	}
	/**
	 *	er is al addmanuren om toe te voegen, dit is om te overschrijven 
	 * 
	 * @param manuren nieuwe int die de oude overschrijft
	 */
	public void setManuren(int manuren) {
		this.manuren = manuren;
	}

	/**
	 * Deze methode word gebruikt om in de klus de onderdelen aantepassen(is een volledig nieuwe HashMap)
	 * 
	 * @param gebruikteOnderdelen is een nieuwe hashmap om de oude te overschrijven
	 */
	public void setGebruikteOnderdelen(
			HashMap<Onderdeel, Integer> gebruikteOnderdelen) {
		this.gebruikteOnderdelen = gebruikteOnderdelen;
	}
	/**
	 * Deze methode word gebruikt om in de klus de brandstof aantepassen(is een volledig nieuwe HashMap)
	 * 
	 * @param gebruikteBrandstof is een nieuwe hashmap om de oude te overschrijven
	 */
	public void setGebruikteBrandstof(HashMap<Brandstof, Double> gebruikteBrandstof) {
		this.gebruikteBrandstof = gebruikteBrandstof;
	}

	/**
	 * Deze methode vraagt de hashmap gebruikteonderdelen op
	 * 
	 * @return een lijst met de onderdelen die in deze klus gebruikt zijn
	 */
	public HashMap<Onderdeel, Integer> getGebruikteOnderdelen() {
		return gebruikteOnderdelen;
	}
	
	/**
	 * Deze methode voegt een onderdelen aan de hashmap gebruikte onderdelen toe als het onderdeel nog
	 * niet in de hashmap staat.
	 * als het onderdeel al wel in de hashmap staat dan wordt de meegegeven waarde aantal 
	 * bij de waarde aantal in de hasmap opgeteld
	 * 
	 * @param ond het toe te voegen onderdeel
	 * @param aant de hoeveelheid van het toe te voegen onderdeel
	 */
	public void addOnderdeel (Onderdeel ond, int aant) {
		if(gebruikteOnderdelen.containsKey(ond)) {
			gebruikteOnderdelen.put(ond, gebruikteOnderdelen.get(ond) + aant);
		} else {
			gebruikteOnderdelen.put(ond, aant);
		}
	}

	/**
	 * deze methode vraagt het klusnummer op
	 * 
	 * @return het klusnummer
	 */
	public int getKlusNummer() {
		return klusnummer;
	}

	/**
	 * deze methode vult het klusnummer in
	 * 
	 * @param kn het klusnummer
	 */
	public void setKlusNummer(int kn) {
		klusnummer = kn;
	}

	/**
	 * deze methode vraagt de beschrijving op
	 * 
	 * @return de beschrijving van het probleem
	 */
	public String getBeschrijving() {
		return beschrijving;
	}

	/**
	 * deze methode vult de beschrijving in
	 * 
	 * @param b de beschrijving van het probleem
	 */
	public void setBeschrijving(String b) {
		beschrijving = b;
	}

	/**
	 * deze methode geeft aan wat voor type klus het is
	 * 
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
	 * 
	 * @return het diensttype
	 */
	public DienstType getHetType() {
		return hetType;
	}

	/**
	 * deze methode vraagt de werknemer op die aan deze klus gaat werken
	 * 
	 * @return de naam van de werknemer
	 */
	public String getWerknemer() {
		return werknemer;
	}

	/**
	 * deze methode vult in welke werknemer er aan deze klus gaat werken
	 * 
	 * @param wn de naam van de werknemer
	 */
	public void setWerknemer(String wn) {
		werknemer = wn;
	}

	/**
	 * deze methode geeft het klusnummer weer in een string
	 * 
	 * @return het klusnummer in een string
	 */
	public String toString() {
		String s = "" + getKlusNummer();
		return s;
	}

	/**
	 * deze methode vraagt de parkeerplaats van de auto op
	 * 
	 * @return de parkeerplaats
	 */
	public int getParkeerplaats() {
		return parkeerplaats;
	}

	/**
	 * deze methode vult de parkeerplaats van de auto in
	 * 
	 * @param parkeerplaats de parkeerplaats
	 */
	public void setParkeerplaats(int parkeerplaats) {
		this.parkeerplaats = parkeerplaats;
	}

	/**
	 * deze methode vraagt de auto die bij deze klus hoort op
	 * 
	 * @return de auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * deze methode vult de auto in die bij deze klus hoort
	 * 
	 * @param auto de auto
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	/**
	 * deze methode vraagt een boolean op die aangeeft of de klus is afgerond
	 * 
	 * @return een true als de klus is afgerond, en anders een false
	 */
	public boolean isKlusafgerond() {
		return klusafgerond;
	}

	/**
	 * deze methode vult de boolean in die aangeeft of de klus is afgerond
	 * 
	 * @param klusafgerond true als de klus is afgerond anders false
	 */
	public void setKlusafgerond(boolean klusafgerond) {
		this.klusafgerond = klusafgerond;
	}

	/**
	 * deze methode vraagt het klantnummer op van de eigenaar van de auto
	 * 
	 * @return het klantnummer
	 */
	public int getKlantID() {
		return klantID;
	}

	/**
	 * deze methode vult het klantnummer in van de eigenaar van de auto
	 * 
	 * @param klantID het klantnummer
	 */
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}

	/**
	 * deze methode vraagt de hasmap gebruiktebrandstof op
	 * 
	 * @return een lijst met de gebruikte brandstof in deze klus
	 */
	public HashMap<Brandstof, Double> getGebruikteBrandstof() {
		return gebruikteBrandstof;
	}

	/**
	 * Deze methode voegt gebruikte brandstof aan de hashmap gebruikteBrandstof toe als de brandstof 
	 * er nog niet in stond.
	 * Als de brandstof er wel in staat wordt de meegegeven waarde aantal bij de bestaande waarde aantal
	 * in de map opgeteld
	 * 
	 * @param br type van de gebruikte brandstof
	 * @param aant gebruikte aantal liters van deze brandstof
	 */
	public void addBrandstof (Brandstof br, Double aant) {
		if(gebruikteBrandstof.containsKey(br)) {
			gebruikteBrandstof.put(br, gebruikteBrandstof.get(br) + aant);
		} else {
			gebruikteBrandstof.put(br, aant);
		}
	}

	/**
	 * deze methode vraagt het aantal gewerkt manuren op
	 * 
	 * @return gewerkte manuren voor deze klus
	 */
	public int getManuren() {
		return manuren;
	}
	
	/**
	 * deze methode voegt een aantal gewerkte manuren toe aan de klus
	 * 
	 * @param manuren het aantal gewerkte uren aan deze klus
	 */
	public void addManuren(int manuren) {
		this.manuren += manuren;
	}
}
