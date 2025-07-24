package course2;
import java.util.Random;

public class Assginment1 {

	public static long generateTenDigitNum() {
		Random random = new Random();
		long min = 1_000_000_000L;
		long max = 9_999_999_999L;
		
		long random10DigitNum = min + ((long)(random.nextDouble() * (max - min + 1)));
		return random10DigitNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long random10DigitNum = generateTenDigitNum();
		System.out.println("Random 10-Digit Number : " + random10DigitNum);
	}

}
