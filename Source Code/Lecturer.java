import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * 
 * The Lecturer class extends the Person class and provides additional
 * functionality specific to a lecturer.
 * 
 * It allows a Lecturer to get a list of projects, view a project by project
 * name, and add or edit a project.
 * 
 * @author Reuben
 */
public class Lecturer extends Person {
    public Lecturer() {
        super();
    }

    /**
     * 
     * This method retrieves all projects from the project.csv file and returns a
     * DefaultListModel containing the name of the project and its specialization.
     * 
     * @return DefaultListModel<String> containing the name of the project and its
     *         specialization
     */
    public static DefaultListModel<String> getProjects() {

        List<String> lines;
        DefaultListModel<String> projectList = new DefaultListModel<>();

        try {
            // read project
            lines = Files.readAllLines(Paths.get("./project.csv"));

            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");

                // Create new project instance
                Project proj = new Project(items);

                // Add to the name of project and specialization to the projectList
                projectList.addElement(proj.getProjectName() + "(" + proj.getSpecialization() + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    /**
     * 
     * This overloaded method retrieves a list of projects handled by a specific
     * lecturer ID
     * from the project.csv file and returns a DefaultListModel containing the name
     * of the project and its specialization.
     * 
     * @param id String the id of the lecturer
     * 
     * @return DefaultListModel<String> containing the name of the project and its
     *         specialization
     */
    public static DefaultListModel<String> getProjects(String id) {

        List<String> lines;
        DefaultListModel<String> projectList = new DefaultListModel<>();

        try {
            lines = Files.readAllLines(Paths.get("./project.csv"));

            String listview;
            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");

                // Create new project instance
                Project proj = new Project(items);

                // check if project is handled by lecturer(id) that is currently
                // logged in
                if (proj.getLecturer().equals(id)) {
                    // Add to the name of project and specialization to the projectList
                    listview = proj.getProjectName() + "(" + proj.getSpecialization() + ")";
                    projectList.addElement(listview);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    /**
     * Function to view project based on project Name
     * 
     * @param pName name of the project
     * @return a String "message" to be displayed
     */
    public static String viewProject(String pName) {
        String message = "Project not found";
        try {
            // Read from project.csv
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get items from csv file
                String[] items = lines.get(i).split(",");
                String[] listitem = pName.split("\\(");

                // Creating a new project class instance
                Project tmpProject = new Project(items[0], items[1], items[2], items[3],
                        items[4], items[5], items[6], items[7]);

                // Compare project name
                if (tmpProject.getProjectName().equals(listitem[0])) {
                    // remove the ")" in the project spec
                    listitem[1] = listitem[1].replaceAll("\\)", "");
                    // Compare the specialization
                    if (tmpProject.getSpecialization().equals(listitem[1])) {
                        message = "Project ID: \n" + tmpProject.getProjectId()
                                + "\n\nProject Name: \n" + tmpProject.getProjectName()
                                + "\n\nProject Description: \n" + tmpProject.getProjectDesc()
                                + "\n\nStudent: \n" + tmpProject.getStudent()
                                + "\n\nLecturer :\n" + tmpProject.getLecturer()
                                + "\n\nAssign To: \n" + tmpProject.getSpecialization()
                                + "\n\nComment :\n" + tmpProject.getComment()
                                + "\n\nThis project is" + tmpProject.getActive() + "\n";

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}
