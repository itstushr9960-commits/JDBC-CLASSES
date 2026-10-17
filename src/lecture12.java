import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class lecture12 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyx";

        String query = "INSERT INTO image_table(image_data) VALUES(?)";
        String image_path = "C:\\Users\\hp\\OneDrive\\Pictures\\Narayana.png";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully !!!");

            FileInputStream fileInputStream = new FileInputStream(image_path);

            byte[] imageData = new byte[fileInputStream.available()];

            fileInputStream.read(imageData);

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setBytes(1, imageData);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Image Inserted Successfully!!");
            } else {
                System.out.println("Image not Inserted!!");
            }
        }
        catch (SQLException | FileNotFoundException e) {

            System.out.println("SQL Error: " + e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}