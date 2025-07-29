package Day8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collection_Hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> setData = new HashSet<Integer>();
		setData.add(23);
		setData.add(33);
		setData.add(43);
		setData.add(53);
		setData.add(53);
        
		System.out.println(setData);
		
		Iterator<Integer> iterator =setData.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

}