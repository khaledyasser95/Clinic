import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Patient_Visit {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public Patient_Visit(String [] values) {
        conn = JConnection.ConnectDB();
        insert(values);
    }

    private void insert(String [] values) {
        try {
            pstmt = conn.prepareStatement("INSERT  into visit(real_id ,class,Date_visit , complain , symptoms , signs , investigation , Diognosis , treatment , picture ) VALUES (?,?,?,?,?,?,?,?,?,?)");
            for(int i=0;i<10;i++)
            {
                pstmt.setString(i+1, values[i]);
            }

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
}
