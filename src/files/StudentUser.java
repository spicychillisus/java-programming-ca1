/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author asher
 */

/**
 * This is the main class of the whole program 
*/


public class StudentUser {

    private static String displayHeaderMessage() {
        return "Enter your option: \n";
    }
    
    private static int displayMainMenu() {
        String header = displayHeaderMessage();
        String options = "1. Student Enquiry System\n2. Student Admin System\n3. GPA report\n4. Quit";

        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText);
        if (getInput == null) {
            return 4; // Treat cancel as quit
        }
        try {
            return Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    private static int displayEnquiryMenu() {
        String header = displayHeaderMessage();
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
        String header = displayHeaderMessage();
        String menuText = "";
        
        int[] indices = {1, 2, 3, 4, 5};
        String[] options = {
            "Add new student", 
            "Delete student", 
            "Add new module for student", 
            "Print out student statistics",
            "Back to Main Menu"
        };
        
        menuText += header; // initialise with header once
        
        for (int i = 0; i < options.length; i++) {
            menuText += String.format("%d. %s\n", indices[i], options[i]);
        }

        String getInput = JOptionPane.showInputDialog(null, menuText);
        if (getInput == null) {
            return 5; // Treat cancel as back to main menu
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
                // back to main menu
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
                displayPrintOutStudentStatisticMenu();
                break;
            case 5:
                // return back to menu
                break;
            default:
                displayMenuErrorMesage();
                break;
        }
    }
    
    private static double getDoubleInput(String message, String errorMessage) {
        double input = -1;
        while (input < 0) {
            try {
                String inputStr = JOptionPane.showInputDialog(message);
                if (inputStr == null) {
                    JOptionPane.showMessageDialog(null, errorMessage);
                } else {
                    input = Double.parseDouble(inputStr);
                    if (input < 0) {
                        JOptionPane.showMessageDialog(null, errorMessage);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        } 
        return input;
    }
    
    private static void displayPrintOutStudentStatisticMenu() {
        String display = "";
        int input = 0;
        display = """
                  1. Print out individual student statistic
                  2. Print out class statistic
                  3. Print out all student statistics
                  """;
        input = Integer.parseInt(JOptionPane.showInputDialog(display));
        handlePrintStudentStatisticMenu(input);
    }
    
    private static void handlePrintStudentStatisticMenu(int input) {
        StudentManagement sm = new StudentManagement();
        
        /**
         * The printer object is one of the advanced feature that was implemented
         * The purpose of the printer is to... it's quite obvious: to print out the student content in a .txt file
         * @author asher
         * hardest part was really sm.getAllStudents();
         */
        Printer print = new Printer();
        
        switch (input) {
            case 1:
                ArrayList data = sm.getStudentByName();
                print.setIndex(Integer.parseInt(data.get(0).toString()));
                print.setIndividualStudentContent(data.get(1).toString());
                print.printIndividualStudent();
                break;
            case 2:
                print.setAllStudentClassData(sm.getStudentByClass());
                print.printAllStudentClass();
                break;
            case 3:
                String allStudentsToPrint = sm.getAllStudents();
                print.setAllStudentContent(allStudentsToPrint);
                System.out.println(allStudentsToPrint);
                System.out.println(allStudentsToPrint.length());
                print.printAllStudents();
                break;
            default:
                displayMenuErrorMesage();
                break;
        }
    }
    
    // makes life easier if a function is called for an error message
    public static void displayMenuErrorMesage() {
        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void terminateProgram() {
        JOptionPane.showMessageDialog(null, "Program terminated.\nThank you!");
        System.exit(0);
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
                        if (adminChoice == 5) break; // Back to main menu
                        handleAdminMenu(adminChoice, sm);
                    }
                    break;
                case 3:
                    double minGPA = getDoubleInput("Enter minimum GPA: ", "Invalid input. Please enter a valid GPA");
                    double maxGPA = getDoubleInput("Enter maximum GPA: ", "Invalid input. Please enter a valid GPA");
                    sm.generateGPAReport(minGPA, maxGPA);
                    break;
                case 4:
                    terminateProgram();
                    break;
                default:
                    displayMenuErrorMesage();
            }
        }
    }
}