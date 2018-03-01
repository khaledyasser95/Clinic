import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import info.clearthought.layout.*;
/*
 * Created by JFormDesigner on Thu Mar 01 18:10:31 EET 2018
 */



/**
 * @author Nono Koko
 */
public class visit {
    String real_id;
    public visit(String id) {
        real_id=id;
        initComponents();
        getdate();
    }
    private void getdate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date_txt.setText(dateFormat.format(date));
       // System.out.println(dateFormat.format(date));
    }

    private void SaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        String []Values={real_id,class_txt.getText(),date_txt.getText(),complain_txt.getText(),symptoms_txt.getText(),signs_txt.getText(),invest_txt.getText(),Diog_txt.getText(),treat_txt.getText(),pic.getText()};
        Patient_Visit Visit = new Patient_Visit(Values);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nono Koko
        tab = new JPanel();
        label12 = new JLabel();
        name_txt = new JTextField();
        label2 = new JLabel();
        class_txt = new JTextField();
        label3 = new JLabel();
        date_txt = new JTextField();
        label4 = new JLabel();
        complain_txt = new JTextField();
        label5 = new JLabel();
        symptoms_txt = new JTextField();
        label6 = new JLabel();
        signs_txt = new JTextField();
        label7 = new JLabel();
        invest_txt = new JTextField();
        label8 = new JLabel();
        Diog_txt = new JTextField();
        label9 = new JLabel();
        treat_txt = new JTextField();
        label10 = new JLabel();
        pic = new JLabel();
        Save = new JButton();

        //======== tab ========
        {
            tab.setPreferredSize(new Dimension(700, 578));

            // JFormDesigner evaluation mark
            tab.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), tab.getBorder())); tab.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            tab.setLayout(new TableLayout(new double[][] {
                {185, 479},
                {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}}));
            ((TableLayout)tab.getLayout()).setHGap(5);
            ((TableLayout)tab.getLayout()).setVGap(5);

            //---- label12 ----
            label12.setText("Name");
            label12.setHorizontalAlignment(SwingConstants.CENTER);
            label12.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label12, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- name_txt ----
            name_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            name_txt.setEditable(false);
            tab.add(name_txt, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label2 ----
            label2.setText("Class");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label2, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- class_txt ----
            class_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            class_txt.setEditable(false);
            tab.add(class_txt, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label3 ----
            label3.setText("Date_visit ");
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label3, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- date_txt ----
            date_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            date_txt.setEditable(false);
            tab.add(date_txt, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label4 ----
            label4.setText("complain ");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label4, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- complain_txt ----
            complain_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(complain_txt, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label5 ----
            label5.setText("symptoms ");
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label5, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- symptoms_txt ----
            symptoms_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(symptoms_txt, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label6 ----
            label6.setText("signs ");
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label6, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- signs_txt ----
            signs_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(signs_txt, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label7 ----
            label7.setText("investigation ");
            label7.setHorizontalAlignment(SwingConstants.CENTER);
            label7.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label7, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- invest_txt ----
            invest_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(invest_txt, new TableLayoutConstraints(1, 6, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label8 ----
            label8.setText("Diognosis ");
            label8.setHorizontalAlignment(SwingConstants.CENTER);
            label8.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label8, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- Diog_txt ----
            Diog_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(Diog_txt, new TableLayoutConstraints(1, 7, 1, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label9 ----
            label9.setText("treatment ");
            label9.setHorizontalAlignment(SwingConstants.CENTER);
            label9.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label9, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- treat_txt ----
            treat_txt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            tab.add(treat_txt, new TableLayoutConstraints(1, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label10 ----
            label10.setText("picture ");
            label10.setHorizontalAlignment(SwingConstants.CENTER);
            label10.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tab.add(label10, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- pic ----
            pic.setText("PI");
            pic.setPreferredSize(new Dimension(12, 50));
            tab.add(pic, new TableLayoutConstraints(1, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- Save ----
            Save.setText("SAVE");
            Save.setFont(new Font("Segoe UI", Font.BOLD, 20));
            Save.addActionListener(e -> SaveActionPerformed(e));
            tab.add(Save, new TableLayoutConstraints(1, 10, 1, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nono Koko
    public JPanel tab;
    private JLabel label12;
    public JTextField name_txt;
    private JLabel label2;
    public JTextField class_txt;
    private JLabel label3;
    private JTextField date_txt;
    private JLabel label4;
    private JTextField complain_txt;
    private JLabel label5;
    private JTextField symptoms_txt;
    private JLabel label6;
    private JTextField signs_txt;
    private JLabel label7;
    private JTextField invest_txt;
    private JLabel label8;
    private JTextField Diog_txt;
    private JLabel label9;
    private JTextField treat_txt;
    private JLabel label10;
    private JLabel pic;
    private JButton Save;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
