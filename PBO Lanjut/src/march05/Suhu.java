package march05;

public class Suhu implements KonversiSuhu{

	@Override
	public double CtoF(double celcius) {
		// TODO Auto-generated method stub
		double result =(celcius*9/5)+32;
		return result;
	}

	@Override
	public double CtoR(double celcius) {
		// TODO Auto-generated method stub
		double result = celcius*4/5;
		return result;
	}

	@Override
	public double FtoC(double fahrenheit) {
		double result=(fahrenheit-32)*5/9;
		return result;
	}

	@Override
	public double FtoR(double fahrenheit) {
		double result=(fahrenheit-32)*4/9;
		return result;
	}

	@Override
	public double RtoC(double reamur) {
		double result=reamur*5/4;
		return result;
	}

	@Override
	public double RtoF(double reamur) {
		double result = 9/4*reamur+32;
		return result;
	}
	public static void main(String[]args) {
		Suhu obj=new Suhu();
		double CelciusToFahrenheitResult = obj.CtoF(100);
		double CelciusToReamurResult = obj.CtoR(100);
		double FahrenheitToCelciusResult = obj.FtoC(100);
		double FahrenheitToReamurResult = obj.FtoR(100);
		double ReamurToCelciusResult = obj.RtoC(100);
		double ReamurToFahrenheitResult = obj.RtoF(100);
		
		System.out.println("Result of Celcius to Fahrenheit : "+ CelciusToFahrenheitResult);
		System.out.println("Result of Celcius to Reamur : "+ CelciusToReamurResult);
		System.out.println("Result of Fahrenheit to Celcius : "+ FahrenheitToCelciusResult);
		System.out.println("Result of Fahrenheit to Reamur : "+ FahrenheitToReamurResult);
		System.out.println("Result of Reamur to Celcius : "+ ReamurToCelciusResult);
		System.out.println("Result of Reamur to Fahrenheit : "+ ReamurToFahrenheitResult);
	}
}
