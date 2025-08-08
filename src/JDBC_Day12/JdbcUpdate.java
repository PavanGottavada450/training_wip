package JDBC_Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcUpdate {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pwd = "Pavan@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			Statement st = con.createStatement();
			
			String updateQuery = "UPDATE sample SET name = 'Robert' WHERE id = 2";
			
			int rowsUpdated = st.executeUpdate(updateQuery);
			
			System.out.println(rowsUpdated + " row(s) updated.");
			
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
