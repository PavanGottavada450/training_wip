package Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
	String name;
	int rollNo;
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public int compareTo(Student other) {
		return this.rollNo - other.rollNo;
	}
	
	public String toString() {
		return name + " - Roll No : " + rollNo;
	}
	
}

public class Coll_Comparable {

	public static void main(String[] args) {
		
		List<Student> num = new ArrayList<>();
		
		num.add(new Student("pavan", 3));
		num.add(new Student("vamsi", 5));
		num.add(new Student("vinod", 4));

		System.out.println("Before Sorting : ");
		for(Student i : num) {
			System.out.println(i);
		}
		
		Collections.sort(num);
		
		System.out.println("After Sorting : ");
		for(Student i : num) {
			System.out.println(i);
		}
		
	}

}
