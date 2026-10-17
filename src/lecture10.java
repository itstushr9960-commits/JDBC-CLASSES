import java.sql.*;
import java.util.Scanner;

public class lecture10 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyx";

        String query = "INSERT INTO employees(id,name,job_title,salary) VALUES(?,?,?,?)";

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }
        catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
                return;
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

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Job Title: ");
            String job_title = scanner.nextLine();

            System.out.print("Enter Salary: ");
            String salaryInput = scanner.nextLine();
            double salary = Double.parseDouble(salaryInput);

// Statement statement = con.createStatement();

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, job_title);
            preparedStatement.setDouble(4, salary);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Inserted Successfully!!!");
            } else {
                System.out.println("Data Insertion Failed!!!");
            }

            preparedStatement.close();
            con.close();

            System.out.println();
            System.out.println("Connection Closed Successfully!!!!");

        }
catch (SQLException e) {

            System.out.println("SQL Error: " + e.getMessage());

        }
    }
}