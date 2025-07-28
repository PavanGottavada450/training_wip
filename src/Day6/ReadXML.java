package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadXML {

	public static void main(String[] args) {

	        try {
	        	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Pavan\\OneDrive\\Desktop\\data.xml"));

	        	String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println("XML Line: " + line);
	            }
	            br.close();
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("XML file not found.");
	        } 
	        catch (IOException e) {
	            System.out.println("Error reading XML file.");
	        } 
	        finally {
	        	System.out.println("Code Executed....");
	        }
	    }
	}