package Day8;

public class Wapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 12.0;
		
		Double D = a;	//auto boxing
		
		double d = D;	// auto unboxing
		
		System.out.println(d);
		
		
		
		String s = "12.34";
		
		double ds = Double.parseDouble(s); 
		
		System.out.println(ds);
		
		
	}

}
