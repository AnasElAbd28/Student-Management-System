/**
 * 
 * The gui class is responsible for creating and managing the graphical userinterface (GUI) of the application.
 * The class contains a static field currentID that stores the ID of the current user.
 * The class contains a constructor that calls the main method again, allowing the GUI to be re-initialized.
 * The main method is the entry point of the application and creates a new instance of the HomePage view and the Person model.
 * It also creates a new instance of the HomePageController and sets the homePage to be visible.
 * 
 * @author Reuben
 * 
 */

public class gui {
    public static String currentID = "0"; // ID of current user

    // run main again
    public gui() {
        main(null);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage(); // view
        Person person = new Person(); // model

        new HomePageController(homePage, person);
        homePage.setVisible(true);
    }
}
