import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Tue Feb 13 21:48:16 EET 2018
 */


/**
 * @author kh sa
 */
public class Menu extends JPanel {


    public Menu() {
        initComponents();
        ImageIcon imgThisImg = new ImageIcon("src/1.jpg");
        picy.setIcon(imgThisImg);
    }

    public static void main(String[] args) {
        //1. Create the frame.
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().Panel);
        // frame.setSize(1000,1150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void addnewpatient_btnActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame frame = new JFrame("AddPatient");
        frame.setContentPane(new Add_Patient().tabbedPane1);
        // frame.setSize(1000,1150);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void search_btnActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame frame = new JFrame("Search");
        frame.setContentPane(new Search().panel1);
        // frame.setSize(1000,1150);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void operation_btnActionPerformed(ActionEvent e) {
        // TODO add your code here
       /* JFrame frame = new JFrame("Load_Visits");
        frame.setContentPane(new Load_Visits().scrollPane1);
        // frame.setSize(1000,1150);
        frame.pack();
        frame.setResizable(false);
*/
        //Panels obj_panel = new Panels();
        All_Visits visit = new All_Visits();
        //visit.display();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nono Koko
        Panel = new JPanel();
        label1 = new JLabel();
        picy = new JLabel();
        addnewpatient_btn = new JButton();
        search_btn = new JButton();
        operation_btn = new JButton();
        edit_btn = new JButton();
        close_btn = new JButton();

        //======== Panel ========
        {
            Panel.setMinimumSize(new Dimension(888, 1000));
            Panel.setBackground(Color.white);

            // JFormDesigner evaluation mark
            Panel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), Panel.getBorder())); Panel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            Panel.setLayout(new TableLayout(new double[][] {
                {TableLayout.FILL, TableLayout.FILL},
                {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}}));
            ((TableLayout)Panel.getLayout()).setHGap(5);
            ((TableLayout)Panel.getLayout()).setVGap(5);

            //---- label1 ----
            label1.setText("DR MAGED");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Arial", Font.PLAIN, 18));
            Panel.add(label1, new TableLayoutConstraints(0, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- picy ----
            picy.setHorizontalAlignment(SwingConstants.CENTER);
            Panel.add(picy, new TableLayoutConstraints(0, 1, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- addnewpatient_btn ----
            addnewpatient_btn.setText("ADD NEW PATIENT");
            addnewpatient_btn.setFont(new Font("Arial", Font.BOLD, 20));
            addnewpatient_btn.addActionListener(e -> addnewpatient_btnActionPerformed(e));
            Panel.add(addnewpatient_btn, new TableLayoutConstraints(0, 7, 1, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- search_btn ----
            search_btn.setText("SEARCH FOR A PATIENT");
            search_btn.setFont(new Font("Arial", Font.BOLD, 20));
            search_btn.addActionListener(e -> search_btnActionPerformed(e));
            Panel.add(search_btn, new TableLayoutConstraints(0, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- operation_btn ----
            operation_btn.setText("OPERATION FOR THE PATIENT");
            operation_btn.setFont(new Font("Arial", Font.BOLD, 20));
            operation_btn.addActionListener(e -> operation_btnActionPerformed(e));
            Panel.add(operation_btn, new TableLayoutConstraints(0, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- edit_btn ----
            edit_btn.setText("EDIT PATIENT INFORMATION");
            edit_btn.setFont(new Font("Arial", Font.BOLD, 20));
            Panel.add(edit_btn, new TableLayoutConstraints(0, 10, 1, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- close_btn ----
            close_btn.setText("CLOSE");
            close_btn.setFont(new Font("Arial", Font.BOLD, 20));
            Panel.add(close_btn, new TableLayoutConstraints(0, 11, 1, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nono Koko
    private JPanel Panel;
    private JLabel label1;
    private JLabel picy;
    private JButton addnewpatient_btn;
    private JButton search_btn;
    private JButton operation_btn;
    private JButton edit_btn;
    private JButton close_btn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
