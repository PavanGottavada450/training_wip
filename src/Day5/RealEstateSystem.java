package Day5;

import java.util.Scanner;

abstract class RentCalculator{
	abstract void tax(double rent);
}

class Apartment extends RentCalculator{
	void tax(double r1) {
       double t = 10 * r1 / 100;
       double r2 = t + r1;
       System.out.println("Tax for Apartment (10% of " + r1 + "): " + t);
       System.out.println("Final Apartment Rent: " + r2);
	}
}

class House extends RentCalculator{
	void tax(double r1) {
       double t = 10 * r1 / 100;
       double r2 = t + r1;
       System.out.println("Tax for Apartment (10% of " + r1 + "): " + t);
       System.out.println("Final Apartment Rent: " + r2);
	}
}

public class RealEstateSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your category (Apartment / House)");
		String category = sc.next();
		
		System.out.println("Enter base rent amount : ");
		double rent = sc.nextDouble();
		
		RentCalculator rc ;
		
		if(category.equalsIgnoreCase("Apartment")) {
			rc = new Apartment();
		}else if(category.equalsIgnoreCase("House")){
			rc = new House();
		}else {
			System.out.println("Invaild category entered.");
			sc.close();
			return;
		}
		
		rc.tax(rent);
		sc.close();
	}

}
