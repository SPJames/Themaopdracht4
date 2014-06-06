package domein.financien;

public abstract class DienstType {
	protected String dienstType;
	protected double prijs;

	public DienstType() {
	}

	public abstract double dienstPrijs();

	public abstract String dienstType();

}
