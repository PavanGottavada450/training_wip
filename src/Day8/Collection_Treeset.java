package Day8;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection_Treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Integer> num = new TreeSet<Integer>();
		
		num.add(23);
		num.add(47);
		num.add(32);
		num.add(11);
		
		System.out.println(num); // sorted order
		
		Iterator<Integer> it = num.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
