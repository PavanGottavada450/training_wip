package Day2;
import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
//		int num = 13;
		boolean isPrime = true;
		
		for (int i=2;i<num;i++) {
			if(num%i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			System.out.print(num + " is a Prime number");
		}else {
			System.out.print(num + " is not a prime number");
		}
		
	}

}
