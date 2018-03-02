import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class Search_Patient {
    String First_Name;
    String Mid_Name;
    String Last_Name;
    private Connection conn = null;
    Statement stmt = null;
    public Search_Patient(String first_Name, String mid_Name, String last_Name) {
        conn = JConnection.ConnectDB();
        First_Name = first_Name;
        Mid_Name = mid_Name;
        Last_Name = last_Name;

       // selectDB(First_Name,Mid_Name,Last_Name);
    }
    void selectDB(String fname,String midname, String lname)
    {
        try
        {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM patientinfo where First_Name = '"+fname+"'AND  Mid_Name ='"+midname+"'AND Last_Name ='"+lname+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Hello");
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("ID");
                String f_name  = rs.getString("First_Name");
                String M_name  = rs.getString("Mid_Name");
                String L_name  = rs.getString("Last_Name");
                //Todo COMPLETE DATABASE

                //Display values
                System.out.println("ID: " + id);
                System.out.println("Fname: " + f_name);
                System.out.println("Mname: " + M_name);
                System.out.println("Lname: " + L_name);

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
