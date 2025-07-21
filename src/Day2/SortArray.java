package Day2;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,4,1,3,5};
		
		Arrays.sort(arr);
		
		System.out.print("Sorted array : ");
		for(int i : arr) {
			System.out.print(i);
		}
	}

}
