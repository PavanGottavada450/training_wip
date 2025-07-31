package Day10;

import java.util.ArrayList;

public class JavaCollections {

	class department{
		private String name;
		private double sales;
		private double expenses;
		
		public department(String name, double sales, double expenses) {
			this.name = name;
			this.sales = sales;
			this.expenses = expenses;
		}
		
		public double getProfit() {
			return sales - expenses;
		}
		
		public String getName() {
			return name;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<department> depart = new ArrayList<>();
		
		depart.add(new JavaCollections().new department("pavan",2000.00,1500.00));
		depart.add(new JavaCollections().new department("sai",3000.00,1200.00));
		depart.add(new JavaCollections().new department("mani", 2500.00,1600.00));
		
		for(department i:depart) {
			System.out.println(i.getName() + " - " + i.getProfit());
		}
		
		depart.sort((d1,d2) -> Double.compare(d1.getProfit(), d2.getProfit()));
		
		System.out.println("Sorting done");
		
		for(department i : depart) {			
			System.out.println(i.getName() + " - " + i.getProfit());
		}
		
	}

}
