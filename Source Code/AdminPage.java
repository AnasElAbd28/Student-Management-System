import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * 
 * This class represents the AdminPage
 * 
 * It provides the View Page for an Administrator to add new users
 * (students, lecturers, and administrators), add projects, view projects,
 * add comments to projects, view reports and log out.
 * 
 * @author Emad
 * @author Zi Hang
 * @author Eddy
 * @author Reuben
 */
public class AdminPage extends JFrame {

    public static final Color LIGHT_SAI_COLOR = new Color(19, 19, 70);

    // Set border and container
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = getContentPane();

    // Panels
    JPanel panel1 = new JPanel(); // Menu
    JPanel panel2 = new JPanel(); // Add account
    JPanel panel3 = new JPanel(); // Comment Project
    JPanel panel4 = new JPanel(); // Add Project
    JPanel panel5 = new JPanel(); // View Project
    JPanel panel6 = new JPanel(); // Report

    // Components used
    JButton addStud = new JButton("Add student");
    JButton addLect = new JButton("Add lecturer");
    JButton addAdm = new JButton("Add administrator");
    JButton logOut = new JButton("Logout");
    JButton addP = new JButton("Add project");
    JButton viewP = new JButton("View Projects");
    JButton report = new JButton("View Report");

    JLabel panelTitle = new JLabel();
    JLabel enterN = new JLabel();
    JLabel sp = new JLabel("Choose the specialization : ");
    JTextField userName = new JTextField();
    JButton enter = new JButton("ENTER");

    JLabel info = new JLabel();
    JLabel info2 = new JLabel();
    JLabel info3 = new JLabel();
    JTextField tempProjectName = new JTextField();
    JTextField tempProjectDetails = new JTextField();
    JLabel enterD = new JLabel("Please enter your Project Details : ");
    JButton enterB = new JButton("Enter");

    // Panel 3 - Comment Project
    JLabel projectNameID = new JLabel();
    JLabel commentLabel = new JLabel("Please enter your Project Comments : ");
    JTextArea comment = new JTextArea();
    JButton addComment = new JButton("Add Comment");

    JLabel AssignTo = new JLabel("Assign To :");
    DefaultListModel<String> projectList = new DefaultListModel<>();
    JButton enterView = new JButton("View");
    JButton enterComment = new JButton("Comment");
    JButton enterDelete = new JButton("Delete");
    JLabel LecturerLabel = new JLabel("Lecturer :");

    String[] specialization = { "SOFTWARE ENGINEERING", "CYBERSECURITY", "DATA SCIENCE", "GAME DEVELOPMENT" };
    ArrayList<String> lecturers = new ArrayList<>();
    JComboBox<String> lList;

    JComboBox<String> sList = new JComboBox<>(specialization);
    JComboBox<String> aList = new JComboBox<>(specialization);
    JList<String> Plist;
    JTextArea project;
    JOptionPane viewProjectResults = new JOptionPane();
    JScrollPane scrollPane = new JScrollPane();

    // Panel 6
    String[] reportType = { "All Projects", "Specialization", "Lecturers", "Inactive projects", "Active projects",
            "Assigned Projects", "Unassigned Projects", "Comments" };
    JLabel reportListLabel = new JLabel("Report Type : ");
    JComboBox<String> rList = new JComboBox<>(reportType);
    JLabel searchLabel = new JLabel();
    JComboBox<String> searchList = new JComboBox<>(specialization);
    JComboBox<String> searchList2;
    JButton getReport = new JButton("Get Report");

    /**
     * 
     * Constructor for the AdminPage class.
     * 
     * This constructor sets up the layout and bounds for the various panels,
     * buttons, labels and other components
     * used in the class and adds them to the frame.
     */
    public AdminPage() {
        // Panel Title and set Layout
        super("Administrator Page");
        setLayout(null);

        // Setting bounds for Panels
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        panel6.setLayout(null);

        ////////////////////// PANEL 1 //////////////////////
        addStud.setBounds(10, 10, 150, 25);
        addLect.setBounds(10, 45, 150, 25);
        addAdm.setBounds(170, 10, 150, 25);
        logOut.setBounds(170, 45, 150, 25);
        addP.setBounds(330, 10, 150, 25);
        viewP.setBounds(330, 45, 150, 25);
        report.setBounds(170, 80, 150, 25);

        panel1.add(addStud);
        panel1.add(addLect);
        panel1.add(addAdm);
        panel1.add(logOut);
        panel1.add(addP);
        panel1.add(viewP);
        panel1.add(report);

        ////////////////////// PANEL 2 //////////////////////
        userName.setBounds(10, 80, 250, 30);
        sp.setBounds(10, 120, 250, 30);
        sList.setBounds(10, 150, 250, 30);
        enter.setBounds(90, 200, 150, 30);
        info.setBounds(10, 240, 150, 30);
        info2.setBounds(10, 280, 150, 30);
        info3.setBounds(10, 320, 150, 30);

        enterN.setForeground(Color.ORANGE);
        sp.setForeground(Color.ORANGE);
        panelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitle.setForeground(Color.ORANGE);
        info.setForeground(Color.ORANGE);
        info2.setForeground(Color.ORANGE);
        info3.setForeground(Color.ORANGE);

        panel2.add(userName);
        panel2.add(sp);
        panel2.add(enter);
        panel2.add(info);
        panel2.add(info2);
        panel2.add(info3);
        ////////////////////// PANEL 3 //////////////////////
        projectNameID.setBounds(10, 50, 300, 30);
        commentLabel.setBounds(10, 80, 300, 30);
        comment.setBounds(10, 120, 300, 70);
        addComment.setBounds(80, 240, 140, 30);

        projectNameID.setForeground(Color.ORANGE);
        commentLabel.setForeground(Color.ORANGE);

        ////////////////////// PANEL 5 //////////////////////
        lecturers = new ArrayList<>();
        lecturers.addAll(readData.getLecturerList());
        lList = new JComboBox(lecturers.toArray());

        tempProjectName.setBounds(10, 80, 250, 30);
        tempProjectDetails.setBounds(10, 160, 250, 30);
        enterD.setBounds(10, 120, 250, 30);
        enterB.setBounds(70, 280, 150, 30);
        AssignTo.setBounds(10, 200, 150, 30);
        aList.setBounds(10, 240, 250, 30);
        LecturerLabel.setBounds(10, 240, 150, 30);
        lList.setBounds(10, 270, 250, 30);

        enterD.setForeground(Color.ORANGE);
        AssignTo.setForeground(Color.ORANGE);
        LecturerLabel.setForeground(Color.ORANGE);

        ////////////////////// PANEL 6 //////////////////////
        lecturers = new ArrayList<>();
        lecturers.addAll(readData.getLecturerList());
        searchList2 = new JComboBox(lecturers.toArray());

        reportListLabel.setForeground(Color.ORANGE);
        searchLabel.setForeground(Color.ORANGE);

        reportListLabel.setBounds(10, 50, 250, 30);
        rList.setBounds(10, 90, 250, 30);
        searchLabel.setBounds(10, 130, 250, 30);
        getReport.setBounds(100, 300, 100, 30);

        // set panels to not visible first
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);

        panel1.setBounds(10, 0, 485, 110);
        panel2.setBounds(85, 120, 330, 350);
        panel3.setBounds(85, 120, 330, 350);
        panel4.setBounds(85, 120, 330, 350);
        panel5.setBounds(85, 120, 330, 350);
        panel6.setBounds(85, 120, 330, 350);

        panel1.setBackground(LIGHT_SAI_COLOR);
        panel2.setBackground(LIGHT_SAI_COLOR);
        panel3.setBackground(LIGHT_SAI_COLOR);
        panel4.setBackground(LIGHT_SAI_COLOR);
        panel5.setBackground(LIGHT_SAI_COLOR);
        panel6.setBackground(LIGHT_SAI_COLOR);

        panel1.setBorder(br);
        panel2.setBorder(br);
        panel3.setBorder(br);
        panel4.setBorder(br);
        panel5.setBorder(br);
        panel6.setBorder(br);

        // Add Panels to the container
        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);
        c.add(panel5);
        c.add(panel6);

        setVisible(true);
        setBounds(100, 100, 520, 520);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    // Listeners for respective buttons

    // Panel 1
    /**
     * Adds an action listener to the "addLect" button.
     * When pressed, this button opens panel 2.
     * 
     * @param l ActionListener to be added to the "addLect" button
     */
    public void addAddLectListener(ActionListener l) {
        addLect.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "addAdm" button.
     * When pressed, this button opens panel 2.
     * 
     * @param l ActionListener to be added to the "addAdm" button
     */
    public void addAddAdmListener(ActionListener l) {
        addAdm.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "addStud" button.
     * When pressed, this button opens panel 2.
     * 
     * @param l ActionListener to be added to the "addStud" button
     */
    public void addAddStudListener(ActionListener l) {
        addStud.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "logOut" button.
     * When pressed, this button returns the user to the login page.
     * 
     * @param l ActionListener to be added to the "logOut" button
     */
    public void addlogOutListener(ActionListener l) {
        logOut.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "addP" button.
     * When pressed, this button opens panel 4.
     * 
     * @param l ActionListener to be added to the "addP" button
     */
    public void addaddPListener(ActionListener l1) {
        addP.addActionListener(l1);
    }

    /**
     * 
     * Adds an action listener to the "viewP" button.
     * When pressed, this button opens panel 5.
     * 
     * @param l ActionListener to be added to the "viewP" button
     */
    public void addviewPListener(ActionListener l) {
        viewP.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "report" button.
     * When pressed, this button opens panel 6.
     * 
     * @param l ActionListener to be added to the "report" button
     */
    public void addreportListener(ActionListener l) {
        report.addActionListener(l);
    }

    // Panel 2
    /**
     * 
     * Adds an action listener to the "enter" button in panel 2.
     * When pressed, this button adds a new account to the csv file.
     * 
     * @param l ActionListener to be added to the "enter" button
     */
    public void addenterAddListener(ActionListener l) {
        enter.addActionListener(l);
    }

    // Panel3
    /**
     * 
     * Adds an action listener to the "addComment" button in panel 3.
     * When pressed, this button adds a comment to the selected project in the
     * project.csv file.
     * 
     * @param l ActionListener to be added to the "addComment" button
     */
    public void addaddCommentListener(ActionListener l) {
        addComment.addActionListener(l);
    }

    // Panel 4
    /**
     * 
     * Adds an action listener to the "enterB" button in panel 4.
     * When pressed, this button adds a new project to the project.csv file.
     * 
     * @param l ActionListener to be added to the "enterB" button
     */
    public void addenterNewProjectListener(ActionListener l) {
        enterB.addActionListener(l);
    }

    // Panel 5
    /**
     * 
     * Adds an action listener to the "enterView" button in panel 5.
     * When pressed, this button shows the details of the selected project.
     * 
     * @param l ActionListener to be added to the "enterView" button
     */
    public void addenterViewProjectListener(ActionListener l) {
        enterView.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "enterComment" button in panel 5.
     * When pressed, this button changes the panel to panel 3 for commenting on the
     * selected project.
     * 
     * @param l ActionListener to be added to the "enterComment" button
     */
    public void addenterCommentProjectListener(ActionListener l) {
        enterComment.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "enterDelete" button in panel 5.
     * When pressed, this button deletes the selected project from the project.csv
     * file.
     * 
     * @param l ActionListener to be added to the "enterDelete" button
     */
    public void addenterDeleteProjectListener(ActionListener l) {
        enterDelete.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the "getReport" button in panel 6.
     * When pressed, this button generates a report based on the data from the
     * project.csv file.
     * 
     * @param l ActionListener to be added to the "getReport" button
     */
    public void addgetReportListener(ActionListener l) {
        getReport.addActionListener(l);
    }

    /**
     * 
     * Adds an action listener to the JComboBox "rlist" in panel 6.
     * When a certain option is selected, an extra search JComboBox will appear.
     * 
     * @param l ActionListener to be added to the "rList" JComboBox
     */
    public void addrListListener(ActionListener l) {
        rList.addActionListener(l);
    }

}
