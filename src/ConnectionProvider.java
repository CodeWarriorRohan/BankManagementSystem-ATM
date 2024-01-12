import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionProvider
{
    public static void main(String[] args) {
        getConnnection();
    }
    private static Connection conn;
    public static Connection getConnnection()
    {
        try
        {
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/testjdbc";
//            String url = "jdbc:mysql://localhost:3306/Photos";
//            String username = "root";
//            String password = "rna@2004";
            if(conn == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root",
                        "rna@2004");
            }
            System.out.println("Database Connected..!");

//            String q1 = "create table Login(Form_No int(20), Card_Number varchar(50) , Pin_Number varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q1);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q2 = "create table SignUp_1(Form_No int(20), Name varchar(20) , Father_Name varchar(20), Date_of_Birth varchar(20), Gender varchar(20), Email_Address varchar(50), Marital_Status varchar(20), Address varchar(20), City varchar(20), Pin_Code varchar(20), State varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q2);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q3 = "create table SignUp_2(Form_No int(20), Religion varchar(20) , Category varchar(20), Income varchar(20), Educational_Qualification varchar(20), Occupation varchar(50), PanCard_No varchar(20), Aadhaar_No varchar(20), Senior_Citizen varchar(20), Existing_Account varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q3);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q4 = "create table SignUp_3(Form_No int(10),Account_Type varchar(50), Card_Number varchar(50) , Pin_Number varchar(20), Services_Required varchar(50))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q4);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q5 = "create table Transaction(Pin_Number int(10),Date varchar(200),Transaction_Type varchar(200), Amount varchar(50))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q5);
//            System.out.println("Table is created in database!");
//            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}