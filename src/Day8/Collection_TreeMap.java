package Day8;

import java.util.TreeMap;

public class Collection_TreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,String> n = new TreeMap<>();
		
		n.put(104, "pavan");
		n.put(103, "sai");
		n.put(105, "mani");
		n.put(101, "manu");
		n.put(102, "vamsi");
		
		System.out.println(n.keySet());
		System.out.println(n.values());
		
		System.out.println(n);
		
		for(int i : n.keySet()) {
			System.out.println( i + " " + n.get(i));
		}
	}

}
