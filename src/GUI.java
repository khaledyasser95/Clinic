import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/*
 * Created by JFormDesigner on Tue Feb 13 16:55:25 EET 2018
 */


/**
 * @author kh sa
 */
public class GUI extends JFrame {
    //public JTabbedPane tabbedPane1;
    Connection conn = null;
    PreparedStatement pstmt = null;
    private JPanel panel1;
    private JLabel name3;
    private JTextField name_txt2;
    private JLabel email;
    private JTextField email_txt;
    private JLabel birthdate3;
    private JTextField birthdate_txt3;
    private JLabel age3;
    private JTextField age_txt3;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - kh sa
    public JTabbedPane tabbedPane1;
    private JLabel address3;
    private JTextField address_txt3;
    private JLabel homenumber3;
    private JTextField homenumber_txt3;
    private JLabel mobile5;
    private JTextField mobile1_txt3;
    private JLabel mobile6;
    private JTextField mobile2_txt3;
    private JLabel mothername3;
    private JTextField mothername_txt3;
    private JLabel birthlocation;
    private JTextField birthlocation_txt;
    private JLabel wayofbirth3;
    private JComboBox<String> wayofbith_cmb;
    private JLabel weightatbirth3;
    private JTextField weightatbirth_txt3;
    private JLabel heightatbirth3;
    private JTextField heightatbirth_txt3;
    private JLabel headcircum3;
    private JTextField headcircum_txt3;
    private JButton save_btn3;
    private JPanel panel2;
    private JLabel label1;
    private JLabel picy;
    private JButton AddPatient_btn;
    private JButton searchforpatient_btn;
    private JButton operation_btn;
    private JButton editpatien_btn;
    private JButton close_btn;
    public GUI() {
        initComponents();
        conn = JConnection.ConnectDB();
        getDate();
        ImageIcon imgThisImg = new ImageIcon("C:\\Users\\Icy\\Desktop\\1.jpg");
        picy.setIcon(imgThisImg);

    }

    public void getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String time = String.valueOf(dtf.format(localDate));
        birthdate_txt3.setText("Day/Month/Year");
    }

    private void calculateAge() {
        String[] age = birthdate_txt3.getText().split("/");
        int day = Integer.valueOf(age[0]);
        int month = Integer.valueOf(age[1]);
        int year = Integer.valueOf(age[2]);
        LocalDate start = LocalDate.of(year, month, day);
        LocalDate end = LocalDate.now();
        long years = ChronoUnit.YEARS.between(start, end);
        age_txt3.setText(String.valueOf(years));

    }

    private void insert() {

        String[] name = name_txt2.getText().split("\\s+");
        if (name.length != 2)
            JOptionPane.showMessageDialog(null, "ERROR IN LENGTH");
        String Fname = name[0];
        String Mname = name[1];
        String Lname = name[2];
        String Birthdate = birthdate_txt3.getText();
        String Age = age_txt3.getText();
        String Address = address_txt3.getText();
        String Telephone = homenumber_txt3.getText();
        String Email = email_txt.getText();
        String Mothername = mothername_txt3.getText();
        String Birthlocation = birthlocation_txt.getText();
        String Wayofborth = wayofbith_cmb.getSelectedItem().toString();
        String weight = weightatbirth_txt3.getText();
        String height = heightatbirth_txt3.getText();
        String Circum = headcircum_txt3.getText();
        try {

            pstmt = conn.prepareStatement("INSERT  into patientinfo(First_Name, Mid_Name, Last_Name, Birthdate, Age, Address, Telephone, Email, Mother_Name, Birth_Location, Way_Of_Birth, Weight, Height, Head_Circum) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, Fname);
            pstmt.setString(2, Mname);
            pstmt.setString(3, Lname);
            pstmt.setString(4, Birthdate);
            pstmt.setString(5, Age);
            pstmt.setString(6, Address);
            pstmt.setString(7, Telephone);
            pstmt.setString(8, Email);
            pstmt.setString(9, Mothername);
            pstmt.setString(10, Birthlocation);
            pstmt.setString(11, Wayofborth);
            pstmt.setString(12, weight);
            pstmt.setString(13, height);
            pstmt.setString(14, Circum);
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

    private void save_btn3MouseClicked(MouseEvent e) {
        // TODO add your code here
        insert();

    }

    private void age_txt3MouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            calculateAge();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Please Enter correct date format", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void birthdate_txt3MouseClicked(MouseEvent e) {
        // TODO add your code here
        birthdate_txt3.selectAll();
    }

    private void AddPatient_btnActionPerformed(ActionEvent e) {
        // TODO add your code here


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - kh sa
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        name3 = new JLabel();
        name_txt2 = new JTextField();
        email = new JLabel();
        email_txt = new JTextField();
        birthdate3 = new JLabel();
        birthdate_txt3 = new JTextField();
        age3 = new JLabel();
        age_txt3 = new JTextField();
        address3 = new JLabel();
        address_txt3 = new JTextField();
        homenumber3 = new JLabel();
        homenumber_txt3 = new JTextField();
        mobile5 = new JLabel();
        mobile1_txt3 = new JTextField();
        mobile6 = new JLabel();
        mobile2_txt3 = new JTextField();
        mothername3 = new JLabel();
        mothername_txt3 = new JTextField();
        birthlocation = new JLabel();
        birthlocation_txt = new JTextField();
        wayofbirth3 = new JLabel();
        wayofbith_cmb = new JComboBox<>();
        weightatbirth3 = new JLabel();
        weightatbirth_txt3 = new JTextField();
        heightatbirth3 = new JLabel();
        heightatbirth_txt3 = new JTextField();
        headcircum3 = new JLabel();
        headcircum_txt3 = new JTextField();
        save_btn3 = new JButton();
        panel2 = new JPanel();
        label1 = new JLabel();
        picy = new JLabel();
        AddPatient_btn = new JButton();
        searchforpatient_btn = new JButton();
        operation_btn = new JButton();
        editpatien_btn = new JButton();
        close_btn = new JButton();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setMinimumSize(new Dimension(700, 700));
            tabbedPane1.setPreferredSize(new Dimension(700, 700));
            tabbedPane1.setAutoscrolls(true);
            tabbedPane1.setOpaque(true);
            tabbedPane1.setBackground(Color.lightGray);

            //======== panel1 ========
            {
                panel1.setMinimumSize(new Dimension(700, 700));
                panel1.setForeground(new Color(0, 153, 255));
                panel1.setAutoscrolls(true);
                panel1.setBackground(new Color(51, 51, 51));
                panel1.setPreferredSize(new Dimension(700, 700));

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), panel1.getBorder()));
                panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                    }
                });

                panel1.setLayout(new TableLayout(new double[][]{
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}}));
                ((TableLayout) panel1.getLayout()).setHGap(5);
                ((TableLayout) panel1.getLayout()).setVGap(5);

                //---- name3 ----
                name3.setText("Name");
                name3.setFont(new Font("Arial", Font.PLAIN, 25));
                name3.setBackground(new Color(255, 102, 102));
                name3.setForeground(Color.white);
                name3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(name3, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- name_txt2 ----
                name_txt2.setMaximumSize(new Dimension(28, 57));
                name_txt2.setMinimumSize(new Dimension(79, 41));
                name_txt2.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(name_txt2, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- email ----
                email.setText("Email");
                email.setFont(new Font("Arial", Font.PLAIN, 25));
                email.setForeground(Color.white);
                panel1.add(email, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- email_txt ----
                email_txt.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(email_txt, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- birthdate3 ----
                birthdate3.setText("Birthdate");
                birthdate3.setMinimumSize(new Dimension(79, 41));
                birthdate3.setFont(new Font("Arial", Font.PLAIN, 25));
                birthdate3.setForeground(Color.white);
                birthdate3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(birthdate3, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- birthdate_txt3 ----
                birthdate_txt3.setMaximumSize(new Dimension(28, 57));
                birthdate_txt3.setMinimumSize(new Dimension(79, 41));
                birthdate_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                birthdate_txt3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        birthdate_txt3MouseClicked(e);
                    }
                });
                panel1.add(birthdate_txt3, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- age3 ----
                age3.setText("Age");
                age3.setMinimumSize(new Dimension(79, 41));
                age3.setFont(new Font("Arial", Font.PLAIN, 25));
                age3.setForeground(Color.white);
                age3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(age3, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- age_txt3 ----
                age_txt3.setMaximumSize(new Dimension(28, 57));
                age_txt3.setMinimumSize(new Dimension(79, 41));
                age_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                age_txt3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        age_txt3MouseClicked(e);
                    }
                });
                panel1.add(age_txt3, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- address3 ----
                address3.setText("Address");
                address3.setMinimumSize(new Dimension(79, 41));
                address3.setFont(new Font("Arial", Font.PLAIN, 25));
                address3.setForeground(Color.white);
                address3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(address3, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- address_txt3 ----
                address_txt3.setMaximumSize(new Dimension(28, 57));
                address_txt3.setMinimumSize(new Dimension(79, 41));
                address_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(address_txt3, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- homenumber3 ----
                homenumber3.setText("Home Number");
                homenumber3.setMinimumSize(new Dimension(79, 41));
                homenumber3.setFont(new Font("Arial", Font.PLAIN, 25));
                homenumber3.setForeground(Color.white);
                homenumber3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(homenumber3, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- homenumber_txt3 ----
                homenumber_txt3.setMaximumSize(new Dimension(28, 57));
                homenumber_txt3.setMinimumSize(new Dimension(79, 41));
                homenumber_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(homenumber_txt3, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mobile5 ----
                mobile5.setText("Mobile #1");
                mobile5.setMinimumSize(new Dimension(79, 41));
                mobile5.setFont(new Font("Arial", Font.PLAIN, 25));
                mobile5.setForeground(Color.white);
                mobile5.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(mobile5, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mobile1_txt3 ----
                mobile1_txt3.setMaximumSize(new Dimension(28, 57));
                mobile1_txt3.setMinimumSize(new Dimension(79, 41));
                mobile1_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(mobile1_txt3, new TableLayoutConstraints(1, 6, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mobile6 ----
                mobile6.setText("Mobile #2");
                mobile6.setMinimumSize(new Dimension(79, 41));
                mobile6.setFont(new Font("Arial", Font.PLAIN, 25));
                mobile6.setForeground(Color.white);
                mobile6.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(mobile6, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mobile2_txt3 ----
                mobile2_txt3.setMaximumSize(new Dimension(28, 57));
                mobile2_txt3.setMinimumSize(new Dimension(79, 41));
                mobile2_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(mobile2_txt3, new TableLayoutConstraints(1, 7, 1, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mothername3 ----
                mothername3.setText("Mother Name");
                mothername3.setMinimumSize(new Dimension(79, 41));
                mothername3.setFont(new Font("Arial", Font.PLAIN, 25));
                mothername3.setForeground(Color.white);
                mothername3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(mothername3, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- mothername_txt3 ----
                mothername_txt3.setMaximumSize(new Dimension(28, 57));
                mothername_txt3.setMinimumSize(new Dimension(79, 41));
                mothername_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(mothername_txt3, new TableLayoutConstraints(1, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- birthlocation ----
                birthlocation.setText("Birth Location");
                birthlocation.setForeground(Color.white);
                birthlocation.setFont(new Font("Arial", Font.PLAIN, 25));
                panel1.add(birthlocation, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- birthlocation_txt ----
                birthlocation_txt.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(birthlocation_txt, new TableLayoutConstraints(1, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- wayofbirth3 ----
                wayofbirth3.setText("Way of Birth");
                wayofbirth3.setMinimumSize(new Dimension(79, 41));
                wayofbirth3.setFont(new Font("Arial", Font.PLAIN, 25));
                wayofbirth3.setForeground(Color.white);
                wayofbirth3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(wayofbirth3, new TableLayoutConstraints(0, 10, 0, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- wayofbith_cmb ----
                wayofbith_cmb.setModel(new DefaultComboBoxModel<>(new String[]{
                        "Natural",
                        "Sezeryan"
                }));
                wayofbith_cmb.setFont(new Font("Arial", Font.BOLD, 22));
                wayofbith_cmb.setBackground(new Color(69, 73, 74));
                panel1.add(wayofbith_cmb, new TableLayoutConstraints(1, 10, 1, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- weightatbirth3 ----
                weightatbirth3.setText("Weight at birth");
                weightatbirth3.setMinimumSize(new Dimension(79, 41));
                weightatbirth3.setFont(new Font("Arial", Font.PLAIN, 25));
                weightatbirth3.setForeground(Color.white);
                weightatbirth3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(weightatbirth3, new TableLayoutConstraints(0, 11, 0, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- weightatbirth_txt3 ----
                weightatbirth_txt3.setMaximumSize(new Dimension(28, 57));
                weightatbirth_txt3.setMinimumSize(new Dimension(79, 41));
                weightatbirth_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(weightatbirth_txt3, new TableLayoutConstraints(1, 11, 1, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- heightatbirth3 ----
                heightatbirth3.setText("Height at birth");
                heightatbirth3.setMinimumSize(new Dimension(79, 41));
                heightatbirth3.setFont(new Font("Arial", Font.PLAIN, 25));
                heightatbirth3.setForeground(Color.white);
                heightatbirth3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(heightatbirth3, new TableLayoutConstraints(0, 12, 0, 12, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- heightatbirth_txt3 ----
                heightatbirth_txt3.setMaximumSize(new Dimension(28, 57));
                heightatbirth_txt3.setMinimumSize(new Dimension(79, 41));
                heightatbirth_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(heightatbirth_txt3, new TableLayoutConstraints(1, 12, 1, 12, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- headcircum3 ----
                headcircum3.setText("Head Circumference");
                headcircum3.setMinimumSize(new Dimension(79, 41));
                headcircum3.setFont(new Font("Arial", Font.PLAIN, 25));
                headcircum3.setForeground(Color.white);
                headcircum3.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(headcircum3, new TableLayoutConstraints(0, 13, 0, 13, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- headcircum_txt3 ----
                headcircum_txt3.setMaximumSize(new Dimension(28, 57));
                headcircum_txt3.setMinimumSize(new Dimension(79, 41));
                headcircum_txt3.setFont(new Font("Arial", Font.PLAIN, 36));
                panel1.add(headcircum_txt3, new TableLayoutConstraints(1, 13, 1, 13, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- save_btn3 ----
                save_btn3.setText("Save");
                save_btn3.setMinimumSize(new Dimension(79, 41));
                save_btn3.setFont(new Font("Arial", Font.PLAIN, 36));
                save_btn3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        save_btn3MouseClicked(e);
                    }
                });
                panel1.add(save_btn3, new TableLayoutConstraints(1, 14, 1, 14, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            }
            tabbedPane1.addTab("Add new patient", panel1);

            //======== panel2 ========
            {
                panel2.setMinimumSize(new Dimension(888, 1000));
                panel2.setBackground(Color.white);
                panel2.setLayout(new TableLayout(new double[][]{
                        {TableLayout.FILL, TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}}));
                ((TableLayout) panel2.getLayout()).setHGap(5);
                ((TableLayout) panel2.getLayout()).setVGap(5);

                //---- label1 ----
                label1.setText("DR MAGED");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Arial", Font.PLAIN, 18));
                panel2.add(label1, new TableLayoutConstraints(0, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- picy ----
                picy.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(picy, new TableLayoutConstraints(0, 1, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- AddPatient_btn ----
                AddPatient_btn.setText("ADD NEW PATIENT");
                AddPatient_btn.setFont(new Font("Arial", Font.BOLD, 20));
                AddPatient_btn.addActionListener(e -> AddPatient_btnActionPerformed(e));
                panel2.add(AddPatient_btn, new TableLayoutConstraints(0, 7, 1, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- searchforpatient_btn ----
                searchforpatient_btn.setText("SEARCH FOR A PATIENT");
                searchforpatient_btn.setFont(new Font("Arial", Font.BOLD, 20));
                panel2.add(searchforpatient_btn, new TableLayoutConstraints(0, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- operation_btn ----
                operation_btn.setText("OPERATION FOR THE PATIENT");
                operation_btn.setFont(new Font("Arial", Font.BOLD, 20));
                panel2.add(operation_btn, new TableLayoutConstraints(0, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- editpatien_btn ----
                editpatien_btn.setText("EDIT PATIENT INFORMATION");
                editpatien_btn.setFont(new Font("Arial", Font.BOLD, 20));
                panel2.add(editpatien_btn, new TableLayoutConstraints(0, 10, 1, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- close_btn ----
                close_btn.setText("CLOSE");
                close_btn.setFont(new Font("Arial", Font.BOLD, 20));
                panel2.add(close_btn, new TableLayoutConstraints(0, 11, 1, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            }
            tabbedPane1.addTab("Menu", panel2);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}