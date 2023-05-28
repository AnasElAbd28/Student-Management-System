import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * The StudentPageController class is used to handle the actions and events for
 * the StudentPage GUI.
 * 
 * It takes in a StudentPage object and a Student object as parameters in its
 * constructor.
 * 
 * It contains ActionListeners for the buttons on the StudentPage GUI, such as
 * the logout button, view project button, and enter view project button.
 * 
 * When these buttons are clicked, the appropriate action is taken, such as
 * showing a different panel or displaying project details in a dialog box.
 * 
 * @author Anas
 */
public class StudentPageController {
    private StudentPage studentPage;
    private Student student;

    /**
     * 
     * StudentPageController is a class that controls the behavior of the
     * StudentPage GUI.
     * It is responsible for handling the events that occur when the user interacts
     * with the StudentPage.
     * 
     * @param studentPage an instance of the StudentPage class.
     * @param student     an instance of the Student class.
     */
    public StudentPageController(StudentPage studentPage, Student student) {
        this.studentPage = studentPage;
        this.student = student;

        // Panel1 : LogOut - logOut : back to login
        this.studentPage.addlogOutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel1 : LogOut - logOut");
                studentPage.setVisible(false);
                new gui();
            }

        });

        // Panel1 : View Project - viewProject : open panel 2

        this.studentPage.addviewProjectListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel1 : View Project - viewProject");
                studentPage.panel3.setVisible(false);
                studentPage.projectList.clear();

                studentPage.panelTitle.setText("List Of Project");

                studentPage.Plist = student.getProjectList();
                studentPage.scrollPane.setViewportView(studentPage.Plist);
                studentPage.scrollPane.setBounds(10, 50, 310, 250);
                studentPage.enterView.setBounds(10, 310, 95, 30);
                studentPage.panelTitle.setBounds(80, 10, 300, 30);
                studentPage.panel2.add(studentPage.panelTitle);
                studentPage.panel2.add(studentPage.scrollPane);
                studentPage.panel2.add(studentPage.enterView);
                studentPage.panel2.setVisible(true);
            }
        });

        // Panel1 : View Assigned Project - viewProject : open panel 3
        this.studentPage.addviewAListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel1 : View Assigned Projects - viewA");
                studentPage.panel2.setVisible(false);
                studentPage.projectList.clear();

                studentPage.panelTitle.setText("Project");

                studentPage.Plist = student.getProjectList2();
                studentPage.scrollPane.setViewportView(studentPage.Plist);
                studentPage.scrollPane.setBounds(10, 50, 310, 250);
                studentPage.enterView.setBounds(10, 310, 95, 30);
                studentPage.panelTitle.setBounds(80, 10, 300, 30);
                studentPage.panel3.add(studentPage.panelTitle);
                studentPage.panel3.add(studentPage.scrollPane);
                studentPage.panel3.add(studentPage.enterView);
                studentPage.panel3.setVisible(true);
            }
        });

        // Panel2 and Panel3 : Enter View Project - enterView : show project details in
        // a dialog
        this.studentPage.addenterViewProjectListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel5 : Enter View Project - enterView");
                // Get the project that is selected and set its data to p
                Project p = Project.getProject(studentPage.Plist.getSelectedValue().split("\\(")[0]);
                studentPage.project = new JTextArea("Project ID: \n" + p.getProjectId()
                        + "\n\nProject Name: \n" + p.getProjectName()
                        + "\n\nProject Description: \n" + p.getProjectDesc()
                        + "\n\nStudent: \n" + p.getStudent()
                        + "\n\nLecturer :\n" + p.getLecturer()
                        + "\n\nAssign To: \n" + p.getSpecialization()
                        + "\n\nComment :\n" + p.getComment()
                        + "\n\nThis project is " + p.getActive() + "\n");
                studentPage.viewProjectResults.showMessageDialog(null, studentPage.project, "Project", 1);
            }
        });

    }
}
