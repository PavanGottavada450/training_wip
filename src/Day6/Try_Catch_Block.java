package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Try_Catch_Block {

	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\Pavan\\OneDrive\\Desktop\\hello.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while(line != null) {
				System.out.println("File Content " + line);
				line = br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found error" + e);
		}
		catch(IOException e ) {
			System.out.println("IO error occured while reading the file" + e);
		}
		finally {
			System.out.println("This is the complete Execution");
		}
	}

}
