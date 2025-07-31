package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JavaCollections2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(103,104,101,102));
		
		l.add(105);
		
		System.out.println(l);
		
		Collections.sort(l);
		System.out.println("sorted : " +  l);

		int b = Collections.binarySearch(l,  105);
		System.out.println("Index of 105 in sorted list : " + b);
		
		Collections.reverse(l);
		System.out.print("reverse : " + l);
		
	}

}
