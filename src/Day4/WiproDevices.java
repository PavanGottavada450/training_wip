package Day4;

interface WiproSystems{
	void deviceType();
	void compilespeed();
}

class Desktop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device : Desktop");
	}
	public void compilespeed() {
		System.out.println("Code is Compiled faster in Desktop");
	}
}

class Laptop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device : Laptop");
	}
	public void compilespeed() {
		System.out.println("Code is compiled slower in Laptop");
	}
}

public class WiproDevices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiproSystems laptop = new Laptop();
		laptop.deviceType();
		laptop.compilespeed();
		
		WiproSystems desktop = new Desktop();
		desktop.deviceType();
		desktop.compilespeed();
	}

}
