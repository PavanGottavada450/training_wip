package Day3;

class Student{
	String name;
	int age;
	
	void dispaly() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}
}

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		s1.name = "Pavan";
		s1.age = 23;
		s1.dispaly();
	}

}
