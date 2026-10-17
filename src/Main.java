import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/portfolio_db";
//databse credencial
        String username = "root";
        String password = "xyx";
//        establish the conection

        try(Connection conection = DriverManager.getConnection(url,username,password)){
            System.out.println("connection to the database");
//            perform database operation here
        }
        catch (SQLException e){
            System.out.println("connection faild"+e.getMessage());
        }
        }

    }
