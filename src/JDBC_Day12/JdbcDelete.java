package JDBC_Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDelete {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pwd = "Pavan@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			Statement st = con.createStatement();
			
			String deleteQuery = "DELETE FROM sample WHERE id = 3";
			int rowsDeleted = st.executeUpdate(deleteQuery);
			
			System.out.println(rowsDeleted + " row(s) deleted.");
			
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
