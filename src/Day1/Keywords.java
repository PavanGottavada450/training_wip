package Day1;
import java.util.Scanner;

public class Keywords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number : ");
		int a = sc.nextInt();
		
		System.out.println("Enter second number : ");
		int b = sc.nextInt();
		
		int sum = a+b ; 
		System.out.println("sum = " + sum);
		
		sc.close();
	}

}
