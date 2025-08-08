package JDBC_Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsert {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pwd = "Pavan@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			Statement st = con.createStatement();
			
			// INSERT Query
			String insertQuery = "INSERT INTO sample (id, name, email) VALUES (2, 'vinod', 'vinod@gmail.com')";
			int rowsInserted = st.executeUpdate(insertQuery);
			
			System.out.println(rowsInserted + "row(s) inserted.");
			
			// SELECT Query to display table contents
			ResultSet rs = st.executeQuery("SELECT * FROM sample");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
