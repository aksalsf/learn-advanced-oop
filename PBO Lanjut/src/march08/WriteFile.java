package march08;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class WriteFile {
 public static void main(String args[]) {
	 Scanner userInput = new Scanner(System.in);
	 String fileLocation = "D:/Eclipse/default_workspaces/PBO Lanjut/src/march08/HelloWorld.txt";
	 Path filePath = Paths.get(fileLocation);
	 try {
		BufferedWriter writeFile = Files.newBufferedWriter(filePath,
				 											Charset.forName("ISO-8859-1"),
				 											StandardOpenOption.CREATE,
				 											StandardOpenOption.APPEND);
		System.out.println("Please input your text!");
		System.out.print("=> ");
		String fileContent = userInput.nextLine();
		writeFile.write(fileContent, 0, fileContent.length());
		writeFile.newLine();
		writeFile.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
 }
}
