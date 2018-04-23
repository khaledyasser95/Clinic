import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class editpatient {
    String ID;
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
        for(int i=0;i<coloumnvalues.length;i++)
        {
            if (coloumnvalues[i].charAt(0) == ' ')
                coloumnvalues[i] = coloumnvalues[i].replaceFirst(" ","");
        }
        insertstatic_info(coloumnvalues);
        insert(coloumnvalues);
        insertphone(coloumnvalues);



    }


    private void insert(String[]coloumnvalues) {
        try {
            pstmt = conn.prepareStatement("UPDATE  patientinfo SET real_id='"+coloumnvalues[1]+"',class='"+coloumnvalues[2]+"',First_Name='"+coloumnvalues[3]+"',Mid_Name='"+coloumnvalues[4]+"',Last_Name='"+coloumnvalues[5]+"',Birthdate='"+coloumnvalues[6]+"',Age='"+coloumnvalues[7]+"',Address='"+coloumnvalues[8]+"',Birth_Location='"+coloumnvalues[9]+"',Way_Of_Birth='"+coloumnvalues[10]+"',Weight='"+coloumnvalues[11]+"',Height='"+coloumnvalues[12]+"',Head_Circum='"+coloumnvalues[13]+"' WHERE ID='"+coloumnvalues[0]+"'");

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
    private void insertphone(String[]coloumnvalues)
    {
        try {

            pstmt = conn.prepareStatement("UPDATE  telephone SET real_id='"+coloumnvalues[1]+"',Home_number='"+coloumnvalues[17]+"',mobile_1='"+coloumnvalues[18]+"',mobile_2='"+coloumnvalues[19]+"' WHERE real_id='"+coloumnvalues[1]+"'");
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

    private void insertstatic_info(String[]coloumnvalues)
    {
        try {

            pstmt = conn.prepareStatement("UPDATE  static_info SET Mother_name='"+coloumnvalues[15]+"',email='"+coloumnvalues[16]+"' WHERE real_id='"+coloumnvalues[1]+"'");


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
