package Day4;

abstract class Vehicle_drive{
	abstract void speed();
	abstract void brand();
}

class Car extends Vehicle_drive{
	void speed() {
		System.out.println("speed of the Car 4km/hr");
	}
	void brand() {
		System.out.println("brand is auid");
	}
}

class Bike extends Vehicle_drive{
	void speed() {
		System.out.println("speed of the bike is 4km/hr");
	}
	void brand() {
		System.out.println("brand is yamaha");
	}
}

public class Vehical_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle_drive c = new Car();
		 c.speed();
		 c.brand();
		Vehicle_drive b = new Bike();
		b.brand();
		b.speed();
	}

}
