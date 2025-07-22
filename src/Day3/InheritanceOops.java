package Day3;

class Vehicle{
	void start() {
		System.out.println("Vehical started");
	}
}

class Car extends Vehicle{
	void drive() {
		System.out.print("Car is driving");
	}
}

public class InheritanceOops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.start();
		c.drive();
	}

}
