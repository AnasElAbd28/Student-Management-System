import java.awt.event.*;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 * 
 * The LecturerPageController class is responsible for handling the interactions
 * between the LecturerPage view and the Lecturer model.
 * 
 * @author Reuben
 */
public class LecturerPageController {
    private LecturerPage view;
    private Lecturer model;

    public LecturerPageController(LecturerPage view, Lecturer model) {
        this.view = view;
        this.model = model;

        // addProject button from Panel 1 (Menu)

        this.view.addaddProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addProject" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("addProject button from Panel 1");

                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                // Set fields to default
                view.projectName.setText("");
                view.projectDesc.setText("");
                view.studentList.setSelectedIndex(0);

                view.panelTitle.setText("ADD PROJECT");
                view.enterName.setText("Please enter project name : ");

                // Components bounds
                view.panelTitle.setBounds(80, 10, 300, 30);
                view.projectNameLabel.setBounds(10, 50, 160, 30);
                view.projectName.setBounds(110, 50, 200, 30);
                view.projectDescLabel.setBounds(10, 100, 160, 30);
                view.projectDesc.setBounds(110, 100, 200, 60);
                view.projectStudentLabel.setBounds(10, 180, 160, 30);
                view.studentList.setBounds(110, 180, 200, 30);
                view.projectSpecializationLabel.setBounds(10, 230, 160, 30);
                view.specList.setBounds(110, 230, 200, 30);
                view.enter.setBounds(80, 280, 180, 30);
                // Add components to panel2
                view.panel2.add(view.enterName);
                view.panel2.add(view.panelTitle);
                view.panel2.add(view.tempProjectName);
                view.panel2.add(view.enterDetails);
                view.panel2.add(view.tempProjectDetails);
                view.panel2.add(view.AssignTo);
                view.panel2.add(view.aList);
                view.panel2.add(view.enter);

                view.panel2.setVisible(true);
            }
        });

        // viewProject project button from Panel 1 (Menu)
        this.view.addviewProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "viewProject" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("viewProject project button from Panel 1");

                // Hide other panels
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);

                // Set the title for panel4
                view.panelTitle.setText("VIEW PROJECT");
                view.panelTitle.setBounds(80, 10, 200, 30);
                view.panel4.add(view.panelTitle);

                view.projectList.clear();

                // get project by the current lecturer
                view.Plist = new JList(Lecturer.getProjects(gui.currentID));
                view.scrollPane.setViewportView(view.Plist);
                view.scrollPane.setBounds(10, 50, 310, 100);
                view.enterView.setBounds(10, 310, 150, 30);
                view.edit.setBounds(170, 310, 150, 30);

                view.panel4.add(view.scrollPane);
                view.panel4.add(view.enterView);
                view.panel4.add(view.edit);

                view.panel4.setVisible(true);
            }
        });

        // logOut from Panel 1 (Logout)
        this.view.addlogOutListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "logOut" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
                new gui();
            }
        });

        // enter button from Panel 2 (Add Project)
        this.view.addenterAddProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enter" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("enter button from Panel 2 (Add Project)");
                Project p = new Project(view.tempProjectName.getText(),
                        view.tempProjectDetails.getText(),
                        (String) view.aList.getSelectedItem());
                p.addNewProject();

                // Set fields to default
                view.addProject.doClick();
                view.tempProjectName.setText("");
                view.tempProjectDetails.setText("");
                view.aList.setSelectedIndex(0);

            }
        });

        // enterView from Panel 4 (View Project)
        this.view.addenterViewProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enterView" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("enterView from Panel 4 (View Project)");

                // Get message using a method from Lecturer Class
                // and with param- project from list of projects
                String message = Lecturer.viewProject(view.Plist.getSelectedValue());
                // show a message dialog containing project data
                view.viewProjectResultsData = new JTextArea(message);
                view.viewProjectResults.showMessageDialog(null, view.viewProjectResultsData, "Project", 1);
            }
        });

        // edit Project from Panel 4 (View Project)
        this.view.addeditProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "edit" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("edit Project from Panel 4 (View Project)");
                // Get Project that wants to be edited
                Project p = Project.getProject(view.Plist.getSelectedValue().split("\\(")[0]);

                // Set other panels to be not visible
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);

                // Set Panel Title
                view.panelTitle.setText("Edit Project");

                // Set Project ID
                view.projectID.setText(p.getProjectId());

                // Add Components
                view.panel3.add(view.panelTitle);
                view.panel3.add(view.projectIDLabel);
                view.panel3.add(view.projectID);
                view.panel3.add(view.projectNameLabel);
                view.panel3.add(view.projectName);
                view.panel3.add(view.projectDescLabel);
                view.panel3.add(view.projectDesc);
                view.panel3.add(view.projectStudentLabel);
                view.panel3.add(view.studentList);
                view.panel3.add(view.projectSpecializationLabel);
                view.panel3.add(view.specList);
                view.panel3.add(view.projectActiveLabel);
                view.panel3.add(view.activeList);
                view.panel3.add(view.editProjectButton);

                view.projectName.setText(p.getProjectName());
                view.projectDesc.setText(p.getProjectDesc());
                view.studentList.setSelectedItem(p.getStudent());
                view.specList.setSelectedItem(p.getSpecialization());
                view.activeList.setSelectedItem(p.getActive());

                // Set panel3 to be visible
                view.panel3.setVisible(true);
            }
        });

        // editProjectButton from Panel 3 (Edit Project)
        this.view.addeditProjectButtonListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "editProjectButton" button.
             * 
             * @param e The ActionEvent object.
             */
            public void actionPerformed(ActionEvent ae) {
                System.out.println("editProjectButton from Panel 3 (Edit Project)");
                // set student to selected item and also
                String student = ((String) view.studentList.getSelectedItem()).split("\\(")[1].replaceAll("\\)", "");
                // Edit project with new data of project
                // ID is same as old
                Project.editProject(new Project(view.projectID.getText(),
                        view.projectName.getText(),
                        view.projectDesc.getText(),
                        student,
                        "",
                        "",
                        (String) view.specList.getSelectedItem(),
                        (String) view.activeList.getSelectedItem()));

                view.viewProject.doClick();
            }
        });

    }
}
