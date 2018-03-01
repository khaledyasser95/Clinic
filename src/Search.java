import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import info.clearthought.layout.*;
/*
 * Created by JFormDesigner on Sat Feb 17 21:19:40 EET 2018
 */



/**
 * @author kh sa
 */
public class Search extends JPanel implements ActionListener  {
    private Connection conn = null;
    String First_Name;
    String Mid_Name;
    String Last_Name;
    Statement stmt = null;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;

    private DefaultTableModel tableModel;

    public Search() {
        initComponents();
        conn = JConnection.ConnectDB();


    }


    public void view2(String fname,String midname, String lname) {
        try{
            conn = JConnection.ConnectDB();
            stmt = conn.createStatement();
            //String sql = "SELECT * FROM patientinfo where First_Name = '"+fname+"'OR  Mid_Name ='"+midname+"'OR Last_Name ='"+lname+"'";
            String sql = "SELECT p.*,p1.Mother_name,p1.email,p2.Home_number,p2.mobile_1,p2.mobile_2 FROM patientinfo p,static_info p1,telephone p2 where (p.First_Name = '"+fname+"'OR  p.Mid_Name ='"+midname+"'OR p.Last_Name ='"+lname+"') AND p.real_id=p1.real_id AND p.real_id=p2.real_id ";
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
                String x=rs.getString("real_id");
                //Debugging
                System.out.println("First Name = " + rs.getString("First_Name"));
                System.out.println("Last Name = " + rs.getString("Last_Name"));
            }


            //Display in JTable
            tableModel = new DefaultTableModel(data, columns);
            table1.setModel(tableModel);



			// constructs the popup menu
			popupMenu = new JPopupMenu();
			menuItemAdd = new JMenuItem("Update Selected Data");
			menuItemRemove = new JMenuItem("Remove Current Row");
			menuItemRemoveAll = new JMenuItem("Remove All Rows");

			menuItemAdd.addActionListener(this);
			menuItemRemove.addActionListener(this);
			menuItemRemoveAll.addActionListener(this);

			popupMenu.add(menuItemAdd);
			popupMenu.add(menuItemRemove);
			popupMenu.add(menuItemRemoveAll);

			// sets the popup menu for the table
			table1.setComponentPopupMenu(popupMenu);
			table1.addMouseListener(new TableMouseListener(table1));
			setSize(640, 150);


        }catch (Exception e1)
        {
            System.out.println(e1.getMessage());
        }

    }
    public void view() {
        try{
            conn = JConnection.ConnectDB();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM patientinfo ";
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


            }


            //Display in JTable
            tableModel = new DefaultTableModel(data, columns);
            table1.setModel(tableModel);



            // constructs the popup menu
            popupMenu = new JPopupMenu();
            menuItemAdd = new JMenuItem("Update Selected Data");
            menuItemRemove = new JMenuItem("Remove Current Row");
            menuItemRemoveAll = new JMenuItem("Remove All Rows");

            menuItemAdd.addActionListener(this);
            menuItemRemove.addActionListener(this);
            menuItemRemoveAll.addActionListener(this);

            popupMenu.add(menuItemAdd);
            popupMenu.add(menuItemRemove);
            popupMenu.add(menuItemRemoveAll);

            // sets the popup menu for the table
            table1.setComponentPopupMenu(popupMenu);
            table1.addMouseListener(new TableMouseListener(table1));
            setSize(640, 150);


        }catch (Exception e1)
        {
            System.out.println(e1.getMessage());
        }

    }
    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) {
            selectedData();
        } else if (menu == menuItemRemove) {
            visit();
        } else if (menu == menuItemRemoveAll) {
            removeAllRows();
        }
    }

    private void selectedData() {
        tableModel.getDataVector().elementAt(table1.getSelectedRow());
        int columnlength= tableModel.getColumnCount();
        ArrayList<String> coloumnnames = new ArrayList();
        //  for (int i=0;i<columnlength;i++)
        //     coloumnnames.add(tableModel.getColumnName(i));
        System.out.println(tableModel.getDataVector().elementAt(table1.getSelectedRow()));
        //String[] columnvalues =tableModel.getDataVector().elementAt(table1.getSelectedRow()).toString().replace("[","").replace("]","").trim().split(",");
        String[] columnvalues =tableModel.getDataVector().elementAt(table1.getSelectedRow()).toString().trim().replace("[","").replace("]","").split(",");
        System.out.println(columnvalues);
        editpatient edit = new editpatient(columnvalues);
    }
    private void visit()
    {
        tableModel.getDataVector().elementAt(table1.getSelectedRow());
        int columnlength= tableModel.getColumnCount();
        ArrayList<String> coloumnnames = new ArrayList();
        //  for (int i=0;i<columnlength;i++)
        //     coloumnnames.add(tableModel.getColumnName(i));
        System.out.println(tableModel.getDataVector().elementAt(table1.getSelectedRow()));
        //String[] columnvalues =tableModel.getDataVector().elementAt(table1.getSelectedRow()).toString().replace("[","").replace("]","").trim().split(",");
        String[] columnvalues =tableModel.getDataVector().elementAt(table1.getSelectedRow()).toString().trim().replace("[","").replace("]","").split(",");
        System.out.println(columnvalues);
        visit vis = new visit(columnvalues[1]);
        JFrame frame = new JFrame("visit");

        frame.setContentPane(vis.tab);
        // frame.setSize(1000,1150);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        vis.name_txt.setText(columnvalues[3]+columnvalues[4]+columnvalues[5]);
        vis.class_txt.setText(columnvalues[2]);
    }

    private void removeCurrentRow() {
        int selectedRow = table1.getSelectedRow();
        tableModel.removeRow(selectedRow);
    }

    private void removeAllRows() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
    }



    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void search_btnActionPerformed(ActionEvent e) {
        // TODO add your code here

        String[] name = search_txt.getText().split("\\s+");
        System.out.println("Length: "+name.length);
        if(!name[0].equals(""))
        {
            First_Name = name[0];
            if (name.length > 1) {
                if (name[1].equals(""))
                    Mid_Name = name[1] = "";
                else
                    Mid_Name = name[1];
                if (name[2] == null)
                    Last_Name = name[2] = "";
                else
                    Last_Name = name[2];

            }
            else
            {
                Mid_Name="";
                Last_Name="";
            }

            view2(First_Name, Mid_Name, Last_Name);
        }else view();


    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nono Koko
        panel1 = new JPanel();
        search_txt = new JTextField();
        search_btn = new JButton();
        JScrollPane scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(1892, 100));
            panel1.setPreferredSize(new Dimension(1892, 772));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new TableLayout(new double[][] {
                {371, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                {32, TableLayout.FILL}}));
            ((TableLayout)panel1.getLayout()).setHGap(5);
            ((TableLayout)panel1.getLayout()).setVGap(5);

            //---- search_txt ----
            search_txt.setFont(new Font("Arial", Font.BOLD, 30));
            panel1.add(search_txt, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- search_btn ----
            search_btn.setText("Search");
            search_btn.addActionListener(e -> search_btnActionPerformed(e));
            panel1.add(search_btn, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //======== scrollPane1 ========
            {
                scrollPane1.setAutoscrolls(true);
                scrollPane1.setMinimumSize(new Dimension(10, 10));

                //---- table1 ----
                table1.setModel(new DefaultTableModel());
                table1.setFont(new Font("Arial", Font.PLAIN, 16));
                table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table1.setRowHeight(50);
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, new TableLayoutConstraints(0, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nono Koko
    public JPanel panel1;
    private JTextField search_txt;
    private JButton search_btn;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
