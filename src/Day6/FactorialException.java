package Day6;

import java.util.Scanner;


public class FactorialException {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter a number to find factorial: ");
	            int num = sc.nextInt();
	            
	            if (num < 0) {
	                throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
	            }

	            long factorial = 1;
	            for (int i = 1; i <= num; i++) {
	                factorial *= i;
	            }

	            System.out.println("Factorial of " + num + " is: " + factorial);
	        } catch (Exception e) {
	            System.out.println("Error occurred: " + e);
	        } finally {
	            System.out.println("finally block");
	            sc.close();
	        }
	    }
	}