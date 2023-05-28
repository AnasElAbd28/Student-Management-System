import java.awt.Dimension;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Reuben - Getting Data for Report
/**
 * 
 * The Report class is used to generate various reports on projects.
 * 
 * It contains methods to return ArrayLists of projects based on different
 * criteria such as specialization, lecturer, active/inactive status and
 * assignment status.
 * 
 * The static field 'projects' contains all the projects read from the
 * project.csv file.
 * 
 * @author Reuben
 */
public class Report {
    private static ArrayList<Project> projects;

    // Return AraryList of all Projects
    /**
     * 
     * Returns an ArrayList of all Projects that are stored in the project.csv file
     * 
     * @return ArrayList of all Projects
     */
    public static ArrayList<Project> allProjects() {
        try {
            Project p; // read Projects (Saved in static projects ArrayLIst)
            projects = new ArrayList<>();

            // Read from project.csv
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get items from csv file (items = a line in a file)
                String[] items = lines.get(i).split(",");
                p = new Project(items);

                projects.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return projects;
    }

    // Return AraryList of all Projects with specialization "sp"
    /**
     * Return ArrayList of all Projects with specialization "sp"
     * 
     * @param sp the specialization of the projects to be returned
     * @return ArrayList of all Projects with specialization "sp"
     */
    public static ArrayList<Project> specialization(String sp) {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects(); // read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if specialization field is same as "sp"
            if (p.getSpecialization().equals(sp))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects with lectuerers "lect"
    /**
     * Return ArrayList of all Projects with lectuerers "lect"
     * 
     * @param lect the lecturer of the projects to be returned
     * @return ArrayList of all Projects with lecturer "lect"
     */
    public static ArrayList<Project> lecturers(String lect) {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects();// read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if lecturer field is same as "lect"
            if (p.getLecturer().equals(lect))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects that are inactive
    /**
     * Return ArrayList of all Projects that are inactive
     * 
     * @return ArrayList of all inactive Projects
     */
    public static ArrayList<Project> inactive() {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects();// read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if active field is "inactive"
            if (p.getActive().equals("inactive"))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects that are active
    /**
     * Return ArrayList of all Projects that are active
     * 
     * @return ArrayList of all active Projects
     */
    public static ArrayList<Project> active() {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects();// read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if active field is "active"
            if (p.getActive().equals("active"))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects that are already assigned to a student
    /**
     * 
     * @return ArrayList of all Projects that are already assigned to a student
     */
    public static ArrayList<Project> assigned() {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects(); // read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if student field is NOT "unassigned"
            if (!p.getStudent().equals("Unassigned"))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects that are unassigned
    /**
     * 
     * @return ArrayList of all Projects are unassigned
     */
    public static ArrayList<Project> unassigned() {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects(); // read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if student field is "unassigned"
            if (p.getStudent().equals("Unassigned"))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // Return AraryList of all Projects that have comments on them
    /**
     * 
     * @return ArrayList of all Projects that have comments on them
     */
    public static ArrayList<Project> comment() {
        ArrayList<Project> returnProjects = new ArrayList<>();
        allProjects(); // read Projects (Saved in static projects ArrayLIst)
        Project p;
        for (int i = 0; i < projects.size(); i++) {
            p = projects.get(i);
            // if comment field is not empty
            if (!p.getComment().equals(""))
                returnProjects.add(p); // add the Project to ArrayList "returnProjects"
        }
        return returnProjects;
    }

    // return data for search (either lecturers or specialization)
    /**
     * 
     * The searchType method is used to return data for search either in the form of
     * specialization or lecturers.
     * 
     * It takes a string input which can either be "Specialization" or "Lecturers"
     * and returns an ArrayList of Strings containing the corresponding data.
     * 
     * @param s A string which can either be "Specialization" or "Lecturers"
     * @return ArrayList of Strings containing the corresponding data if input is
     *         valid. Returns null otherwise.
     */
    public static ArrayList<String> searchType(String s) {
        if (s.equals("Specialization")) {
            // return specialization data
            return new ArrayList<>(
                    Arrays.asList("SOFTWARE ENGINEERING", "CYBERSECURITY", "DATA SCIENCE", "GAME DEVELOPMENT"));
        } else if (s.equals("Lecturers")) {
            // return lecturers data
            return readData.getLecturerList();
        }
        return null;
    }

    // Show Report in new frame
    /**
     * 
     * The showReport method is responsible for displaying the report based on the
     * specified report type and search criteria.
     * 
     * @param rType  The type of report to be displayed. Can be one of "All
     *               Projects", "Specialization", "Lecturers", "Inactive projects",
     *               "Active projects", "Assigned Projects", "Unassigned Projects",
     *               "Comments"
     * @param search The search criteria for the report. Can be a specialization or
     *               lecturer name, depending on the report type.
     */
    public static void showReport(String rType, String search) {

        // New Frame for Report
        JFrame frame = new JFrame("REPORT : " + rType + " - " + search);
        if (search == null) // If seacrh has no seacrh field
            frame = new JFrame("REPORT : " + rType);
        frame.setPreferredSize(new Dimension(1000, 600));

        // Set Size at position of frame
        frame.setBounds(300, 300, 1000, 1000);
        frame.setSize(1000, 600);

        // Name of columns
        String[] columnNames = { "ID", "Name", "Specialization", "Student", "Lecturer", "Comment", "Status" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // init default table Model
        ArrayList<Project> projects = new ArrayList<>();

        // Show Report based on what type of report
        if (rType.equals("All Projects")) {
            projects = Report.allProjects();
        } else if (rType.equals("Specialization")) {
            projects = Report.specialization(search);
        } else if (rType.equals("Lecturers")) {
            projects = Report.lecturers(search);
        } else if (rType.equals("Inactive projects")) {
            projects = Report.inactive();
        } else if (rType.equals("Active projects")) {
            projects = Report.active();
        } else if (rType.equals("Assigned Projects")) {
            projects = Report.assigned();
        } else if (rType.equals("Unassigned Projects")) {
            projects = Report.unassigned();
        } else if (rType.equals("Comments")) {
            projects = Report.comment();
        }

        // Fill the table model with data from report
        for (Project project : projects) {
            // create a row of data (1 project in 1 row)
            Object[] row = { project.getProjectId(), project.getProjectName(), project.getSpecialization(),
                    project.getStudent(), project.getLecturer(), project.getComment(), project.getActive() };
            // add the row to the default table Model
            model.addRow(row);
        }

        // init a JTable containing the model (consist of pojects)
        JTable reportTable = new JTable(model);
        // init scrollPane with the JTable(reportTable)
        JScrollPane scrollPane = new JScrollPane(reportTable);
        frame.add(scrollPane); // add the scrollPane to the frame

        frame.pack();
        frame.setVisible(true);
    }
}