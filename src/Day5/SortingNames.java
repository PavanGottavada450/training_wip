package Day5;

public class SortingNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Yamaha","BMW","Apache","Toyota","Rx100"};
		
		for (int i = 0; i < names.length - 1; i++) {
			for (int j = i + 1; j < names.length; j++) {
				if(names[i].compareToIgnoreCase(names[j]) > 0) {
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		System.out.println("Sorted names");
		for(String i : names) {
			System.out.println(i);
		}
		
	}

}
