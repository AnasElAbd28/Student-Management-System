import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 
 * The readData class is responsible for reading data from a CSV file and
 * storing it in various ArrayLists.
 * 
 * The class contains several ArrayLists such as user, userP, userN, spcllist,
 * spclization, p, s, and proJ which are used to store the data read from the
 * CSV file.
 * 
 * The class is used to read data from CSV files and store it in a useful format
 * for the rest of the application.
 */
public class readData {
    public static String fileName;
    protected static ArrayList<String> user = new ArrayList<>();
    protected static ArrayList<String> userP = new ArrayList<>();
    protected static ArrayList<String> userN = new ArrayList<>();
    protected static ArrayList<String> spcllist = new ArrayList<>();
    private static ArrayList<String> spclization = new ArrayList<>();
    private static ArrayList<Person> p = new ArrayList<>();
    private static ArrayList<Student> s = new ArrayList<>();
    private static ArrayList<Project> proJ = new ArrayList<>();

    public readData() {

    }

    /**
     * Constructor which takes a `fileName` parameter, reads the data from the
     * corresponding file and stores it in the ArrayLists.
     *
     * @param fileName name of the file to be read
     * @throws IOException
     */
    public readData(String fileName) throws IOException {
        this.fileName = fileName;
        String spcl = "";
        String comment = "";
        String active = "";
        String student = "";
        String lecturer = "";

        List<String> lines = Files.readAllLines(Paths.get("./" + fileName + ".csv"));
        for (int i = 0; i < lines.size(); i++) {
            String[] items = lines.get(i).split(",");
            String userID = items[0];
            String userName = items[1];
            String passW = items[2];
            if (fileName.compareTo("student") == 0) {
                spcl = items[3];
                spclization.add(spcl);
                s.add(new Student(userID, userName, passW, spcl));
                p.add(new Person(userID, userName, passW));
            } else if (fileName.compareTo("project") == 0) {
                student = items[3];
                lecturer = items[4];
                comment = items[5];
                spcl = items[6];
                active = items[7];
                proJ.add(new Project(userID, userName, passW, student, lecturer, comment, spcl, active));
            }

            user.add(userID);
            userP.add(passW);
            userN.add(userName);
            spcllist.add(spcl);
        }

    }

    // Mutators and Accessor
    /**
     * @return ArrayList of user ids
     */
    public static ArrayList<String> getUserID() {

        return user;
    }

    /**
     * @return ArrayList of user passwords
     */
    public static ArrayList<String> getUserP() {

        return userP;
    }

    /**
     * @return ArrayList of person objects
     */
    public static ArrayList<Person> getPerson() {
        return p;
    }

    /**
     * @return ArrayList of student objects
     */
    public static ArrayList<Student> getStudent() {
        return s;
    }

    /**
     * @return ArrayList of specializations
     */
    public static ArrayList<String> getSpcl() {
        return spcllist;
    }

    /**
     * @return ArrayList of usernames
     */
    public static ArrayList<String> getUserN() {
        return userN;
    }

    /**
     * @return ArrayList of projects
     */
    public static ArrayList<Project> getProject() {
        return proJ;
    }

    // adds lecturer or admin user
    /**
     * 
     * The saveUserToFile method takes in a Person object and a filename as
     * parameters and saves the Person object's data to the specified CSV file.
     * 
     * @param p        a Person object containing the user data
     * @param filename the name of the CSV file to save the user data to
     * @throws IOException
     */
    public static void saveUserToFile(Person p, String filename) throws IOException {

        StringBuilder sb = new StringBuilder();

        List<String> lines = Files.readAllLines(Paths.get("./" + filename + ".csv"));

        for (int i = 0; i < lines.size() + 1; i++) {
            if (i == lines.size()) { // if entered all data from "filename".csv
                sb.append(p.toCSVString() + "\n");
            } else {
                sb.append(lines.get(i) + "\n");
            }
        }
        Files.write(Paths.get("./" + filename + ".csv"), sb.toString().getBytes());

    }

    // Save students in the student.csv file
    /**
     * 
     * The saveStudToFile method takes in a Student object and a filename as
     * parameters and saves the Student object's data to the specified CSV file.
     * 
     * @param s        a Student object containing the student data
     * @param filename the name of the CSV file to save the student data to
     * @throws IOException
     */
    public static void saveStudToFile(Student s, String filename) throws IOException {

        StringBuilder sb = new StringBuilder();

        List<String> lines = Files.readAllLines(Paths.get("./" + filename + ".csv"));

        for (int i = 0; i < lines.size() + 1; i++) {
            if (i == lines.size()) { // if entered all data from "filename".csv
                sb.append(s.toCSVString() + "\n");
            } else {
                sb.append(lines.get(i) + "\n");
            }
        }
        Files.write(Paths.get("./" + filename + ".csv"), sb.toString().getBytes());

    }

    // Save projects to file
    /**
     * 
     * The saveProjectToFile method takes in an ArrayList of Project objects and a
     * filename as parameters and saves the Project objects' data to the specified
     * CSV file.
     * 
     * @param d3       an ArrayList of Project objects containing the project data
     * @param filename the name of the CSV file to save the project data to
     * @throws IOException
     */
    public static void saveProjectToFile(ArrayList<Project> d3, String filename) throws IOException {
        // Empty the file
        PrintWriter writer = new PrintWriter(filename);
        writer.close();

        // Write to file "filename"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d3.size(); i++)
            sb.append(d3.get(i).toCSVString() + "\n");
        Files.write(Paths.get("./" + filename + ".csv"), sb.toString().getBytes());
    }

    /**
     * 
     * The compareUser method compares an entered user ID and password with the ID
     * and password from a CSV file.
     * 
     * @param u    an ArrayList of user IDs
     * @param p    an ArrayList of passwords
     * @param ID   the entered user ID
     * @param pass the entered password
     * @return a boolean value indicating if the entered ID and password match the
     *         data in the CSV file
     */
    public boolean compareUser(ArrayList<String> u, ArrayList<String> p, String ID, String pass) {
        boolean check = false;
        int index = -1;
        if (u.indexOf(ID) != -1) {
            index = u.indexOf(ID);
            if (p.get(index).compareTo(pass) == 0) {
                check = true;
            }
        }
        return check;
    }

    /**
     * 
     * The compareID method compares an entered user ID with the IDs from a CSV
     * file.
     * 
     * @param u  an ArrayList of user IDs
     * @param id the entered user ID
     * @return a boolean value indicating if the entered ID matches an ID in the CSV
     *         file
     */
    public boolean compareID(ArrayList<String> u, String id) {
        boolean check = false;

        if (u.indexOf(id) != -1) {
            check = true;
        } else {
            check = false;
        }

        return check;

    }

    /**
     * 
     * The compareName method compares an entered user name with the names from a
     * CSV file.
     * 
     * @param u  an ArrayList of user names
     * @param nm the entered user name
     * @return a boolean value indicating if the entered name matches a name in the
     *         CSV file
     */
    public boolean compareName(ArrayList<String> u, String nm) {
        boolean check = false;

        if (u.indexOf(nm) != -1) {
            check = true;
        } else {
            check = false;
        }

        return check;

    }

    /**
     * 
     * The compareSpcl method compares an entered user specialization with the
     * specializations from a CSV file.
     * 
     * @param u    an ArrayList of user specializations
     * @param spcl the entered user specialization
     * @return a boolean value indicating if the entered specialization matches a
     *         specialization in the CSV file
     */
    public boolean compareSpcl(ArrayList<String> u, String spcl) {
        boolean check = false;

        if (u.indexOf(spcl) != -1) {
            check = true;
        } else {
            check = false;
        }

        return check;
    }

    /**
     * 
     * The getPass method generates a random password.
     * 
     * @return a randomly generated password
     */
    public String getPass() {
        char[] Cletter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z' };

        char[] Sletter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w',
                'x', 'y', 'z' };

        char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        char[] symbol = { '!', '@', '#', '$', '%', '&', '*', '-', '_', '+', '=' };
        // int min = 10000;
        // int max = 19999;

        // char random = (symbol[new Random().nextInt(symbol.length)]);
        // System.out.println(random);
        String pass = "";

        for (int i = 0; i < 2; i++) {
            pass += (Sletter[new Random().nextInt(Sletter.length)]);

        }

        for (int i = 0; i < 3; i++) {
            pass += (Cletter[new Random().nextInt(Cletter.length)]);

        }

        pass += (symbol[new Random().nextInt(symbol.length)]);
        pass += (numbers[new Random().nextInt(numbers.length)]);
        pass += (numbers[new Random().nextInt(numbers.length)]);

        return pass;

    }

    /**
     * 
     * This method is used to generate a random ID number within a specified range.
     * 
     * @param min The minimum value of the ID number.
     * @param max The maximum value of the ID number.
     * 
     * @return A randomly generated ID number as a string.
     */
    public String getRandID(int min, int max) {

        int b = (int) (Math.random() * (max - min + 1) + min);

        return Integer.toString(b);
    }

    // get ArrayList containing all students - Eddy
    /**
     * 
     * This method is used to get a list of all students from the student.csv file.
     * 
     * @return An ArrayList containing all students in the student.csv file.
     */
    public static ArrayList<String> getStudentList() {
        ArrayList<String> students = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("./student.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get each line(items) from project.csv and add it into students ArrayList
                String[] line = lines.get(i).split(",");
                // line[1] : Name, line[0] : ID
                students.add(line[1] + "(" + line[0] + ")");
            }
        } catch (Exception e) {
            // Error msg print
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return students;
    }

    // get ArrayList containing all lecturer - Eddy
    /**
     * 
     * This method is used to get a list of all lecturers from the lecturer.csv
     * file.
     * 
     * @return An ArrayList containing all lecturers in the lecturer.csv file.
     */
    public static ArrayList<String> getLecturerList() {
        ArrayList<String> lecturers = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("./lecturer.csv"));
            for (int i = 0; i < lines.size(); i++) {
                // get each line(items) from project.csv and add it into students ArrayList
                String[] line = lines.get(i).split(",");
                // line[1] : Name, line[0] : ID
                lecturers.add(line[1] + "(" + line[0] + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lecturers;
    }

}
