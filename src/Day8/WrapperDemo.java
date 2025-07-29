package Day8;

public class WrapperDemo {
    public static void main(String[] args) {
        int a = 5;

        // Autoboxing
        Integer obj = a;

        // Unboxing
        int b = obj;

        // String to int
        int c = Integer.parseInt("100");

        // int to String
        String s = String.valueOf(c);

        System.out.println( obj + " - " + obj.getClass().getSimpleName());
    }
}
