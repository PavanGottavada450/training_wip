package Day6;

public class ArrayException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5};
		
		try {
			System.out.println("Accessing 6th element : " + arr[5]);
		}
		catch(Exception e) {
			System.out.println("Exception Caught : " + e);
		}
		finally {
			System.out.println("This is Finally block");
		}
	}

}
