package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Pavan\\OneDrive\\Desktop\\data.csv"));
			String line;

			while ((line = br.readLine()) != null) {
				// Optional: split line by comma and print each value
				String[] values = line.split(",");
				for (String value : values) {
					System.out.print(value + "\t");
				}
				System.out.println(); // new line
			}

		} catch (FileNotFoundException e) {
			System.out.println("CSV file not found.");
		} catch (IOException e) {
			System.out.println("Error while reading file: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Error while closing the reader.");
			}
			System.out.println("finally block");
		}
	}
}