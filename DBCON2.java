import java.sql.*;

public class DBCON2 {
    
    Connection con;
    DBCON2()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        
            String connectionUrl= "jdbc:mysql://localhost:3306/AccoundDetails2";
            con = DriverManager.getConnection(connectionUrl,"root","12345");
            System.out.println("Connection pass....."); 
        }
        catch(Exception e)
        {
           System.out.println("Sorry....");       
        }
    }
    public static void main(String[] args){
        DBCON2 obj = new DBCON2();
    }
}
