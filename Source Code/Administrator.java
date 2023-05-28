import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * 
 * This class represents an Administrator and extends the Person class.
 * It provides methods to get a list of projects and add new users (students,
 * admins or lecturers)
 * 
 * @author Reuben
 */

public class Administrator extends Person {
    /*
     * 
     * constructor for an Administrator
     */
    public Administrator() {
        super(); // Person constructor
    }

    /**
     * function to get projects. Returns JList for the use of viewing of projects
     * (admins use case)s
     * 
     * @return JList<String> containing the list of projects
     */

    public JList<String> getProjectList() {
        DefaultListModel<String> projectList = new DefaultListModel<>(); // DefaultListModel for JList
        String[] items; // each line in csv
        String listview; // String containing what it would view later in JList
        List<String> lines; // all lines in csv
        try {
            lines = Files.readAllLines(Paths.get("./project.csv"));
            for (int i = 0; i < lines.size(); i++) {
                items = lines.get(i).split(",");
                listview = items[1] + "(" + items[0] + ")"; // = Name(ID)
                projectList.addElement(listview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JList<>(projectList);
    }


    /**
     * 
     * function to add new users (students, admins or lecturers)
     * 
     * @param uType - the type of user to add (Admin name :, Lecturer name :,
     *              Student name :)
     * 
     * @param uName - the name of the user
     * 
     * @param spec  - the specialization of the user (applicable only to students)
     * 
     * @return ArrayList<String> containing error messages or generated id,
     *         password, and username
     */
    public ArrayList<String> addNewUser(String uType, String uName, String spec) {
        // consists of error msgs or msg returning generated id & password and username
        ArrayList<String> infos = new ArrayList<>();

        try {
            String fileName = "";
            String randID = "";
            String randpass = "";
            // int for number randomizer
            int min = 0;
            int max = 0;

            // Checking user types and setting their files
            if (uType.compareTo("Admin name : ") == 0) {
                fileName = "admin";
                min = 10000;
                max = 19999;
            } else if (uType.compareTo("Lecturer name : ") == 0) {
                fileName = "lecturer";
                min = 20000;
                max = 29999;
            } else if (uType.compareTo("Student name : ") == 0) {
                fileName = "student";
                min = 30000;
                max = 39999;
            }

            readData r = new readData(fileName);

            // Name exist
            if (r.compareName(readData.getUserN(), uName.toUpperCase()) == true) {
                Collections.addAll(infos, "NAME ALREADY EXIST", "", ""); // error msg for user
                readData.getPerson().clear();
                readData.getStudent().clear();
                return infos;

            } else if (uName.isEmpty()) { // Username fields is empty
                Collections.addAll(infos, "PLEASE TYPE A NAME", "", "");
                readData.getPerson().clear();
                readData.getStudent().clear();
                return infos;

                // Username not used
            } else if (r.compareName(readData.getUserN(), uName.toUpperCase()) == false) {
                // id not used
                while (r.compareID(readData.getUserID(), r.getRandID(min, max)) != true)
                    randID = r.getRandID(min, max);
                randpass = r.getPass(); // set password

                Collections.addAll(infos, "Name = " + uName.toUpperCase(), "User ID = " + randID,
                        "Password = " + randpass);

                if (fileName.compareTo("lecturer") == 0 || fileName.compareTo("admin") == 0) {
                    // save account
                    readData.getPerson().add(new Person(randID, uName.toUpperCase(), randpass));
                    readData.saveUserToFile(new Person(randID, uName.toUpperCase(), randpass), fileName);
                } else if (fileName.compareTo("student") == 0) {
                    // save account
                    readData.getStudent().add(new Student(randID, uName.toUpperCase(), randpass, spec));
                    readData.saveStudToFile(new Student(randID, uName.toUpperCase(), randpass, spec), fileName);
                }
                return infos;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infos;
    }
}