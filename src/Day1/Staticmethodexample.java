package Day1;

class Utils{
	public static int add(int x, int y) {
		return x+ y;
	}
}

public class Staticmethodexample {
	public static void main(String[] args) {
		int sum = Utils.add(1, 2);
		System.out.println(sum);
	}
}
