package course1;

import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num%2 == 0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
		sc.close();
	}

}
