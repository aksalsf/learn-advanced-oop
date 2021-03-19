package march01;

public interface KonversiSuhu {
	final int FAHRENHEIT = 32;
	// from celcius	
	abstract double CtoF(double celcius);
	abstract double CtoR(double celcius);
	// from fahrenheit
	abstract double FtoC(double fahrenheit);
	abstract double FtoR(double fahrenheit);
	// from reamur
	abstract double RtoC(double reamur);
	abstract double RtoF(double reamur);
	
}
