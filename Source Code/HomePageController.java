import java.awt.event.*;
import java.io.IOException;

/**
 * 
 * /**
 * 
 * The HomePageController class is responsible for handling the interactions
 * between the HomePage view and the Person model.
 * 
 * It creates action listeners for the login type buttons (lecturer, student,
 * administrator) and the log in button, and
 * 
 * handles the logic for logging in a user, checking their credentials, and
 * directing them to the appropriate page.
 * 
 * @author Emad
 * @author Reuben
 */
public class HomePageController {
    private HomePage homePage;
    private Person person;

    /**
     * 
     * The constructor for the HomePageController class. It takes in the home page
     * view and the person model as parameters.
     * 
     * @param homePage The view for the home page
     * @param person   The person model
     */
    public HomePageController(HomePage homePage, Person person) {
        this.homePage = homePage;
        this.person = person;

        // Log In Type
        this.homePage.addlectListener(new lectListener());
        this.homePage.addadmListener(new admListener());
        this.homePage.addstudListener(new studListener());

        // Log in Button
        this.homePage.addLogListener(new logListener());
    }

    // lect button from HomePage
    /**
     * 
     * The lectListener class is an action listener for the lecturer login button.
     * It sets the text of the user label to "LECTURER LOGIN" when the button is
     * clicked.
     */
    class lectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homePage.lecLogin();
        }

    }

    // stud button from HomePage
    /**
     * 
     * The studListener class is an action listener for the student login button.
     * It sets the text of the user label to "STUDENT LOGIN" when the button is
     * clicked.
     */
    class studListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homePage.studLogin();
        }

    }

    // adm button from HomePage
    /**
     * 
     * The admListener class is an action listener for the administrator login
     * button.
     * It sets the text of the user label to "ADMINISTRATOR LOGIN" when the button
     * is clicked.
     */
    class admListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homePage.admLogin();
        }
    }

    // log button from HomePage
    /**
     * 
     * The logListener class is an action listener for the log in button.
     * 
     * It handles the logic for logging in a user, checking their credentials, and
     * directing them to the appropriate page.
     */
    class logListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // set as admin first and edit if needed based on what type of login
                String filename = "admin";

                // if student login
                if (homePage.user.getText().compareTo("STUDENT LOGIN") == 0) {
                    filename = "student";
                }

                // if lecturer login
                else if (homePage.user.getText().compareTo("LECTURER LOGIN") == 0) {
                    filename = "lecturer";
                }

                readData r = new readData(filename);

                // checck if ID and passwrod correct
                if (r.compareUser(readData.getUserID(), readData.getUserP(), homePage.id.getText(),
                        String.valueOf(homePage.pass.getPassword())) == false) {

                    homePage.fail.setText("WRONG USER ID/PASSWORD.");
                    // if correct
                } else if (r.compareUser(readData.getUserID(), readData.getUserP(), homePage.id.getText(),
                        String.valueOf(homePage.pass.getPassword())) == true) {

                    homePage.fail.setText("Access Granted Welcome");
                    // set the current ID to the ID of user that just logged in
                    gui.currentID = homePage.id.getText();

                    if (filename.compareTo("admin") == 0) {
                        // set homePage to not be visible and run Admin Page
                        homePage.setVisible(false);
                        new AdminPageController(new AdminPage(), new Administrator());
                    } else if (filename.compareTo("lecturer") == 0) {
                        // set homePage to not be visible and run Lecturer Page
                        homePage.setVisible(false);
                        new LecturerPageController(new LecturerPage(), new Lecturer());
                    } else if (filename.compareTo("student") == 0) {
                        // set homePage to not be visible and run Student Page
                        homePage.setVisible(false);
                        new StudentPageController(new StudentPage(), new Student());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
