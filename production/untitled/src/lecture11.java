import java.sql.*;

public class lecture11 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyz";

        String query = "SELECT * FROM employees WHERE name = ? AND job_title = ?";

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");

            // Establish connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Connection is established!!");

            // Create PreparedStatement
            PreparedStatement preparedStatement =
                    con.prepareStatement(query);

            // Set values for ?
            preparedStatement.setString(1, "tushar");
            preparedStatement.setString(2, "devops");

            // Execute SELECT query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Read result
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String jobTitle = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");

                System.out.println("======================");
                System.out.println("ID        : " + id);
                System.out.println("Name      : " + name);
                System.out.println("Job Title : " + jobTitle);
                System.out.println("Salary    : " + salary);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            con.close();

            System.out.println("Connection closed successfully");

        } catch (SQLException e) {

            System.out.println("SQL Error: " + e.getMessage());

        }
    }
}//import java.sql.*;
//
//public class lecture11 {
//    public static void main(String[] args) throws ClassNotFoundException{
//        String url ="jdbc:mysql://localhost:3306/mock_interview_db";
//        String username = "root";
//        String password= "xyz";
//        String query = "select * from employees where name = ?  AND job_title= ? ";
//
//        try{
//            Class.forName ("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loaded Succesfully");
//        }
//
//        catch(ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        try{
//            Connection con = DriverManager.getConnection(url,username,password);
//            System.out.println("connection is established !!");
//            PreparedStatement preparedStatement = con.prepareStatement(query);int rowsaffected = preparedStatement.executeUpdate(query);
//
//            preparedStatement.setInt(1,3);
//            preparedStatement.setString(2,"tushar");
//            preparedStatement.setString(3,"devops");
//            ResultSet resultSet= preparedStatement.executeQuery();
//            while (resultSet.next()){
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String job_title = resultSet.getString("job_title");
//                double salary = resultSet.getDouble("salary");
//                System.out.println("id"+ id);
//                System.out.println("name"+ name);
//                System.out.println("job_title"+ job_title);
//                System.out.println("salary"+ salary);
//            }
//
//
//            resultSet.close();
//            preparedStatement.close();
//            con.close();
//            System.out.println("connection closed succesfully");
//
//        }
//        catch(SQLException e) {
//            System.out.println(e .getMessage());
//        }
//    }
//}
