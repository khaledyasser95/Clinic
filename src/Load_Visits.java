import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import info.clearthought.layout.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
/*
 * Created by JFormDesigner on Thu Mar 01 15:56:25 EET 2018
 */



/**
 * @author Nono Koko
 */
public class Load_Visits extends JFrame implements ActionListener {
    private Connection conn = null;

    Statement stmt = null;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;

    private DefaultTableModel tableModel;
    public Load_Visits() {
        conn = JConnection.ConnectDB();
        initComponents();
        view2();
    }
    public void view() {
        try{
            conn = JConnection.ConnectDB();
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

    public void view2() {
        try{
            conn = JConnection.ConnectDB();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM visit ";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            JPanel p = new JPanel();



/*
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

*/

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
           // selectedData();
        } else if (menu == menuItemRemove) {
           // visit();
        } else if (menu == menuItemRemoveAll) {
           // removeAllRows();
        }
    }

    private void HideActionPerformed(ActionEvent e) {
        // TODO add your code here

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nono Koko
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(1510, 900));

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new TableLayout(new double[][] {
                    {TableLayout.FILL},
                    {TableLayout.MINIMUM, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                ((TableLayout)panel1.getLayout()).setHGap(5);
                ((TableLayout)panel1.getLayout()).setVGap(5);

                //======== scrollPane2 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(2, 0));
                    table1.setFont(new Font("Segoe UI", Font.BOLD, 18));
                    table1.setRowHeight(30);
                    table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane2.setViewportView(table1);
                }
                panel1.add(scrollPane2, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            }
            scrollPane1.setViewportView(panel1);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nono Koko
    public JScrollPane scrollPane1;
    private JPanel panel1;
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
