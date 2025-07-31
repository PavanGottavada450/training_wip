package course2;

import java.util.Scanner;
import java.util.LinkedList;

class User {

	private String username;
	private String password;
	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}
public class User_Authentication{
	
	private LinkedList<User> userList;
	
	public User_Authentication() {
		userList = new LinkedList<>();
	}
	
	public void register(String username,String password) {
		User newUser = new User(username,password);
		userList.add(newUser);
		System.out.println("User Registered Successfully");
	}
	
	public boolean login(String username,String password) {
		for (User i:userList) {
			if (i.getUsername().equals(username)&& i.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main (String[] args) {
		User_Authentication authSystem= new User_Authentication();
		Scanner sc = new Scanner(System.in);
		
		boolean loggedIn =false;
		while (!loggedIn) {
			System.out.println("choose an option");
			System.out.println("1. register");
			System.out.println("2. login");
			System.out.println("3. exit");

            int choice =sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
            case 1:
            	System.out.println("Enter a username");
            	String regUsername = sc.nextLine();
            	System.out.println("Enter a password");
            	String regPassword = sc.nextLine();
            	authSystem.register(regUsername, regPassword);
            	
            case 2:
            	System.out.println("enter username");
            	String loginUsername =sc.nextLine();
            	System.out.println("enter password");
            	String loginPassword =sc.nextLine();
            	
            	if (authSystem.login(loginUsername, loginPassword)) {
            		System.out.println("login sucessful");
            		loggedIn =true;
            	}
            	else {
            		System.out.println("login failed");
            	}
            	break;
            case 3:
            	System.out.println("existing");
            	loggedIn =true;
            	break;
            	default:
            		System.out.println("invalid choice ");
            }
			
		}
		sc.close();
		
	}
}