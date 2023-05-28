import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 * 
 * AdminPageController class is a controller class that handles the actions of
 * the AdminPage view and the Administrator model.
 * It is responsible for handling the different events that occur on the
 * AdminPage view, such as adding a lecturer,administrator, or student.
 * 
 * @author Emad
 * @author Zi Hang
 * @author Reuben
 * @author Eddy
 */
public class AdminPageController {
    private AdminPage view;
    private Administrator model;

    /**
     * 
     * Constructor for the AdminPageController class.
     * 
     * @param view  The AdminPage view object.
     * @param model The Administrator model object.
     */
    public AdminPageController(AdminPage view, Administrator model) {

        this.view = view;
        this.model = model;

        this.view.addAddLectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addLect" button.
             *
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for Add Lecturer Page
                System.out.println("Panel1 : Add Lecturer - addLect");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);
                view.userName.setText("");
                view.info.setText("");
                view.info2.setText("");
                view.info3.setText("");
                view.sList.setVisible(false);
                view.sp.setVisible(false);
                view.panelTitle.setText("NEW LECTURER");
                view.enterN.setText("Lecturer name : ");
                view.panel2.setVisible(true);
                view.enterN.setBounds(10, 50, 150, 30);
                view.panelTitle.setBounds(90, 10, 200, 30);
                view.panel2.add(view.enterN);
                view.panel2.add(view.panelTitle);
            }

        });

        // Panel1 : Add Admin - addAdm : open panel 2
        this.view.addAddAdmListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addAdm" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for Add Admin Page
                System.out.println("Panel1 : Add Admin - addAdm");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);
                view.userName.setText("");
                view.info.setText("");
                view.info2.setText("");
                view.info3.setText("");
                view.sList.setVisible(false);
                view.sp.setVisible(false);
                view.panelTitle.setText("NEW ADMINISTRATOR");
                view.panelTitle.setBounds(60, 10, 300, 30);
                view.enterN.setText("Admin name : ");
                view.panel2.setVisible(true);
                view.enterN.setBounds(10, 50, 150, 30);
                view.panel2.add(view.enterN);
                view.panel2.add(view.panelTitle);
            }

        });

        // Panel1 : Add Student - addStud : open panel 2
        this.view.addAddStudListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addStud" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for Add Student Page
                System.out.println("Panel1 : Add Student - addStud");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);
                view.userName.setText("");
                view.info.setText("");
                view.info2.setText("");
                view.info3.setText("");
                view.panelTitle.setText("NEW STUDENT");
                view.enterN.setText("Student name : ");
                view.panel2.setVisible(true);
                view.enterN.setBounds(10, 50, 150, 30);
                view.panelTitle.setBounds(90, 10, 300, 30);
                view.panel2.add(view.enterN);
                view.panel2.add(view.panelTitle);
                view.panel2.add(view.sList);
                view.sList.setVisible(true);
                view.sp.setVisible(true);
            }

        });

        // Panel1 : LogOut - logOut : back to login
        this.view.addlogOutListener(new ActionListener() {

            /**
             * Handle the action event of clicking the "remLect" button.
             *
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // send user back to login
                System.out.println("Panel1 : LogOut - logOut");
                view.dispose(); // Dispose the view
                new gui(); // Start program again
            }

        });

        // Panel1 : Add Project - addP : open panel 4
        this.view.addaddPListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addP" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for Add Project Page
                System.out.println("Panel1 : Add Project - addP");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);
                view.tempProjectName.setText("");
                view.tempProjectDetails.setText("");
                view.panelTitle.setText("NEW PROJECT");
                view.enterN.setText("Please enter project name : ");
                view.panel4.setVisible(true);

                view.panelTitle.setBounds(60, 10, 300, 30);
                view.enterN.setBounds(10, 50, 160, 30);
                view.tempProjectDetails.setBounds(10, 150, 250, 30);
                view.AssignTo.setBounds(10, 180, 150, 30);
                view.aList.setBounds(10, 210, 250, 30);

                view.enterB.setBounds(70, 310, 150, 30);

                view.panel4.add(view.enterN);
                view.panel4.add(view.panelTitle);
                view.panel4.add(view.tempProjectName);
                view.panel4.add(view.enterD);
                view.panel4.add(view.tempProjectDetails);
                view.panel4.add(view.AssignTo);
                view.panel4.add(view.aList);
                view.panel4.add(view.LecturerLabel);
                view.panel4.add(view.lList);
                view.panel4.add(view.enterB);
            }

        });

        // Panel1 : View Project - viewP : open panel 5
        this.view.addviewPListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "viewP" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for View Project Page
                System.out.println("Panel1 : View Project - viewP");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);
                view.projectList.clear();

                view.panelTitle.setText("List Of Project");

                view.Plist = model.getProjectList(); // get list of projects to be viewed
                view.scrollPane.setViewportView(view.Plist);
                view.scrollPane.setBounds(10, 50, 310, 250);
                view.enterView.setBounds(10, 310, 95, 30);
                view.enterComment.setBounds(118, 310, 95, 30);
                view.enterDelete.setBounds(225, 310, 95, 30);
                view.panelTitle.setBounds(80, 10, 300, 30);
                view.panel5.add(view.panelTitle);
                view.panel5.add(view.scrollPane);
                view.panel5.add(view.enterView);
                view.panel5.add(view.enterComment);
                view.panel5.add(view.enterDelete);
                view.panel5.setVisible(true);
            }
        });

        // Panel1 : View Report - report : open panel 6
        this.view.addreportListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "report" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set components for View Report Page
                System.out.println("Panel1 : View Report - report : open panel 6");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);

                view.panelTitle.setText("REPORT");

                view.panelTitle.setBounds(110, 10, 100, 30);
                view.searchList.setBounds(10, 170, 250, 30);
                view.searchList2.setBounds(10, 170, 250, 30);

                view.panel6.add(view.panelTitle);
                view.panel6.add(view.reportListLabel);
                view.panel6.add(view.rList);

                // Search for lecturer/specs Depends on drop down
                view.searchLabel.setText("Test");
                view.panel6.add(view.searchLabel);
                view.panel6.add(view.searchList);
                view.panel6.add(view.searchList2);
                view.searchLabel.setVisible(false);
                view.searchList.setVisible(false);
                view.searchList2.setVisible(false);

                view.panel6.add(view.getReport);

                view.panel6.setVisible(true);
            }
        });

        // Panel2 : Enter New Account - enter : add new account to csv
        this.view.addenterAddListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enter" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add account to csv
                ArrayList<String> infos;
                System.out.println("Panel2 : Enter New Account - enter");
                try { // student (there is specialization)
                    infos = model.addNewUser(view.enterN.getText(), view.userName.getText(),
                            view.specialization[view.sList.getSelectedIndex()]);
                    view.info.setText(infos.get(0));
                    view.info2.setText(infos.get(1));
                    view.info3.setText(infos.get(2));
                } catch (Exception ex) { // Lecturer or admin
                    System.out.println("CATCHED");
                    infos = model.addNewUser(view.enterN.getText(), view.userName.getText(), "");
                    view.info.setText(infos.get(0));
                    view.info2.setText(infos.get(1));
                    view.info3.setText(infos.get(2));
                }
            }
        });

        // Panel3 : Add Comment to project - addComment : add commment to project.csv
        this.view.addaddCommentListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "addComment" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel3 : Add Comment to project - addComment : add commment to project.csv ");
                Project.addComment(view.projectNameID.getText(), view.comment.getText());
                view.viewP.doClick();
            }
        });

        // Panel5 : Enter View Project - enterView : show project details in a dialog
        this.view.addenterViewProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enterView" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show message dialog of project
                System.out.println("Panel5 : Enter View Project - enterView");
                // Get the project that is selected and set its data to p
                Project p = Project.getProject(view.Plist.getSelectedValue().split("\\(")[0]);
                view.project = new JTextArea("Project ID: \n" + p.getProjectId()
                        + "\n\nProject Name: \n" + p.getProjectName()
                        + "\n\nProject Description: \n" + p.getProjectDesc()
                        + "\n\nStudent: \n" + p.getStudent()
                        + "\n\nLecturer :\n" + p.getLecturer()
                        + "\n\nAssign To: \n" + p.getSpecialization()
                        + "\n\nComment :\n" + p.getComment()
                        + "\n\nThis project is " + p.getActive() + "\n");
                view.viewProjectResults.showMessageDialog(null, view.project, "Project", 1);
            }
        });

        // Panel5 : Enter Comment Project - enterEdit : change to panel3
        this.view.addenterCommentProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enterEdit" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change panel to panel3 (add comment to project)
                System.out.println("Panel5 : Enter Edit Project - enterEdit : change panel ");
                view.panel2.setVisible(false);
                view.panel3.setVisible(false);
                view.panel4.setVisible(false);
                view.panel5.setVisible(false);
                view.panel6.setVisible(false);

                view.panelTitle.setText("ADD COMMENT");
                view.panel3.add(view.panelTitle);

                view.projectNameID.setText("Project : \n" + view.Plist.getSelectedValue());
                view.panel3.add(view.projectNameID);
                view.comment.setText("Write Comment here");

                view.panel3.add(view.commentLabel);
                view.panel3.add(view.comment);

                view.panel3.add(view.addComment);
                view.panel3.setVisible(true);
            }
        });

        // Panel5 : Enter Delete Project - enterDelete : Delete selected project
        this.view.addenterDeleteProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enterDelete" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel5 : Enter Delete Project - enterDelete : Delete selected project");
                Project.deleteProject(view.Plist.getSelectedValue());
                view.viewP.doClick();
            }
        });

        // Panel5 : Enter New Project - enterB : add new project into project.csv
        this.view.addenterNewProjectListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "enterB" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel4 : Enter New Project - enterB");
                // Project(name,desc,lect,spec)
                Project p = new Project(view.tempProjectName.getText(),
                        view.tempProjectDetails.getText(),
                        ((String) view.lList.getSelectedItem()).split("\\(")[1],
                        (String) view.aList.getSelectedItem());
                p.addNewProject();

                // Set fields to default
                view.addP.doClick();
                view.tempProjectName.setText("");
                view.tempProjectDetails.setText("");
                view.aList.setSelectedIndex(0);
                view.lList.setSelectedIndex(0);
            }
        });

        // Panel6 : Get report - getreport : generate report based on data from
        // project.csv
        this.view.addgetReportListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "getReport" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Panel6 : Get report - get report");
                // Get type of report
                String rType = view.rList.getSelectedItem().toString();
                // specialization and lecturer has diff. list
                if (rType.equals("Specialization")) { // if specialization report
                    Report.showReport(rType, view.searchList.getSelectedItem().toString());
                } else if (rType.equals("Lecturers")) {// if lecturer report
                    String lecID = view.searchList2.getSelectedItem().toString().split("\\(")[1].replaceAll("\\)", "");
                    Report.showReport(rType, lecID);
                } else {
                    Report.showReport(rType, null);
                }
            }
        });

        // Panel6 : JComboBox Listener - rList : extra Search JcomboBox will appear for
        // certain options
        this.view.addrListListener(new ActionListener() {
            /**
             * Handle the action event of clicking the "rList" button.
             * 
             * @param e The ActionEvent object.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(
                        "Panel6 : JComboBox Listener - rList : extra Search JcomboBox will appear for certain options");
                ArrayList<String> list = Report.searchType(view.rList.getSelectedItem().toString());
                if (!(list == null)) { // if list is not null (not spec or lecturer choosen)
                    if (list.size() == 4) { // if it is JComboBoxfor specialization
                        view.searchLabel.setText("Specialization :");
                        view.searchList.setVisible(true);
                        view.searchList2.setVisible(false);
                        view.searchLabel.setVisible(true);
                    } else { // JComboBoxfor lecturer
                        view.searchLabel.setText("Lecturer :");
                        view.searchList.setVisible(false);
                        view.searchList2.setVisible(true);
                        view.searchLabel.setVisible(true);
                    }
                } else { // not specialization or lecturer
                    view.searchList.setVisible(false);
                    view.searchList2.setVisible(false);
                    view.searchLabel.setVisible(false);
                }
            }
        });
    }
}