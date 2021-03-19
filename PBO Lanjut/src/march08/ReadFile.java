package march08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String 	line = "",
				content = "",
				fileLocation = "D:/Eclipse/default_workspaces/PBO Lanjut/src/march08/HelloWorld.txt";
		try {
			BufferedReader fileInput = new BufferedReader(new FileReader(new File(fileLocation)));
			line = fileInput.readLine();
			content = line + "\n";
			System.out.println(content);
			while(line != null) {
				line = fileInput.readLine();
				if(line != null) {
					content = line + "\n";
					System.out.println(content);
				}
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path filePath = Paths.get(fileLocation);
		System.out.print("Filename: ");
		System.out.println(filePath.getFileName());
		
	}

}
