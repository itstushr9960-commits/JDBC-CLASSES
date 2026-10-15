import java.sql.*;
import java.util.Scanner;

public class lecture10 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyz";

        String query = "INSERT INTO employees(id,name,job_title,salary) VALUES(?,?,?,?)";

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }
        catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
        }
        try
        {
            // Establish connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Connection is established!!");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            String name = scanner.nextLine();
            String job_title = scanner.nextLine();
            double salary = scanner.nextDouble();

//          Statement statement= con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(query);

            PreparedStatement.setInt(1,id);
            PreparedStatement.setString(1,name);
            PreparedStatement.setString(2,job_title);
            PreparedStatement.setDouble(2,salary);
             int rowAffected = preparedStatement.executeUpdate();
             if (rowAffected>0){
                 System.out.println("data inserted succesfully");
             } else {

                 System.out.println("data inserted FAIL");
             }
ResultSet resultSet =preparedStatement.executeQuery();
while(resultSet.next()){


    int id = resultSet.getInt("id");
    String name = resultSet.getStirng("name");
    String job_title = resultSet.getStirng("job_title");
    double salary = resultSet.getDouble("salary");
            System.out.println("id : "+id);
            System.out.println("name : "+name);
            System.out.println("job_title : "+job_title);
            System.out.println("salary : "+salary);

        }
            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println("Connection closed successfully");
        }
catch (SQLException e) {

            System.out.println("SQL Error: " + e.getMessage());

        }
    }
}