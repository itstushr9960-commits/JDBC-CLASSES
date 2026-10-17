import java.sql.*;
public class lecture6 {
    public static void main(String[] args) throws ClassNotFoundException{
        String url ="jdbc:mysql://localhost:3306/mock_interview_db";
        String username = "root";
        String password= "xyz";
        String Query = "INSERT into employees (id,name,job_title,salary) VALUES (2,'sham','full stack  DEVELOPER',20000.0)";
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
                System.out.println("insert succesfully"+rowsaffected+"row(s) affected ");
            } else{
                System.out.println("insert closed succesfully");

            }
            stmt.close();
            con.close();
            System.out.println("connection closeed succesfully");

        }
        catch(SQLException e) {
            System.out.println(e .getMessage());
        }
    }
}
