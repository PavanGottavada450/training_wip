package Day2;

public class MergeArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3};
		int b[] = {4,5,6};
		int c[] = new int[a.length + b.length];
		
		for(int i=0;i<a.length;i++) {
			c[i] = a[i];
		}
		for (int i=0;i<b.length;i++) {
			c[a.length+i] = b[i];
		}
		System.out.print("Merged array : ");
		for(int value : c) {
			System.out.print(value);
		}
	}

}
