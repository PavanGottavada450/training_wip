package Day5;

interface A1 {
    void display();
}

interface B1 {
    void display();
}

interface C1 {
    void display();
}

class MultiMethods implements A1,B1,C1{
	public void display() {
		System.out.println("display method");
	}
}

public class SameMethods_MI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiMethods obj = new MultiMethods();
		obj.display();
		
		A1 a = obj;
		B1 b = obj;
		C1 c = obj;
		
		a.display();
		b.display();
		c.display();
	}

}
