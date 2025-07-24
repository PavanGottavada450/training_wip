package Day5;
import java.util.Scanner;

public class Attendence_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter the number of students : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] name = new String[n];
		String[] status = new String[n];
		
		int presentCount = 0, absentCount = 0;
		
		for(int i=0; i<n;i++) {
			System.out.print("enter name of student " + (i+1) + ": ");
			name[i] = sc.nextLine();
			
			System.out.print("Is" + name[i] + "present ? (P/A) :");
			status[i] = sc.nextLine().trim().toUpperCase();
			
			if(!status[i].equals("P") && !status[i].equals("A")) {
				System.out.println("Invaild input . Marking Absent by default.");
				status[i] = "A";
			}
			
			if(status[i].equals("P")) {
				presentCount++;
			}else {
				absentCount++;
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(name[i] + " - " + (status[i].equals("P") ? "Present" : "Absent"));
		}
		
		System.out.println("\nTotal Present: " + presentCount);
        System.out.println("Total Absent: " + absentCount);
        
        sc.close();
		
	}

}
