package Day5;

interface A{
	static void activity() {
		System.out.println("Activity from A -> Static");
	}
}

interface B{
	default void activity(){
		System.out.println("Activity from B -> default ");
	}
}

interface C{
	void activity();
}

class Testb implements B{
	
	public void activity() {
		System.out.println("Activity B -> default override");
	}
}

class Testc implements C{
	public void activity() {
		System.out.print("Activity from C -> abstract");
	}
}

public class MultipleInterfaces {

	public static void main(String[] args) {
		
		A.activity();
		
		Testb tb = new Testb();
		tb.activity();
		
		Testc t = new Testc();
		t.activity();
	}

}
