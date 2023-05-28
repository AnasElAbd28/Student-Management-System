/**
 * 
 * The Person class represents a person with userID, userName and userPassword
 * properties.
 * It contains the constructors, getters and setters for the properties.
 * It also includes a toString() method for displaying the properties and a
 * toCSVString() method for saving the properties to a csv file.
 * The currentID is a static variable that keeps track of the current user's ID.
 * 
 * @author Emad
 */
public class Person {

    public static String currentID; // current user ID
    public String userID; // persons user ID
    private String userName; // persons username
    private String userPassword; // persons password

    public Person(String userID) {
        this.userID = userID;
    }

    /**
     * 
     * Constructs a new instance of the Person class with no parameters.
     */
    public Person() {
    }

    /**
     * 
     * Constructs a new instance of the Person class with the specified user ID,
     * name, and password.
     * 
     * @param userID       the user's ID.
     * @param userName     the user's name.
     * @param userPassword the user's password.
     */
    public Person(String userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Constructors and Mutators
    /**
     * 
     * Returns the user's ID.
     * 
     * @return the user's ID.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 
     * Sets the user's ID.
     * 
     * @param userID the new user's ID.
     */
    public void setUserID(String userID) {
        this.userID = userID;

    }

    /**
     * 
     * Returns the user's name.
     * 
     * @return the user's name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * Sets the user's name.
     * 
     * @param userName the new user's name.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the user's password.
     * 
     * @return the user's password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the user's password.
     * 
     * @param userPassword the new user's password.
     */
    public void setUserPass(String userPassword) {
        this.userPassword = userPassword;

    }

    // To String method and CSV String
    /**
     * 
     * Returns a string representation of the Person object.
     * 
     * @return String representation of the Person object.
     */
    public String toString() {
        return "UserID  = " + userID + " UserName = " + userName + " Password = " + userPassword;
    }
    /**
     * 
     * Returns a string representation of the Person object in CSV Form
     * 
     * @return String representation of the Person object in CSV Form.
     */
    public String toCSVString() {
        return userID + "," + userName + "," + userPassword;
    }
}
