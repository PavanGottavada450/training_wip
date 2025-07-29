package Day8;

import java.util.ArrayList;
import java.util.List;

public class Collection_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = new ArrayList<Integer>();
		
		  // Autoboxing happens here: int → Integer
		num.add(10); 
		num.add(11);
		num.add(12);
		num.add(13);
		num.add(14);
		
		System.out.println("ArrayList : " + num);
		
		System.out.println("value at 3 - " + num.get(3));
		
		for(int i=0;i<num.size();i++) {  // Auto-unboxing: Integer → int
			System.out.println(num.get(i));
		}
		
		int sum = 0;
		for(Integer i : num) {
			sum += i;
		}
		System.out.println("sum : " + sum);
		
	}

}
