package klantenbinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Auto {
	private String kenteken;
	private String merk;
	private String klantid;
	private Calendar laatstOnderhouden;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // zo staat de datum als
														// dag-maand-jaar ipv //
														// Calendar....

	public Auto(String kt, String mk, String id) {
		setKenteken(kt);
		setMerk(mk);
		setKlantid(id);
	}
	
	public void setKlantid(String klantid) {
		this.klantid = klantid;
	}

	public String getKlantid() {
		return klantid;
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