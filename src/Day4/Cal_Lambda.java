package Day4;

interface cal{
    int operator(int a, int b);
}

public class Cal_Lambda{
    public static void main(String[] args){
        cal add = (a,b) -> a + b;
        cal sub = (a,b) -> a - b;
        
        System.out.println("Addition : " + add.operator(1,2));
        System.out.print("Subtraction : " + sub.operator(5,3));
    }
}