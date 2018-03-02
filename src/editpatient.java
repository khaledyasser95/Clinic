import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class editpatient {
    String ID:
    String Real_id;
    String Class;
    String First_Name;
    String Mid_Name;
    String Last_Name;
    String Birthdate;
    String Age;
    String Address;
    String Telephone;
    String mobile_1;
    String mobile_2;
    String Email;
    String Mother_Name;
    String Birth_Location;
    String Way_Of_Birth;
    String Weight;
    String Height;
    String Head_Circum;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public editpatient(String[]coloumnvalues) {
        conn = JConnection.ConnectDB();
        ID=coloumnvalues[0];
        Real_id = coloumnvalues[1];
        Class = coloumnvalues[2];

        insertstatic_info( Real_id, Mother_Name,Email);
        insert(Real_id, Class, First_Name, Mid_Name, Last_Name, Birthdate, Age, Address, Birth_Location, Way_Of_Birth, Weight, Height, Head_Circum);
        insertphone( Real_id,Telephone,this.mobile_1,this.mobile_2);



    }


    private void insert(String[]coloumnvalues) {
        try {
            pstmt = conn.prepareStatement("INSERT  into patientinfo(real_id,class,First_Name, Mid_Name, Last_Name, Birthdate, Age, Address, Birth_Location, Way_Of_Birth, Weight, Height, Head_Circum) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, Read_id);
            pstmt.setString(2, Class);
            pstmt.setString(3, First_Name);
            pstmt.setString(4, Mid_Name);
            pstmt.setString(5, Last_Name);
            pstmt.setString(6, Birthdate);
            pstmt.setString(7, Age);
            pstmt.setString(8, Address);
            pstmt.setString(9, Birth_Location);
            pstmt.setString(10, Way_Of_Birth);
            pstmt.setString(11, Weight);
            pstmt.setString(12, Height);
            pstmt.setString(13, Head_Circum);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Data Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Data not Saved");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }


    }
    private void insertphone(String Real_id,String home_number,String mobile1,String mobile2)
    {
        try {
            pstmt = conn.prepareStatement("INSERT  into telephone(real_id,Home_number, mobile_1, mobile_2) VALUES (?,?,?,?)");
            pstmt.setString(1, Real_id);
            pstmt.setString(2, home_number);
            pstmt.setString(3, mobile1);
            pstmt.setString(4, mobile2);
            int i = pstmt.executeUpdate();
            if (i > 0) {
               // JOptionPane.showMessageDialog(null, "Data Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Telephone Data not Saved");
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void insertstatic_info(String Read_id,String mother_name,String email)
    {
        try {
            pstmt = conn.prepareStatement("INSERT  into static_info(real_id,Mother_name, email) VALUES (?,?,?)");
            pstmt.setString(1, Read_id);
            pstmt.setString(2, mother_name);
            pstmt.setString(3, email);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                // JOptionPane.showMessageDialog(null, "Data Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Telephone Data not Saved");
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
