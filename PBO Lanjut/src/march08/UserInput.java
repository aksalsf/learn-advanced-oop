package march08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	public static void main(String args[]) {
		String line = "";
		System.out.println("Please input your text!");
		InputStreamReader userInputISR = new InputStreamReader(System.in);
		BufferedReader userInputBR = new BufferedReader(userInputISR);
		try {
			line = userInputBR.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
