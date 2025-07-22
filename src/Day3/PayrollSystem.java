package Day3;

abstract class Employee{
	String name;
	int empId;
	
	public Employee(String name, int empId) {
		this.name = name;
		this.empId = empId;
	}
	
	abstract double calculateSalary();
	
	public void display() {
		System.out.println("Employee Id : " + empId);
		System.out.println("Employee Name : " + name);
	}
	
}

class FullTimeEmployee extends Employee{
	
	double monthlySalary;
	
	public FullTimeEmployee(String name, int empId, double monthlySalary) {
		super(name, empId);
		this.monthlySalary = monthlySalary;
	}

	@Override
	double calculateSalary() {
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee{
	
	int hoursWorked;
	double ratePerHour;
	
	public PartTimeEmployee(String name, int empId, int hoursWorked, double ratePerHour) {
		super(name, empId);
		this.hoursWorked = hoursWorked;
		this.ratePerHour = ratePerHour;
	}

	@Override
	double calculateSalary() {
		return hoursWorked * ratePerHour;
	}
}

public class PayrollSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new FullTimeEmployee("pavan", 101, 50000);
		Employee e2 = new PartTimeEmployee("sai", 102, 80, 300);
		
		e1.display();
		System.out.println("Salary : $" + e1.calculateSalary());
		
		System.out.println();
		
		e2.display();
		System.out.println("Salary : $ " + e2.calculateSalary());
	}

}
