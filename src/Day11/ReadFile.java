package Day11;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		FileReader f = new FileReader("C:\\Users\\Pavan\\OneDrive\\Desktop\\writeSimpleFile.txt");

		int ch;
		while((ch = f.read()) != -1) {
			System.out.print((char)ch);
		}
		
	}

}
