import java.sql.*;
import java.util.*;

// import javax.swing.GroupLayout.Alignment;
public class QueryingData{
    public static void printData(ResultSet rs){
        System.out.println("Name\t\tActor\tActress\t\tDirector\tYear of release");
            System.out.println("--------------------------------------------------------------------------");
            try {
                while(rs.next()){
                    System.out.print(rs.getString(1)+"|\t");
                    System.out.print(rs.getString(2)+"|\t");
                    System.out.print(rs.getString(3)+"|\t");
                    System.out.print(rs.getString(4)+"|\t");
                    System.out.println(rs.getInt(5));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }
    public static void main(String[] args) {
        try{
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:db/mydb.db");
            System.out.println("connected");
            String sql = "select * from movies";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            printData(rs);

            System.out.println("-------------------------------------------");
            System.out.print("Enter an actor name : ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            sql = "select * from movies where actor = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            printData(rs);
            sc.close();



            
           

        
        }
        catch(Exception e){
            System.out.println("Table already created");

        }
    }
}

    

