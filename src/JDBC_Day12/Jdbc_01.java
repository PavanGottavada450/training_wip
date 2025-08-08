package JDBC_Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String pwd = "Pavan@123";
        String query = "select * from sample";

        try {
            //1. Load JDBC Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. Establish Connection
            Connection con = DriverManager.getConnection(url, userName, pwd);

            //3. Create Statement
            Statement st = con.createStatement();

            //4. Execute Query
            ResultSet rs = st.executeQuery(query);

            // Iterate and Print Results
            while (rs.next()) {
                // Assuming sample table has at least 3 columns
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            //5. Close Resources
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error occurred.");
            e.printStackTrace();
        }
    }
}
