import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class lecture14 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyx";
        String withdrawQuery =
                "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";

        String depositQuery =
                "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        String query = "SELECT image_data FROM image_table WHERE image_id = (?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established Successfully !!!");

            con.setAutoCommit(false);

            try {
                PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                PreparedStatement depositStatement = con.prepareStatement(depositQuery);

                withdrawStatement.setDouble(1, 500.00);
                withdrawStatement.setString(2, "account456");

                depositStatement.setDouble(1, 500.00);
                depositStatement.setString(2, "account123");

                int rowsAffectedWithdraw = withdrawStatement.executeUpdate();
                int rowsAffectedDeposit = depositStatement.executeUpdate();

                if (rowsAffectedWithdraw > 0 && rowsAffectedDeposit > 0) {
                    con.commit();
                    System.out.println("Transaction Successful!");
                } else {
                    con.rollback();
                    System.out.println("Transaction Failed!!!");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }

    }
