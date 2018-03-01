import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panels
{
    JFrame frame;
    JPanel panel;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;

    Panels()
    {
        initGUI();
        launchFrame();
    }

    public void initGUI()
    {
        frame = new JFrame();
        panel = new JPanel();
        addButton = new JButton("Add");
        modifyButton = new JButton("Modify");
        deleteButton = new JButton("Delete");
    }

    private void launchFrame() {
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        JScrollPane  panel1 = new JScrollPane (buttonPanel);

        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        // add margin to left and right of delete button
        // other buttons will follow suit because of GridLayout
        deleteButton.setMargin(new Insets(0, 50, 0, 50));
        buttonPanel.add(deleteButton);
        // create some space at the top for the buttonPanel
        buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        panel.add(buttonPanel);


        frame.add(panel);
        frame.setTitle("My Frame with Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}