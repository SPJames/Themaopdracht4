package domein.klusbeheer;

//import java.io.FileWriter;
import java.io.IOException;

/**
 * in deze klasse worden de gegevens van een monteur ingevult/bijgewerkt
 */
public class Monteur {
	private String naam;
	private String password;
	private static int nummer = 1;
	private int id;

	/**
	 * in deze methode wordt het id van de monteur opgevraagd
	 * @return het id
	 */
	public int getId() {
		return id;
	}

	//staat netter als de constructor bovenaan staat
	/**
	 * hier wordt de account van de monteur voor op de site aangemaakt
	 * de account krijgt een id, dit nummer wordt automatisch bijgewerkt
	 * @param nm de gebruikersnaam van de monteur
	 * @param pw het wachtwoord van de monteur
	 */
	public Monteur(String nm, String pw) {
		setNaam(nm);
		setPassword(pw);
		id = nummer++;
	}

	/**
	 * deze methode vraagt het wachtwoord op
	 * @return het wachtwoord
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * deze methode vult het wachtwoord in
	 * @param password het wachtwoord
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * deze methode vraagt de gebruikersnaam op
	 * @return de gebruikersnaam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * deze methode vult de gebruikersnaam in
	 * @param nm de gebruikersnaam
	 */
	public void setNaam(String nm) {
		naam = nm;
	}

	//kan deze methode weg?
	public void schrijfWeg(String[] monteur) throws IOException {
		// FileWriter fw = new
		// FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/monteur/monteurs.dat",true);
		//
		// fw.write("\n" + id++ + " " + monteur[0] + ":" + monteur[1] + ";");
		// fw.flush();
		// fw.close();
	}

	//deze methode is overbodig want we maken nu een string van een string
	public String toString() {
		String s = "" + getNaam();
		return s;
	}
}
