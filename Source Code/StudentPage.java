import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;

/**
 * The StudentPage class extends the JFrame class and creates a GUI for the
 * student page. It contains three main panels: panel1, panel2, and panel3.
 * panel1 contains buttons for logging out, viewing assigned projects, and
 * viewing all projects. panel2 and panel3 display lists of projects.
 * The class sets the size and visibility of components
 * 
 * 
 * @author Anas
 */
public class StudentPage extends JFrame {

    public static final Color LIGHT_SAI_COLOR = new Color(19, 19, 70);

    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = getContentPane();

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JButton viewA = new JButton("View Assigned");
    JButton viewProject = new JButton("View Project");
    JButton logOut = new JButton("Logout");
    JButton enterView = new JButton("view");

    DefaultListModel<String> projectList = new DefaultListModel<>();
    JLabel panelTitle = new JLabel();

    JList<String> Plist;
    JScrollPane scrollPane = new JScrollPane();
    JTextArea project;
    JOptionPane viewProjectResults = new JOptionPane();

    public StudentPage() {
        // Panel Name and setting layout
        super("Student Page");
        setLayout(null);

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        panel1.setBounds(10, 0, 485, 110);
        panel2.setBounds(85, 120, 330, 350);
        panel3.setBounds(85, 120, 330, 350);

        ////////////////////// PANEL 1 //////////////////////
        panel1.add(logOut);
        panel1.add(viewA);
        panel1.add(viewProject);

        viewA.setFocusable(false);
        viewProject.setFocusable(false);
        logOut.setFocusable(false);

        viewA.setBounds(10, 40, 150, 30);
        viewProject.setBounds(330, 40, 150, 30);
        logOut.setBounds(170, 40, 150, 30);

        // Panel title to be used above the scrollpane when clicking my buttons

        panelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitle.setForeground(Color.ORANGE);

        // other panels set to not visible

        panel2.setVisible(false);
        panel3.setVisible(false);

        // background color of the panels

        panel1.setBackground(LIGHT_SAI_COLOR);
        panel2.setBackground(LIGHT_SAI_COLOR);
        panel3.setBackground(LIGHT_SAI_COLOR);

        // borders of the panel

        panel1.setBorder(br);
        panel2.setBorder(br);
        panel3.setBorder(br);

        // adding the panels to the container

        c.add(panel1);
        c.add(panel2);
        c.add(panel3);

        setVisible(true);
        setBounds(100, 100, 520, 520);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    // Listeners for butttons that gets clicked

    public void addlogOutListener(ActionListener l) {
        logOut.addActionListener(l);
    }

    public void addviewProjectListener(ActionListener l) {
        viewProject.addActionListener(l);
    }

    public void addviewAListener(ActionListener l) {
        viewA.addActionListener(l);
    }

    public void addenterViewProjectListener(ActionListener l) {
        enterView.addActionListener(l);
    }

}
