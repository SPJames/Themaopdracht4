package klantenbinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Deze klasse wordt gebruikt om de gegevens van een auto in te vullen of te bewerken
 */
public class Auto {
	private String kenteken;
	private String merk;
	private String klantid;
	private Calendar laatstOnderhouden;
	private boolean inReparatie = false;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // zo staat de datum als
														// dag-maand-jaar ipv //
														// Calendar....
	/**
	 * Deze methode maakt een auto aan en vult het kenteken, 
	 * het merk van de auto en het klantid van de eigenaar in
	 * @param kt is het kenteken
	 * @param mk is het merk van de auto
	 * @param id is het klantenid van de eigenaar
	 */
	public Auto(String kt, String mk, String id) {
		setKenteken(kt);
		setMerk(mk);
		setKlantid(id);
	}

	/**
	 * deze methode vult het klantid van de eigenaar in
	 * @param klantid de klantid
	 */
	public void setKlantid(String klantid) {
		this.klantid = klantid;
	}

	/**
	 * deze methode vraagt de klantid van de eigenaar op
	 * @return de klantid
	 */
	public String getKlantid() {
		return klantid;
	}

	/**
	 * deze methode vraagt het kenteken van de auto op
	 * @return het kenteken
	 */
	public String getKenteken() {
		return kenteken;
	}

	/**
	 * deze methode vult het kenteken in
	 * @param kt het kenteken
	 */
	public void setKenteken(String kt) {
		kenteken = kt;
	}

	/**
	 * deze methode vraagt het merk van de auto op
	 * @return het auto merk
	 */
	public String getMerk() {
		return merk;
	}

	/**
	 * deze methode vult het merk van de auto in
	 * @param mk het auto merk
	 */
	public void setMerk(String mk) {
		merk = mk;
	}

	//het kenteken is al een string dus dit is eigenlijk onnodig
	/**
	 * deze methode geeft het kenteken weer in de vorm van een string
	 * @return het kenteken
	 */
	public String toString() {
		String s = getKenteken() + "";
		return s;
	}

	/**
	 * deze methode vraagt de datum van de laatste onderhoudsbeurt op
	 * @return de datum van de laatste onderhoudsbeurt
	 */
	public String getLaatstOnderhouden() {
		return df.format(laatstOnderhouden.getTime());
	}

	/**
	 * deze methode vult de datum van de laatste onderhoudsbeurt in
	 * @param lo de datum waarop de laatste onderhoudsbeurt geweest is
	 */
	public void setLaatstOnderhouden(Calendar lo) {
		laatstOnderhouden = lo;
	}

	/**
	 * deze boolean geeft aan of de auto op dit moment gerepareert wordt of niet
	 * @return de boolean inReparatie
	 */
	public boolean isInReparatie() {
		return inReparatie;
	}

	/**
	 * deze methode vult de boolean inReparatie in
	 * @param inReparatie een true of false waarde afhankelijk van of de auto gerepareert wordt
	 */
	public void setInReparatie(boolean inReparatie) {
		this.inReparatie = inReparatie;
	}

}