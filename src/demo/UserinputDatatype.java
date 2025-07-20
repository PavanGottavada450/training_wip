package demo;
import java.util.Scanner;

public class UserinputDatatype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter your Score(int): ");
		int score = sc.nextInt();
		
		System.out.println("Enter your height : ");
		double height = sc.nextDouble();
		
		System.out.println("\n Hello,"+name);
		System.out.println("Score: "+score);
		System.out.println("Height : "+height);

	}

}
