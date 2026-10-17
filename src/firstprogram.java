//import java.sql.*;
//
//public class firstprogram {
//
//    public static void main(String[] args) {
//
//        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
//        String username = "root";
//        String password = "system";
//
//        String query = "SELECT * FROM employees";
//
//        try {
//            // Load JDBC Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loaded Successfully");
//
//            // Establish connection
//            Connection con = DriverManager.getConnection(
//                    url,
//                    username,
//                    password
//            );
//
//            System.out.println("Connection is established!!");
//
//            // Create Statement
//            Statement stmt = con.createStatement();
//
//            // Execute SELECT query
//            ResultSet rs = stmt.executeQuery(query);
//
//            // Read data
//            while (rs.next()) {
//
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String jobTitle = rs.getString("job_title");
//                double salary = rs.getDouble("salary");
//
//                System.out.println();
//                System.out.println("======================");
//                System.out.println("ID        : " + id);
//                System.out.println("Name      : " + name);
//                System.out.println("Job Title : " + jobTitle);
//                System.out.println("Salary    : " + salary);
//            }
//
//            // Close resources
//            rs.close();
//            stmt.close();
//            con.close();
//
//            System.out.println();
//            System.out.println("Connection closed successfully");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver Error: " + e.getMessage());
//
//        } catch (SQLException e) {
//            System.out.println("SQL Error: " + e.getMessage());
//        }
//    }
//}
import java.sql.*;

public class firstprogram {
    public static void main(String[] args) throws ClassNotFoundException{
       String url ="jdbc:mysql://localhost:3306/mock_interview_db";
       String username = "root";
       String password= "system";
       String query = "SELECT * FROM employees";

       try{
           Class.forName ("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver Loaded Succesfully");
       }
       catch(ClassNotFoundException e){
           System.out.println(e.getMessage());
        }
       try{
           Connection con = DriverManager.getConnection(url,username,password);
           System.out.println("connection is established !!");
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           while(rs.next()) {

               int id = rs.getInt("id");
               String name = rs.getString("name");
               String job_title = rs.getString("job_title");
               double salary = rs.getDouble("salary");

               System.out.println("===============");
               System.out.println("id : " + id);
               System.out.println("name : " + name);
               System.out.println("job Title : " + job_title);
               System.out.println("salary : " + salary);
           }

           rs.close();
           stmt.close();
           con.close();

           System.out.println("connection closed succESFULLY  ");



       }
       catch(SQLException e) {
           System.out.println(e .getMessage());
        }


    }
}
