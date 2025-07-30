package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Enter a number : ");
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int a = Integer.parseInt(br.readLine());
		
		System.out.println("Result : " + a);

	}

}
