import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * 
 * The Project class is responsible for creating, storing, and manipulating
 * project data.
 * 
 * It contains constructors for creating new Project objects, setter and getter
 * methods for manipulating the object's
 * 
 * properties and a method for saving the object's properties to a CSV file.
 * 
 * @author Reuben
 * @author Zi Hang
 * @author Eddy
 */
public class Project {
    private String projectId;
    private String projectName;
    private String projectDesc;
    private String student;
    private String lecturer;
    private String comment;
    private String specialization;
    private String active;

    /**
     * 
     * Default constructor for the Project class
     */
    public Project() {
    }

    // Constructor : all fields
    /**
     * 
     * Constructor for creating a new Project object with all properties
     * 
     * @param projectId      the ID of the project
     * @param projectName    the name of the project
     * @param projectDesc    the description of the project
     * @param student        the student assigned to the project
     * @param lecturer       the lecturer assigned to the project
     * @param comment        any comments on the project
     * @param specialization the specialization of the project
     * @param active         the status of the project (active or inactive)
     */
    public Project(String projectId, String projectName, String projectDesc, String student, String lecturer,
            String comment, String specialization, String active) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.student = student;
        this.lecturer = lecturer;
        this.comment = comment;
        this.specialization = specialization;
        this.active = active;
    }

    // Overloaded Constructor : all fields using an array
    /**
     * Overloaded constructor for creating a new Project object with all properties
     * using an array
     * 
     * @param a an array containing the project's properties in the order: project
     *          ID, name, description, student,
     *          lecturer, comment, specialization, and active status.
     */
    public Project(String[] a) {
        this.projectId = a[0];
        this.projectName = a[1];
        this.projectDesc = a[2];
        this.student = a[3];
        this.lecturer = a[4];
        this.comment = a[5];
        this.specialization = a[6];
        this.active = a[7];
    }

    // Overloaded Constructor : 3 fields (for Add Project - Lecturer)
    /**
     * Overloaded constructor for creating a new Project object with 3 properties
     * 
     * @param projectName    the name of the project
     * @param projectDesc    the description of the project
     * @param specialization the specialization of the project
     */
    public Project(String projectName, String projectDesc, String specialization) {
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.specialization = specialization;
    }

    // Overloaded Constructor : 4 fields (for Add Project - Admin)
    /**
     * 
     * Overloaded constructor for creating a new Project object with 4 properties
     * 
     * @param projectName    the name of the project
     * @param projectDesc    the description of the project
     * @param lecturer       the lecturer assigned to the project
     * @param specialization the specialization of the project
     */
    public Project(String projectName, String projectDesc, String lecturer, String specialization) {
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.lecturer = lecturer;
        this.specialization = specialization;
    }

    // Constructors and Mutators
    /**
     * Constructors and Mutators
     * 
     * @return the project id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId the project id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 
     * @return the name of the project
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 
     * @return the description of the project
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * 
     * @param projectName
     *                    the name of the project
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 
     * @return the id of the student assigned to the project
     */
    public String getStudent() {
        return student;
    }

    /**
     * 
     * @param student
     *                the id of the student assigned to the project
     */
    public void setStudent(String student) {
        this.student = student;
    }

    /**
     * 
     * @return the id of the lecturer assigned to the project
     */
    public String getLecturer() {
        return lecturer;
    }

    /**
     * 
     * @param lecturer
     *                 the id of the lecturer assigned to the project
     */
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * 
     * @return the comment on the project
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *                the comment on the project
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return the specialization of the project
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * 
     * @param specialization
     *                       the specialization of the project
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * 
     * @return the active status of the project
     */
    public String getActive() {
        return active;
    }

    /**
     * Set the active status of the project
     *
     * @param active the active status of the project
     */
    public void setActive(String active) {
        this.active = "active";
    }

    // To String and CSV String Methods
    /**
     * Produce a String consisting of the project data with commas separating them
     *
     * @return String of CSV-String of the project
     */
    public String toCSVString() {
        return projectId + "," + projectName + "," + projectDesc + "," + student + "," + lecturer + "," + comment + ","
                + specialization + ","
                + active;
    }

    /**
     * Produce a String consisting of the project data
     *
     * @return String of String of the project
     */
    public String toString() {
        return projectId + ", " + projectName + ", " + projectDesc + ", " + student + ", " + lecturer + ", " + comment
                + ", " + specialization + ", "
                + active;
    }

    // get a randomized New ID
    /**
     * 
     * This method is used to generate a random new project ID, which can be used to
     * assign new project a unique ID.
     * 
     * @return returns a random project ID as a string
     */
    public static String getNewProjectID() {
        int ID = (int) (Math.random() * (99999 - 90000 + 1) + 90000);

        return Integer.toString(ID);
    }

    // method to add this Project to project.csv
    /**
     * 
     * This method is used to add new project to project.csv file. It does the
     * following :
     * Read data from project file
     * 
     * Check if project name field is empty. If it is, it will display a message to
     * the user and clear the tempProjectData.
     * 
     * Check if project details field is empty. If it is, it will display a message
     * to the user and clear the tempProjectData.
     * 
     * Check if project name already exists in the project.csv file. If it does, it
     * will check if the specialization of the existing project is the same.
     * 
     * If the specialization is the same, it will notify the user that a student
     * already has the same project and clear tempProjectData.
     * 
     * If the specialization is different, it will add the new project to
     * project.csv file, save the data and display a message to the user.
     */
    public void addNewProject() {
        readData project;
        ArrayList<Project> tempProjectData = new ArrayList<Project>();

        try {
            // read data from project file
            project = new readData("project");

            if (this.projectName == null) { // Check if project name field name is empty
                showMessageDialog(null, "Project Name Cannot Be Empty");
                tempProjectData.clear();
            } else if (this.projectDesc == null) { // Check if project details field name
                                                   // is empty
                showMessageDialog(null, "Project Description Cannot Be Empty");
                tempProjectData.clear();
                // if found
            } else if (project.compareName(readData.getUserN(), this.projectName) == true) {
                List<String> lines; // lines in project.csv
                boolean flag = true;
                try {
                    lines = Files.readAllLines(Paths.get("./project.csv"));
                    for (int i = 0; i < lines.size(); i++) {
                        String[] items = lines.get(i).split(","); // each line in lines

                        // Check for same project name
                        if (items[1].equals(this.projectName)) {
                            // check for same specialization
                            if (items[4].equals(this.specialization)) {
                                tempProjectData.clear(); // clear tempProjectData
                                // notify user student has same project
                                showMessageDialog(null, "A students has a same project");

                                flag = false; // set flag to false
                                break;
                            }
                        }
                    }
                    if (flag) { // if project does not exist already
                        tempProjectData = readData.getProject();
                        if (this.lecturer == null) { // if not lecturer
                            // Student left unaasigned and comment left empty and is set to active
                            tempProjectData.add(new Project(Project.getNewProjectID(), this.projectName,
                                    this.projectDesc,
                                    "Unassigned",
                                    gui.currentID, "",
                                    this.specialization,
                                    "active"));
                        } else { // if lecturer
                            tempProjectData.add(new Project(Project.getNewProjectID(), this.projectName,
                                    this.projectDesc,
                                    "Unassigned",
                                    // use replace all becasuelecturer name is not filtered yet
                                    this.lecturer.replaceAll("\\)", ""), "",
                                    this.specialization,
                                    "active"));
                        }
                        // save project data into project file
                        readData.saveProjectToFile(tempProjectData, "project");
                        tempProjectData.clear();
                        showMessageDialog(null, "Project Successfully Added");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                tempProjectData = readData.getProject();
                if (this.lecturer == null) {
                    tempProjectData.add(new Project(Project.getNewProjectID(), this.projectName,
                            this.projectDesc,
                            "Unassigned",
                            gui.currentID, "",
                            this.specialization,
                            "active"));
                } else {
                    tempProjectData.add(new Project(Project.getNewProjectID(), this.projectName,
                            this.projectDesc,
                            "Unassigned",
                            this.lecturer.replaceAll("\\)", ""), "",
                            this.specialization,
                            "active"));
                }
                readData.saveProjectToFile(tempProjectData, "project");
                tempProjectData.clear();
                showMessageDialog(null, "Project Successfully Added");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get data of Project from project.csv with a project name given
     *
     * @param pName the name of the project
     * @return Project object with the given project name
     */

    public static Project getProject(String pName) {

        // Get Project that wants to be edited
        try {
            // Read from project.csv
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get items from csv file (items = line in a file)
                String[] items = lines.get(i).split(",");

                // Find data on project to be edited
                if (pName.equals(items[1])) {
                    // Return the project in the form of a project class instance
                    return (new Project(items));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Project();
    }

    /**
     * Edit the project in project.csv file
     * 
     * @param p the project instance to edit
     */
    public static void editProject(Project p) {
        try {
            // Read from projects file and add edited projects to p
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            ArrayList<Project> tmpProjects = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                // Split items
                String[] items = lines.get(i).split(",");
                Project tmpProject = new Project(items);

                // Check if ID match, then edit that line
                if (tmpProject.getProjectId().equals(p.getProjectId())) {

                    // add edited project
                    p.setLecturer(tmpProject.getLecturer());
                    p.setComment(tmpProject.getComment());

                    tmpProjects.add(p);

                    continue;
                }
                tmpProjects.add(tmpProject);
            }

            // Save edited projects to project.csv
            readData.saveProjectToFile(tmpProjects, "project");

            showMessageDialog(null, "Project Successfully Edited");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Method to add a comment to a project in the project.csv file.
     * 
     * @param nameID  The name and ID of the project in the format "ProjectName(ID)"
     * @param comment The comment to be added to the project.
     */
    public static void addComment(String nameID, String comment) {
        try {
            Project p;
            ArrayList<Project> projects = new ArrayList<>();
            // get ID from the nameID - ProjectA(1111) -> 1111
            String id = nameID.split("\\(")[1].replaceAll("\\)", "");

            // Read from project.csv
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get items from csv file (items = a line in a file)
                String[] items = lines.get(i).split(",");
                p = new Project(items); // create new instance of project

                // if ID match, edit the comment
                if (id.equals(p.getProjectId())) {
                    p.setComment(comment);
                    projects.add(p);
                } else {
                    projects.add(p);
                }
            }
            // save the projects back to tthe csv and notify comment is succesfully added
            readData.saveProjectToFile(projects, "project");
            showMessageDialog(null, "Comment Successfully Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * This method is used to delete a project based on the name ID of the project.
     * 
     * @param nameID The name ID of the project in the format of "ProjectName(ID)"
     */
    public static void deleteProject(String nameID) {
        try {
            Project p;
            ArrayList<Project> projects = new ArrayList<>();
            // get ID from the nameID - ProjectA(1111) -> 1111
            String id = nameID.split("\\(")[1].replaceAll("\\)", "");

            // Read from project.csv
            List<String> lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get items from csv file (items = a line in a file)
                String[] items = lines.get(i).split(",");
                p = new Project(items);

                // if ID match, then dont add (continue)
                if (id.equals(p.getProjectId()))
                    continue;
                projects.add(p);
            }
            // save back the projects into csv and notify successfully deleted
            readData.saveProjectToFile(projects, "project");
            showMessageDialog(null, "Project Successfully Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}