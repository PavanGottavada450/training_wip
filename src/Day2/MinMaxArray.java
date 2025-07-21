package Day2;

public class MinMaxArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,2,3,4,5};
		
		int min = arr[0];
		int max = arr[0];
		
		for (int i=0;i<arr.length;i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("Maximum = " + max);
		System.out.println("Minimum = " + min);
	}

}
