/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */
import javax.swing.JOptionPane;

public class StudentUser {
    
    // this method does not have any need to be accessed outside of this class
    private static String displayMenu() {
        // create variables for the menu text
        String header = "Enter your option: \n";
        String options = "1. Display all students\n2. Search student by class\n3. Searh student by name\n4. Quit";
        
        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText); 
        return getInput; // display
        
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 1
    // gets the information from StudentManagement.java
    public static String displayAllStudents() {
        
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 2
    // gets the information from StudentManagement.java
    public static String searchStudentByClass() {
        String studentClass = JOptionPane.showInputDialog("Enter the class name to search");
        displayClassSummary(studentClass);
        return studentClass;
    }
    
    public static String displayClassSummary(String studentClass) {
        
    }
    
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 3
    // gets the information from StudentManagement.java
    public static String searchStudentByName() {
        
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 4
    // exits the program
    public static void quitProgram() {
        JOptionPane.showMessageDialog(null, "Program terminated.\nThank You!");
        System.exit(0);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // DISPLAY ERROR MESSAGE
    public static void displayError() {
        String errorMessageText = "Invalid input. Please enter a number from 1 to 4.";
        JOptionPane.showMessageDialog(null, errorMessageText, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // this method does not have any need to be accessed outside of this class
    private static void checkMenuInput(int input) {
        
        switch(input) {
            case 1:
                displayAllStudents();
                break;
            case 2:
                searchStudentByClass();
                break;
            case 3:
                searchStudentByName();
                break;
            case 4:
                quitProgram();
                break;
            default:
                displayError();
                break;
        }
    }
    
    
    
    public static void main(String[] args) {
        // JOptionPane inputs always returns as string so the parseInt function is required
        int input = Integer.parseInt(displayMenu());
        
        while (true) {
            checkMenuInput(input);
        }
        
    }
}
