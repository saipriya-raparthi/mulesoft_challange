import java.sql.*;
import java.util.Scanner;

public class CreateDb {
    public static void create(String db){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:db/"+db);
            System.out.println("connected");
            con.close();
        }
        catch(Exception e){e.printStackTrace();}
        

    }
    public static void main(String[] args) {
        System.out.println("Enter Database name to create");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        create(name);
        sc.close();
    }
    
}
