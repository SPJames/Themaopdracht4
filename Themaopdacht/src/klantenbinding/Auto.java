package klantenbinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Klusbeheer.Klus;

public class Auto {
	private String kenteken;
	private String merk;
	private Calendar laatstOnderhouden;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // zo staat de datum als
														// dag-maand-jaar ipv //
														// Calendar....

	public Auto(String kt, String mk) {
		setKenteken(kt);
		setMerk(mk);
	}

	public String getKenteken() {
		return kenteken;
	}

	public void setKenteken(String kt) {
		kenteken = kt;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String mk) {
		merk = mk;
	}

	public String toString() {
		String s = getKenteken() + "";
		return s;
	}

	public String getLaatstOnderhouden() {
		return df.format(laatstOnderhouden.getTime());
	}

	public void setLaatstOnderhouden(Calendar lo) {
		laatstOnderhouden = lo;
	}

}