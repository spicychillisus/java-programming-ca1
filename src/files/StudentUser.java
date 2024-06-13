/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import javax.swing.JOptionPane;


/**
 *
 * @author asher
 */

public class StudentUser {
    
    // makes life easier if a function is called for an error message
    public static void displayMenuErrorMesage() {
        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private static int displayMainMenu() {
        String header = "Enter your option: \n";
        String options = "1. Student Enquiry System\n2. Student Admin System\n3. Quit";

        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText);
        if (getInput == null) {
            return 3; // Treat cancel as quit
        }
        try {
            return Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    private static int displayEnquiryMenu() {
        String header = "Enter your option: \n";
        String options = "1. Display all students\n2. Search student by class\n3. Search student by name\n4. Back to Main Menu";

        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText);
        if (getInput == null) {
            return 4; // Treat cancel as back to main menu
        }
        try {
            return Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
    
    // done by asher.
    private static int displayAdminMenu() {
        String header = "Enter your option: \n";
        String options = "1. Add new student\n2. Delete student\n3. Add new module for student\n4. Back to Main Menu";

        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText);
        if (getInput == null) {
            return 4; // Treat cancel as back to main menu
        }
        try {
            return Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    private static void handleEnquiryMenu(int input, StudentManagement sm) {
        switch (input) {
            case 1:
                sm.displayAllStudents();
                break;
            case 2:
                sm.searchStudentByClass();
                break;
            case 3:
                sm.searchStudentByName();
                break;
            case 4:
                // Back to main menu
                break;
            default:
                displayMenuErrorMesage();
                break;
        }
    }

    private static void handleAdminMenu(int input, StudentManagement sm) {
        switch (input) {
            case 1:
                sm.addStudent();
                break;
            case 2:
                sm.deleteStudent();
                break;
            case 3:
                sm.addModuleForStudent();
                break;
            case 4:
                // Back to main menu
                break;
            default:
                displayMenuErrorMesage();
                break;
        }
    }
    
    

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();

        while (true) {
            int mainChoice = displayMainMenu();
            switch (mainChoice) {
                case 1:
                    while (true) {
                        int enquiryChoice = displayEnquiryMenu();
                        if (enquiryChoice == 4) break; // Back to main menu
                        handleEnquiryMenu(enquiryChoice, sm);
                    }
                    break;
                case 2:
                    while (true) {
                        int adminChoice = displayAdminMenu();
                        if (adminChoice == 4) break; // Back to main menu
                        handleAdminMenu(adminChoice, sm);
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Program terminated.\nThank you!");
                    System.exit(0);
                    break;
                default:
                    displayMenuErrorMesage();
            }
        }
    }
}