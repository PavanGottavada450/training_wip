package Day2;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		int b = 5;
		
		// arithmetic
		System.out.println("Sum : "+ (a+b));
		System.out.println("Product : "+(a*b));
		
		//Relational
		System.out.println("Is a greater than b ? " + (a > b));
		
		// Logical
		boolean condition = (a>b) && (a!=b);
		System.out.println("Logical AND result : "+ condition);
	}

}
