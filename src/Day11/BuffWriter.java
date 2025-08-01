package Day11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BuffWriter {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Pavan\\OneDrive\\Desktop\\writeSimpleFile.txt"));
		
		br.write("hello world");
		br.close();
		System.out.println("successful");
		
	}

}
