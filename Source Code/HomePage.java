import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * The HomePage class extends the JFrame class and is responsible for creating
 * and managing the main menu of the application.
 * 
 * The class contains various GUI components such as buttons, labels, and text
 * fields, which are used to create the main menu and login interface.
 * 
 * The class also contains a constructor that sets the layout, bounds, and
 * properties of the various GUI components and adds them to the frame.
 * It also sets the color scheme and makes the frame visible.
 * 
 * @author Emad
 */
public class HomePage extends JFrame {

    // Set Colour LIGHT_SAI_COLOR
    public static final Color LIGHT_SAI_COLOR = new Color(19, 19, 70);

    // initializing Components
    JButton lect = new JButton("Lecturer Login");
    JButton stud = new JButton("Student Login");
    JButton adm = new JButton("Administrator Login");
    JLabel lbl = new JLabel("WELCOME !!");

    JLabel user = new JLabel();
    JLabel idLbl = new JLabel("Enter ID  ");
    JTextField id = new JTextField();
    JLabel passWord = new JLabel("Enter password  ");
    JPasswordField pass = new JPasswordField();
    JButton log = new JButton("Login");
    JLabel fail = new JLabel();

    JPanel jp = new JPanel();// Menu
    JPanel jp2 = new JPanel();// Login

    /**
     * * The class contains a constructor that sets the layout, bounds, and
     * properties of the various GUI components and adds them to the frame.
     * It also sets the color scheme and makes the frame visible.
     */
    public HomePage() {
        super("Main Page");
        // Setting Components
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();

        setLayout(null);
        jp.setLayout(null);
        jp2.setLayout(null);

        lect.setFocusable(false);
        stud.setFocusable(false);
        lbl.setFocusable(false);

        lect.setBounds(10, 30, 150, 30);
        stud.setBounds(170, 30, 150, 30);
        adm.setBounds(90, 70, 150, 30);
        lbl.setBounds(10, 10, 100, 20);

        lbl.setForeground(Color.orange);
        lbl.setFont(new Font("Arial", Font.BOLD, 15));

        jp.add(lect);
        jp.add(stud);
        jp.add(adm);
        // jp.add(lbl);

        idLbl.setBounds(20, 70, 150, 30);
        id.setBounds(20, 100, 200, 30);
        passWord.setBounds(20, 160, 150, 30);
        pass.setBounds(20, 190, 200, 30);
        log.setBounds(20, 270, 150, 30);
        fail.setBounds(20, 310, 300, 30);

        idLbl.setForeground(Color.ORANGE);
        id.setBackground(Color.WHITE);
        passWord.setForeground(Color.ORANGE);
        pass.setBackground(Color.WHITE);
        log.setBackground(Color.ORANGE);
        user.setFont(new Font("Arial", Font.BOLD, 20));
        user.setForeground(Color.ORANGE);
        fail.setForeground(Color.ORANGE);
        fail.setFont(new Font("Arial", Font.BOLD, 14));

        // jp2.add(user);
        jp2.add(idLbl);
        jp2.add(id);
        jp2.add(passWord);
        jp2.add(pass);
        jp2.add(log);
        jp2.add(fail);

        // jp2 panel only visible if buttons in jp clicked
        jp2.setVisible(false);

        jp.setBounds(10, 0, 330, 110);
        jp2.setBounds(10, 120, 330, 350);

        jp.setBackground(LIGHT_SAI_COLOR);
        jp2.setBackground(LIGHT_SAI_COLOR);

        jp.setBorder(br);
        jp2.setBorder(br);

        c.add(jp);
        c.add(jp2);

        setVisible(true);
        setBounds(100, 100, 370, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Action listeners
    /**
     * 
     * Adds an action listener to the "Lecturer" button.
     * 
     * @param listenForlectButton ActionListener to be added to the "Lecturer"
     *                            button.
     */
    public void addlectListener(ActionListener listenForlectButton) {
        lect.addActionListener(listenForlectButton);
    }

    /**
     * 
     * Adds an action listener to the "Student" button.
     * 
     * @param listenForstudButton ActionListener to be added to the "Student"
     *                            button.
     */
    public void addstudListener(ActionListener listenForstudButton) {
        stud.addActionListener(listenForstudButton);
    }

    /**
     * 
     * Adds an action listener to the "Administrator" button.
     * 
     * @param listenForadmButton ActionListener to be added to the "Administrator"
     *                           button.
     */

    public void addadmListener(ActionListener listenForadmButton) {
        adm.addActionListener(listenForadmButton);
    }

    /**
     * 
     * Method for Lectuer Login.
     * It sets the text on the login page to "LECTURER LOGIN" and makes the login
     * form visible.
     */
    public void lecLogin() { // Lecture Login
        user.setText("LECTURER LOGIN");
        jp2.setVisible(true);
        jp2.add(user);
        user.setBounds(80, 10, 200, 30);
    }

    /**
     * 
     * Method for Student Login.
     * It sets the text on the login page to "STUDENT LOGIN" and makes the login
     * form visible.
     */
    public void studLogin() { // Student Login
        user.setText("STUDENT LOGIN");
        jp2.setVisible(true);
        user.setBounds(85, 10, 200, 30);
        jp2.add(user);
    }

    /**
     * 
     * Method for Admin Login.
     * It sets the text on the login page to "ADMINISTRATOR LOGIN" and makes the
     * login form visible.
     */
    public void admLogin() { // Admin Login
        user.setText("ADMINISTRATOR LOGIN");
        jp2.setVisible(true);
        user.setBounds(45, 10, 250, 30);
        jp2.add(user);
    }

    /**
     * 
     * Adds an action listener to the "log" button.
     * 
     * @param listenForLogButton ActionListener to be added to the "log" button.
     */
    public void addLogListener(ActionListener listenForLogButton) {
        log.addActionListener(listenForLogButton);
    }
}