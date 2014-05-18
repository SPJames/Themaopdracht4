package voorraadbeheer;

public class Brandstof {
	private String brandstofType;
	private int liter, tsic;
	private double prijsPerLiter;

	public Brandstof(String tp, int l, int ts, double ppl) {
		brandstofType = tp;
		liter = l;
		tsic = ts;
		prijsPerLiter = ppl;
	}

	public String getBrandstofType() {
		return brandstofType;
	}

	public int getLiter() {
		return liter;
	}

	public int getTsic() {
		return tsic;
	}

	public void setBrandstofType(String tp) {
		brandstofType = tp;
	}

	public void setLiter(int l) {
		liter = l;
	}

	public void setTsic(int ts) {
		tsic = ts;
	}

	public void setPrijsPerLiter(double ppl) {
		prijsPerLiter = ppl;
	}

	public double getPrijsPerLiter() {
		return prijsPerLiter;
	}

	public String toString() {
		String s = "Brandstof type: " + getBrandstofType() + ". Liter(s): "
				+ getLiter() + ". TSIC: " + getTsic() + "\n";
		return s;
	}
}
