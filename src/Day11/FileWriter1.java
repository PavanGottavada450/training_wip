package Day11;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter1 {

	public static void main(String[] args) throws IOException {
		
		String content = "hello world, askhdabasdbmbad";
		
		try (FileWriter f = new FileWriter("C:\\Users\\Pavan\\OneDrive\\Desktop\\writeSimpleFile.txt")) {
			f.write(content);
//			f.close();
		}
		
		System.out.println("Data written in file successfully");
	}

}
