import java.sql.*;
import java.util.*;

// import javax.swing.GroupLayout.Alignment;
public class InsertDataIntoMoviesTable {
    public static void main(String[] args) {
        try{
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:db/mydb.db");
            System.out.println("connected");
            String sql = "insert into movies values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            for(int i=0;i<3;i++){
                String name,actor,actress,director;
                int yor;
               
                System.out.print((i+1)+" name : ");name = sc.nextLine();
                System.out.print((i+1)+" actor : ");actor = sc.nextLine();
                System.out.print((i+1)+" actress : ");actress = sc.nextLine();
                System.out.print((i+1)+" director : ");director = sc.nextLine();
                System.out.print((i+1)+" yor : ");yor = sc.nextInt();
                sc.nextLine();

                ps.setString(1, name);
                ps.setString(2, actor);
                ps.setString(3, actress);
                ps.setString(4, director);
                ps.setInt(5, yor);

                ps.executeUpdate();
                // sc.close();

            }
            sc.close();
            
           

            


        }
        catch(Exception e){
            System.out.println("Table already created");

        }
    }
}

    

