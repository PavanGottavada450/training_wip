package Day2;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original = "madam";
        StringBuilder sb = new StringBuilder(original);
        sb.reverse();

        if (original.equals(sb.toString())) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
	}

}
