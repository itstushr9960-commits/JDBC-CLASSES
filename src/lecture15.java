import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class lecture15 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyx";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established Successfully !!!");


            connection.setAutoCommit(false);

            String query = "INSERT INTO employees(name, job_title, salary) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Job Title: ");
                String job_title = scanner.nextLine();

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, job_title);
                preparedStatement.setDouble(3, salary);

                preparedStatement.addBatch();

                System.out.print("Add more values Y/N: ");
                String decision = scanner.nextLine();

                if (decision.toUpperCase().equals("N")) {
                    break;
                }
            }

            int[] batchResult = preparedStatement.executeBatch();

            connection.commit();

            System.out.println("Batch Execute Successfully");}
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }

    }
