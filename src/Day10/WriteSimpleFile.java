package Day10;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSimpleFile {

	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("C:\\Users\\Pavan\\OneDrive\\Desktop\\writeSimpleFile.txt" );
			
			writer.write("Hello, I am trying to write simple text file \n");
			writer.write("Tools like automation and perfromance tools \n");
			
			writer.close();
			
			System.out.println("Data written to file successfully");
			
		} catch(IOException e) {
			System.out.println("An error occured while writing to the file.");
			e.printStackTrace();
		}

	}

}
