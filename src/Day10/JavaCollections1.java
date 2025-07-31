package Day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JavaCollections1 {

	public static void main(String[] args) {
		// adding courses
		
		ArrayList<String> c = new ArrayList<>();

		c.add("Java");
		c.add("C");
		c.add("HTML");
		c.add("HTML");
		c.add("CSS");
		c.add("JavaScript");
		
		for(String i : c) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");
		
		HashSet<Integer> s = new HashSet<>();
		
		s.add(101);
		s.add(103);
		s.add(102);
		s.add(102);
		s.add(102);
		
		for(Integer i : s) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");

		HashMap<String, Integer> h = new HashMap<>();
		
		h.put("Java",101);
		h.put("C", 102);
		h.put("HTML", 103);
		h.put("CSS", 103);
		h.put("Java", 102);
		
		for(String i : h.keySet()) {
			System.out.println(i + " - " + h.get(i));
		}
		
		
	}

}
