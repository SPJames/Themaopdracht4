package domein.klusbeheer;

import java.io.Serializable;

/**
 * in deze klasse worden de gegevens van een monteur ingevult/bijgewerkt
 */
public class Monteur implements Serializable{
	private static final long serialVersionUID = 1L;
	private String naam;
	private String password;
	private int id;

	/**
	 * hier wordt de account van de monteur voor op de site aangemaakt
	 * de account krijgt een id, dit nummer wordt automatisch bijgewerkt
	 * 
	 * @param nm de gebruikersnaam van de monteur
	 * @param pw het wachtwoord van de monteur
	 */
	public Monteur(String nm, String pw, int id) {
		setNaam(nm);
		setPassword(pw);
		this.id = id; //het automatisch ophogen
	}
	
	/**
	 * in deze methode wordt het id van de monteur opgevraagd
	 * 
	 * @return het id
	 */
	public int getId() {
		return id;
	}

	/**
	 * deze methode vraagt het wachtwoord op
	 * 
	 * @return het wachtwoord
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * deze methode vult het wachtwoord in
	 * 
	 * @param password het wachtwoord
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * deze methode vraagt de gebruikersnaam op
	 * 
	 * @return de gebruikersnaam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * deze methode vult de gebruikersnaam in
	 * 
	 * @param nm de gebruikersnaam
	 */
	public void setNaam(String nm) {
		naam = nm;
	}
}