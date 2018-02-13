import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Icy on 2/13/2018.
 */
public class JConnection {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/clinic", "root", "");
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
