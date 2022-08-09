// import java.io.*;
import java.sql.*;
public class CreateTable{
    public static void main(String[] args) {
        try{
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:db/mydb.db");
            System.out.println("connected");
            String sql = "create table movies(name varchar2(30),actor varchar2(30),actress varchar2(30),director varchar2(30),yor number(5))";

            Statement stmt = con.createStatement();
            boolean i = stmt.execute(sql);
            // System.out.println(i);
            if(i==false){
                System.out.println("Table is created");
            }


        }
        catch(Exception e){
            System.out.println("Table already created");

        }
    }
}