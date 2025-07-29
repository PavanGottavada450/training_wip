package Day8;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Collection_LinkedHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashSet<Integer> num = new LinkedHashSet<Integer>();
		
		num.add(32);
		num.add(43);
		num.add(56);
		num.add(67);
		num.add(67);
		
		System.out.println(num);
		
		Iterator<Integer> it = num.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
