package Day2;

public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9};
		
		int key = 8;
		
		boolean found  = false;
		
		for (int i=0;i<arr.length;i++) {
			if(arr[i] == key) {
				System.out.println("Element found at index " + i);
				found = true;
				break;
			}
		}
		
		if(!found) {
			System.out.print("Element not found");
		}
	}

}
