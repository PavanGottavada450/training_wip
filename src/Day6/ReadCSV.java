package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Pavan\\OneDrive\\Desktop\\data.csv"));
			String line=br.readLine();
		    while(line!=null) {
		    	System.out.println("File Content : "+line);
		    	line=br.readLine();
		    	
		    }
		   br.close(); 

		} catch (FileNotFoundException e) {
			System.out.println("CSV file not found.");
		} catch (IOException e) {
			System.out.println("Error while reading file: " + e.getMessage());
//			e.printStackTrace();
		} finally {
			System.out.println("finally block");
		}
	}
}