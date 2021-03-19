package march05;

public interface KonversiSuhu {
	final int FAHRENHEIT=32;
	public abstract double CtoF(double celcius);
	public abstract double CtoR(double celcius);
	
	public abstract double FtoC(double fahrenheit);
	public abstract double FtoR(double fahrenheit);
	
	public abstract double RtoC(double reamur);
	public abstract double RtoF(double reamur);
}
