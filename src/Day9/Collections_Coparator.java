package Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_Coparator {

	public static void main(String[] args) {
		
		
		Comparator<Integer> c1 = new Comparator<Integer>() {
			
			public int compare(Integer i, Integer j) {
				if(i > j) {
					return 1;
				}else {
					return -1;
				}
			}
		};
		

		List<Integer> marks = new ArrayList<>();
		marks.add(23);
		marks.add(45);
		marks.add(12);
		marks.add(78);
		marks.add(34);
		
		System.out.println("Before sorting : " + marks);
		
		Collections.sort(marks, c1);
		System.out.println("After sorting : " + marks);
		
	}

}
