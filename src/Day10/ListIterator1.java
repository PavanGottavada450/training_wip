package Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIterator1 {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<>(List.of("A","B","C","D"));
		
		ListIterator<String> it = l.listIterator();
		
		System.out.println("Forward : ");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.print("Backward : ");
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}

	}

}
