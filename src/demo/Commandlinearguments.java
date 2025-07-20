package demo;

class Commandlinearguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 2) {
			System.out.println("please provide two numbers.");
			return;
		}
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			System.out.println("Sum = " + (a + b));
		}catch(NumberFormatException e) {
			System.out.println("Invalid integer input :" + e.getMessage());
		}
	}

}
