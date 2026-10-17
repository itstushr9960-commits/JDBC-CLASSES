import java.sql.*;

public class lecture8 {
    public static void main(String[] args) throws ClassNotFoundException{
        String url ="jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password= "xyz";
        String Query = "UPDATE employees SET job_title = 'devops' WHERE id = 3;";

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
            int rowsaffected = stmt.executeUpdate(Query);
            if (rowsaffected>0){
                System.out.println("updated succesfully"+rowsaffected+"row(s) affected ");
            } else{
                System.out.println("updation closed succesfully");

            }
            stmt.close();
            con.close();
            System.out.println("connection closed succesfully");

        }
        catch(SQLException e) {
            System.out.println(e .getMessage());
        }
    }
}
