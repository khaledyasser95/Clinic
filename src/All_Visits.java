import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class All_Visits extends JPanel {

    private int j;
    private Vector Row,col;
    JScrollPane sp = new JScrollPane();
    GroupLayout l = new GroupLayout(this);
    private GroupLayout.ParallelGroup parallel;
    private GroupLayout.SequentialGroup sequential;
    private Connection conn = null;

    Statement stmt = null;
    public All_Visits() {
        conn = JConnection.ConnectDB();
        load_DB();
    }
    public All_Visits(String id) {
        conn = JConnection.ConnectDB();
        load_DB2(id);
    }
    public void load_DB2(String id)
    {
        try{
            JFrame f = new JFrame("GroupPanel");
            JPanel panel = new JPanel();
            JScrollPane scrollPane = new JScrollPane(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            stmt = conn.createStatement();
            String sql = "SELECT * FROM visit where real_id =' "+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            Vector columns = new Vector(columnCount);
            for(int i=1; i<=columnCount; i++)
                columns.add(md.getColumnName(i));
            Vector data = new Vector();

            Vector row;
            while (rs.next()) {
                row = new Vector(columnCount);
                for(int i=1; i<=columnCount; i++)
                {
                    row.add(rs.getString(i));
                }

                data.add(row);

                panel.add(new All_Visits(row,columns));
            }
            panel.add(Box.createVerticalGlue());
            f.getContentPane().add(scrollPane);
            f.pack();
            f.setSize(1000,1000);
            f.setLocationRelativeTo(null);
            f.setVisible(true);


        }catch (Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }

    public void load_DB()
    {
        try{
            JFrame f = new JFrame("GroupPanel");
            JPanel panel = new JPanel();
            JScrollPane scrollPane = new JScrollPane(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            stmt = conn.createStatement();
            String sql = "SELECT * FROM visit ";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            Vector columns = new Vector(columnCount);
            for(int i=1; i<=columnCount; i++)
                columns.add(md.getColumnName(i));
            Vector data = new Vector();

            Vector row;
            while (rs.next()) {
                row = new Vector(columnCount);
                for(int i=1; i<=columnCount; i++)
                {
                    row.add(rs.getString(i));
                }

                data.add(row);

                panel.add(new All_Visits(row,columns));
            }
            panel.add(Box.createVerticalGlue());
            f.getContentPane().add(scrollPane);
            f.pack();
            f.setSize(1000,1000);
            f.setLocationRelativeTo(null);
            f.setVisible(true);


        }catch (Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }
    private void add(Vector data,Vector columns) {
        JLabel label = new JLabel(columns.get(j).toString(), JLabel.RIGHT);
        JTextField field = new JTextField(String.valueOf(data.get(j).toString()));
        field.setEditable(false);
        label.setLabelFor(field);
        parallel.addGroup(l.createSequentialGroup().
                addComponent(label).addComponent(field));
        sequential.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(label).addComponent(field));
        j++;
    }

    public  All_Visits(Vector data,Vector columns) {
        this.setBorder(BorderFactory.createTitledBorder("Panel " ));
        this.setLayout(l);
        l.setAutoCreateGaps(true);
        l.setAutoCreateContainerGaps(true);
        parallel = l.createParallelGroup();
        l.setHorizontalGroup(l.createSequentialGroup().addGroup(parallel));
        sequential = l.createSequentialGroup();
        l.setVerticalGroup(sequential);
        for (int i = 0; i < columns.size(); i++) {
            add(data,columns);
        }
        sp.setToolTipText("test");
        sp.add(this);
    }



}
