package Day5;

interface LambdaCalculator1{
	double num(double a,double b);
}

public class LambdaCalculator {

	public static void main(String[] args) {

		LambdaCalculator1 addition = (a,b) -> {
			System.out.print("Addition ");
			double result = a + b;
			System.out.println("Result : " + result);
			return result;
		};
		
		LambdaCalculator1 subtract = (a,b) -> a - b;
		
		double a = 1000.0, b = 1000.0;
		
		addition.num(a,b);
		
		System.out.println("Subtraction : " + subtract.num(a, b));
		
	}

}
