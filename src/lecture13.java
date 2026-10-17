import java.io.*;
import java.sql.*;

public class lecture13 {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password = "xyx";

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

            PreparedStatement preparedStatement = con.prepareStatement(query);

            int x= 1;
            preparedStatement.setInt(1, x);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                byte[] image_data = resultSet.getBytes("image_data");

                String folder_path = "D:\\sigma web development series\\";
                String image_path = folder_path + "extractedImage.jpg";

                OutputStream outputStream = new FileOutputStream(image_path);

                outputStream.write(image_data);

            } else {
                System.out.println("Image not found!!!");
            }
        }
        catch (SQLException | FileNotFoundException e) {

            System.out.println("SQL Error: " + e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}