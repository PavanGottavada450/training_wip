package Day3;

class Employee1{
	private String name;
	private double salary;
	
	public void setName(String n) {
		name = n;
	}
	
	public void setSalary(double s) {
		salary = s;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Salary : " + salary);
	}
}

public class EncapsulationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee1 emp = new Employee1();
		emp.setName("pavan");
		emp.setSalary(30000);
		emp.display();
	}

}
