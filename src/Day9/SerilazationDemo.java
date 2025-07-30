package Day9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student1 implements Serializable {  // Must implement Serializable
    private int rollno;
    private String name;

    public Student1(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public Student1() {}

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + "]";
    }

    // Getters and Setters
    public int getRollno() { return rollno; }
    public void setRollno(int rollno) { this.rollno = rollno; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

public class SerilazationDemo {
    public static void main(String[] args) {
        Student1 std1 = new Student1();
        std1.setRollno(10);
        std1.setName("Afrid");

        try (FileOutputStream out = new FileOutputStream("C:\\Users\\Meehir\\Downloads\\java.txt");
             ObjectOutputStream output = new ObjectOutputStream(out)) {

            output.writeObject(std1);  // Serialize object
            System.out.println("Serialized data saved in file");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}