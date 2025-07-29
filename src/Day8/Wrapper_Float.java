package Day8;

public class Wrapper_Float {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 45.3f;
		
		String str = String.valueOf(f);  // float to string
		
		System.out.println(str);
		
		
		float f1 = Float.parseFloat(str);
		
		System.out.println(f1);
	}

}
