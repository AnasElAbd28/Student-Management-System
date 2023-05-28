import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

// DONE BY Anas Elabd
/**
 * 
 * @author Anas Elabd
 */
public class Student extends Person {
    private String spclization;
    private List<String> projectIds;
    String id = gui.currentID;

    public Student(String userID) {
        super(userID);
        this.projectIds = new ArrayList<>();
    }

    public Student() {
    }

    public Student(String userID, String userName, String userPassword, String spclization) {
        setUserID(userID);
        setUserName(userName);
        setUserPass(userPassword);
        this.spclization = spclization;

    }

    /**
     * this is a getter method that returns student specialization
     * 
     * @return the specialization of the student
     */
    public String getSpecial() {
        return spclization;
    }

    /**
     * This is a method that returns a string that has student details
     * 
     * @return a string that has student details
     */
    public String toString() {
        return "UserID  = " + getUserID() + " Password = " + getUserPassword() + " UserName = " + getUserName()
                + " Specialization = " + getSpecial();
    }

    /**
     * this is a method that returns a string that has student details to be later
     * put in csv file
     * 
     * @return a string that has student details that will be inputed to a csv file
     */
    public String toCSVString() {
        return getUserID() + "," + getUserName() + "," + getUserPassword() + "," + spclization;
    }

    /**
     * This is a method that filters project based on specialization of the student
     * and then returns a JList thta contains project list
     * 
     * @return a JList that has projects filtered
     */
    public JList<String> getProjectList() {
        DefaultListModel<String> projectList = new DefaultListModel<>();
        String[] items;
        String listview;
        List<String> lines;
        List<String> l;
        String spe = " ";
        try {
            lines = Files.readAllLines(Paths.get("./project.csv"));
            l = Files.readAllLines(Paths.get("./student.csv"));
            for (int i = 0; i < l.size(); i++) {
                String[] students = l.get(i).split(",");
                if (students[0].equals(id)) {
                    spe = students[3];
                }
            }

            for (int i = 0; i < lines.size(); i++) {
                items = lines.get(i).split(",");
                if (spe.equals(items[6])) {
                    listview = items[1] + "(" + items[4] + ")";
                    projectList.addElement(listview);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JList<>(projectList);
    }

    /**
     * this is a method that filters projects based on what the student is assigned
     * 
     * @return a JList that has projects filtered
     */
    public JList<String> getProjectList2() {
        DefaultListModel<String> projectList = new DefaultListModel<>();
        ;
        String[] items;
        String listview;
        List<String> lines;
        Student S = new Student(id);
        S.populateProjectIds();
        List<String> projectids = new ArrayList<>(S.getProjectIds());
        String spe = " ";
        try {
            lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                items = lines.get(i).split(",");
                if (projectids.contains(items[0])) {
                    listview = items[1] + "(" + items[4] + ")";
                    projectList.addElement(listview);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JList<>(projectList);
    }

    /**
     * This method reads projects from project.csv that has student assigned to it
     * and puts the project id in an arrayList
     */
    public void populateProjectIds() {
        try (BufferedReader br = new BufferedReader(new FileReader("project.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[3].equals(this.userID)) {
                    projectIds.add(values[0]);
                }
            }
        } catch (Exception e) {
            // handle the exception
        }
    }

    /**
     * This method returns the arrayList created in the method above
     * 
     * @return an arrayList that has project ids
     */
    public List<String> getProjectIds() {
        return projectIds;
    }

}
