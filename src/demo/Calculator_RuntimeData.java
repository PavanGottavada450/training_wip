package demo;

public class Calculator_RuntimeData {

	public int add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator_RuntimeData calc = new Calculator_RuntimeData();
		
		int sum = calc.add(3, 4);
		
		System.out.println("sum = "+ sum);
		
	}

}
