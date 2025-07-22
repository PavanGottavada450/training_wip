
package Day3;

public class SaleSystemOops2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaleItem items[] = {
				new SaleItem("Laptop", 5000, 1),
				new SaleItem("Mouse", 500, 2),
				new SaleItem("keyboard", 1000, 1)
		};
		double grandTotal = 0;
		
		System.out.println("Product\tPrice\tQty\tTotal");
	    System.out.println("--------------------------------------");
		for(SaleItem i : items) {
			i.displayItem();
			grandTotal += i.getTotalPrice();
		}
		System.out.println("--------------------------------------");
		System.out.print("Grand Total : " + grandTotal);
	}

}
