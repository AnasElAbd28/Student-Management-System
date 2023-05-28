import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * The LecturerPage class extends the JFrame class and is responsible for
 * creating
 * and managing the Lecturer part of the application.
 * 
 * The class contains various GUI components such as buttons, labels, and text
 * fields, which are used to create the main menu and login interface.
 * 
 * The class also contains a constructor that sets the layout, bounds, and
 * properties of the various GUI components and adds them to the frame.
 * It also sets the color scheme and makes the frame visible.
 * 
 * @author Reuben
 */
public class LecturerPage extends JFrame {
    String[] specialization = { "SOFTWARE ENGINEERING", "CYBERSECURITY", "DATA SCIENCE", "GAME DEVELOPMENT" };
    ArrayList<String> students = new ArrayList<>(Arrays.asList("Unassigned(Unassigned)"));

    public static final Color LIGHT_SAI_COLOR = new Color(19, 19, 70);
    ArrayList<Project> projects;
    Project tmpProject;

    // Overall

    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = getContentPane();

    // Create the two panels for the application
    JPanel panel1 = new JPanel(); // Main Menu Page
    JPanel panel2 = new JPanel(); // Add Project
    JPanel panel3 = new JPanel(); // Edit Project
    JPanel panel4 = new JPanel(); // View Project

    // <-------------- PANEL 1 (Main Page) -------------->
    // Create the buttons for panel1
    JButton addProject = new JButton("Add project");
    JButton viewProject = new JButton("View Project");
    JButton logOut = new JButton("Logout");

    // <-------------- PANEL 2 (Add Project) -------------->
    JList<String> Plist = new JList<>();
    JScrollPane scrollPane = new JScrollPane();
    List<String> lines;

    // Create the components for panel2
    JLabel panelTitle = new JLabel();
    JLabel enterName = new JLabel();
    JLabel enterDetails = new JLabel("Please enter your Project Details : ");
    JLabel AssignTo = new JLabel("Assign To :");
    JLabel AssignToStudent = new JLabel("Assign To Student:");

    JTextField tempProjectName = new JTextField();
    JTextField tempProjectDetails = new JTextField();
    JComboBox<String> aList = new JComboBox<>(specialization);
    JComboBox<String> aStudentList = new JComboBox<>(specialization);

    JButton enter = new JButton("Enter"); // Add Project Enter button
    JLabel info = new JLabel();

    // <-------------- PANEL 3&4 (View + Edit Project) -------------->
    // Data Structures used for components
    String[] active = { "active", "inactive" };

    DefaultListModel<String> projectList = new DefaultListModel<>();
    JTextArea viewProjectResultsData;
    JOptionPane viewProjectResults = new JOptionPane();
    JButton enterView = new JButton("View");
    JButton edit = new JButton("Edit");

    // Create the components for panel4
    JTextField projectName = new JTextField();
    JTextArea projectDesc = new JTextArea(60, 120);
    JComboBox studentList = new JComboBox(students.toArray());
    JComboBox<String> specList = new JComboBox<>(specialization);
    JComboBox<String> activeList = new JComboBox<>(active);
    JButton editProjectButton = new JButton("Edit");

    // Labels for components
    JLabel projectIDLabel = new JLabel("Project ID : ");
    JLabel projectID = new JLabel();
    JLabel projectNameLabel = new JLabel("Project Name : ");
    JLabel projectDescLabel = new JLabel("Project Desc. : ");
    JLabel projectStudentLabel = new JLabel("Student : ");
    JLabel projectSpecializationLabel = new JLabel("Specialization : ");
    JLabel projectActiveLabel = new JLabel("Active : ");

    /**
     * * The class contains a constructor that sets the layout, bounds, and
     * properties of the various GUI components and adds them to the frame.
     * It also sets the color scheme and makes the frame visible.
     */
    public LecturerPage() {
        // Set the title and layout for the JFrame
        super("Lecturer Page");
        setLayout(null);

        // Overall
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);

        // <-------------- PANEL 1 (Main Page) -------------->

        // Set the bounds for the buttons in panel1
        addProject.setBounds(10, 50, 150, 30);
        viewProject.setBounds(170, 50, 150, 30);
        logOut.setBounds(330, 50, 150, 30);

        // Add the buttons to panel1
        panel1.add(addProject);
        panel1.add(viewProject);
        panel1.add(logOut);

        // <-------------- PANEL 2 (Add Project) -------------->

        // List of students
        students.addAll(readData.getStudentList());
        studentList = new JComboBox(students.toArray());

        // Set the bounds for the components in panel2
        panelTitle.setBounds(80, 10, 200, 30);
        enter.setBounds(420, 50, 150, 30);
        info.setBounds(10, 90, 150, 30);

        // Set the font and color for the panelTitle label
        panelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitle.setForeground(Color.ORANGE);
        enterName.setForeground(Color.ORANGE);
        info.setForeground(Color.ORANGE);

        // Add the components to panel2
        panel2.add(enter);
        panel2.add(info);

        // Set positions of components in panel2
        enterName.setBounds(10, 30, 160, 30);
        tempProjectName.setBounds(10, 70, 250, 30);
        enterDetails.setBounds(10, 110, 250, 30);
        tempProjectDetails.setBounds(10, 150, 250, 30);
        AssignTo.setBounds(10, 190, 150, 30);
        aList.setBounds(10, 230, 250, 30);
        enter.setBounds(120, 312, 100, 30);

        // Set Colours to Orange
        enterDetails.setForeground(Color.ORANGE);
        AssignTo.setForeground(Color.ORANGE);

        // Set panel2 to be not visible by default
        panel2.setVisible(false);

        // <-------------- PANEL 4 (View Project) -------------->

        // Orange Colour Text for labels
        projectIDLabel.setForeground(Color.ORANGE);
        projectID.setForeground(Color.ORANGE);
        projectNameLabel.setForeground(Color.ORANGE);
        projectDescLabel.setForeground(Color.ORANGE);
        projectStudentLabel.setForeground(Color.ORANGE);
        projectSpecializationLabel.setForeground(Color.ORANGE);
        projectActiveLabel.setForeground(Color.ORANGE);

        // Set the bounds for the components in panel4
        projectIDLabel.setBounds(10, 50, 160, 30);
        projectID.setBounds(110, 50, 200, 30);
        projectNameLabel.setBounds(10, 90, 160, 30);
        projectName.setBounds(110, 90, 200, 30);
        projectDescLabel.setBounds(10, 130, 160, 30);
        projectDesc.setBounds(110, 130, 200, 50);
        projectStudentLabel.setBounds(10, 190, 160, 30);
        studentList.setBounds(110, 190, 200, 30);
        projectSpecializationLabel.setBounds(10, 230, 160, 30);
        specList.setBounds(110, 230, 200, 30);
        projectActiveLabel.setBounds(10, 270, 160, 30);
        activeList.setBounds(110, 270, 200, 30);
        editProjectButton.setBounds(120, 312, 100, 30);

        projectDesc.setLineWrap(true);
        projectDesc.setWrapStyleWord(true);

        // Add the panels to the JFrame and set the size and location
        panel1.setBounds(10, 0, 485, 110);
        panel2.setBounds(85, 120, 330, 350);
        panel3.setBounds(85, 120, 330, 350);
        panel4.setBounds(85, 120, 330, 350);

        panel1.setBackground(LIGHT_SAI_COLOR);
        panel2.setBackground(LIGHT_SAI_COLOR);
        panel3.setBackground(LIGHT_SAI_COLOR);
        panel4.setBackground(LIGHT_SAI_COLOR);

        panel1.setBorder(br);
        panel2.setBorder(br);
        panel3.setBorder(br);
        panel4.setBorder(br);

        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);

        setVisible(true);
        setBounds(100, 100, 520, 520);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    // Action Listeners
    // addProject button from Panel 1 (Menu)
    /**
     * 
     * Adds an action listener to the "addProject" button.
     * 
     * @param l ActionListener to be added to the "addProject"
     *          button.
     */
    public void addaddProjectListener(ActionListener l) {
        addProject.addActionListener(l);
    }

    // viewProject button from Panel 1 (Menu)
    /**
     * 
     * Adds an action listener to the "viewProject" button.
     * 
     * @param l ActionListener to be added to the "viewProject"
     *          button.
     */
    public void addviewProjectListener(ActionListener l) {
        viewProject.addActionListener(l);
    }

    // logOutButton from Panel 1 (Menu)
    /**
     * 
     * Adds an action listener to the "logOut" button.
     * 
     * @param l ActionListener to be added to the "logOut"
     *          button.
     */
    public void addlogOutListener(ActionListener l) {
        logOut.addActionListener(l);
    }

    // enter button from Panel 2 (Add Project)
    /**
     * 
     * Adds an action listener to the "enter" button.
     * 
     * @param l ActionListener to be added to the "enter"
     *          button.
     */
    public void addenterAddProjectListener(ActionListener l) {
        enter.addActionListener(l);
    }

    // enterView from Panel 4 (View Project)
    /**
     * 
     * Adds an action listener to the "enterView" button.
     * 
     * @param l ActionListener to be added to the "enterView"
     *          button.
     */
    public void addenterViewProjectListener(ActionListener l) {
        enterView.addActionListener(l);
    }

    // edit Project from Panel 4 (View Project)
        /**
     * 
     * Adds an action listener to the "edit" button.
     * 
     * @param l ActionListener to be added to the "edit"
     *          button.
     */
    public void addeditProjectListener(ActionListener l) {
        edit.addActionListener(l);
    }

    // editProjectButton from Panel 3 (Edit Project)
        /**
     * 
     * Adds an action listener to the "editProjectButton" button.
     * 
     * @param l ActionListener to be added to the "editProjectButton"
     *          button.
     */
    public void addeditProjectButtonListener(ActionListener l) {
        editProjectButton.addActionListener(l);
    }

}
