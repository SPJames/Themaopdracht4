package domein.financien;

// dit is een abstracte klasse diensttype, deze wordt gebruikt omdat voor verschillende diensten
//op verschillende manieren de prijs berekend moet worden.
public abstract class DienstType {
	protected String dienstType;
	protected double prijs;

	public DienstType() {
	}

	public abstract double dienstPrijs();

	public abstract String dienstType();

}
