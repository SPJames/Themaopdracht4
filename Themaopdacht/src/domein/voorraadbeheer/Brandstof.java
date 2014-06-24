package domein.voorraadbeheer;

import java.io.Serializable;

/**
 * in deze klasse worden de gegevens van een brandstofsoort ingevuld/bijgewerkt
 */
public class Brandstof implements Serializable{
	private static final long serialVersionUID = 1L;
	private String brandstofType;
	private int tsic;
	private double prijsPerLiter, liter;

	/**
	 * de brandstofsoort wordt aangemaakt. het brandstoftype, de hoeveelheid in liters
	 * en de prijs per liter wordt ingevuld
	 * 
	 * @param tp het brandstoftype
	 * @param l hoeveelheid liters
	 * @param ppl de prijs per liter
	 */
	public Brandstof(String tp, double l, double ppl, int id) {
		brandstofType = tp;
		liter = l;
		tsic = id;
		prijsPerLiter = ppl;
	}

	/**
	 * deze methode vraagt het brandstoftype op
	 * @return het brandstoftype
	 */
	public String getBrandstofType() {
		return brandstofType;
	}

	/**
	 * deze methode vraagt het aantal liters op
	 * @return het aantal liters
	 */
	public double getLiter() {
		return liter;
	}

	/**
	 * deze methode vraagt het tsic nummer op
	 * @return het tsic
	 */
	public int getTsic() {
		return tsic;
	}

	/**
	 * deze methode vult het brandstoftype in
	 * @param tp het brandstoftype
	 */
	public void setBrandstofType(String tp) {
		brandstofType = tp;
	}

	/**
	 * deze methode vult het aantal liters in
	 * @param l het aantal liters
	 */
	public void setLiter(double l) {
		liter = l;
	}

	/**
	 * deze methode vult het tsic nummer in
	 * @param ts het tsic
	 */
	public void setTsic(int ts) {
		tsic = ts;
	}

	/**
	 * deze methode vult de prijs per liter in
	 * @param ppl de prijs per liter
	 */
	public void setPrijsPerLiter(double ppl) {
		prijsPerLiter = ppl;
	}

	/**
	 * deze methode vraagt de prijs per liter op
	 * @return de prijs per liter
	 */
	public double getPrijsPerLiter() {
		return prijsPerLiter;
	}

	/**
	 * deze methode geeft een string terug waarin de gegevens van dit brandstoftype op een rijtje staan
	 * @return een string met alle gegevens van dit brandstoftype
	 */
	public String toString() {
		String s = "Brandstof type: " + getBrandstofType() + ". Liter(s): "
				+ getLiter() + ". TSIC: " + getTsic() + "\n";
		return s;
	}
}
