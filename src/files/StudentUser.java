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
        String options = "1. Display all students\n2. Search student by class\n3. Search student by name\n4. Quit";
        
        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText); 
        return getInput; // display
        
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 1
    // gets the information from StudentManagement.java
    public static String displayAllStudents() {
        // add your code to display:
        // n = how many students starting with 1 to n students
        // k = 1 to k modules taken by student
        /*
        Student n:
        Name:
        Admin:
        Class:
        Modules Taken:
        k. *insert module code* / *insert module name in short form (eg: fundementals of programming short form is FOP) / credit units: grade
        -----------
        repeat above
        */
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 2
    // gets the information from StudentManagement.java
    public static String searchStudentByClass() {
        String studentClass = JOptionPane.showInputDialog("Enter the class name to search").toUpperCase();
        //displayClassSummary(studentClass);
        displayClassSummary("DIT/FT/2B/23");
        return studentClass;
    }
 
    public static String displayClassSummary(String studentClass) {
        // if class exists, display the number of students in the class and average gpa
        // if class does not exist, display error message
        /*
        add your code to get the student class that is equal to the class in the studentClass variable
        */
    }
    
    // this function is to display an error message if the student class cannot be found. please use it.
    private static void noStudentClass() {
        JOptionPane.showMessageDialog(null, "No student found from class!");
    }
    
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 3
    // gets the information from StudentManagement.java
    public static String searchStudentByName() {
        String studentName = "";
        studentName = JOptionPane.showInputDialog(null, "Enter the Student name to search: ");
        findStudent(studentName);
        return studentName;
    }
    
    private static String findStudent(String studentName) {
        
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 4
    // exits the program
    // this method is working. PLEASE DO NOT TOUCH.
    public static void quitProgram() {
        JOptionPane.showMessageDialog(null, "Program terminated.\nThank You!");
        System.exit(0);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // DISPLAY MENU ERROR MESSAGE
    // this method is working. PLEASE DO NOT TOUCH.
    public static void displayMenuError() {
        String errorMessageText = "Invalid input. Please enter a number from 1 to 4.";
        JOptionPane.showMessageDialog(null, errorMessageText, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // this method does not have any need to be accessed outside of this class
    // this method is working. PLEASE DO NOT TOUCH.
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
                displayMenuError();
                break;
        }
    }
    
    
    // this method is working. PLEASE DO NOT TOUCH.
    public static void main(String[] args) {
        // JOptionPane inputs always returns as string so the parseInt function is required
        int input = Integer.parseInt(displayMenu());
        checkMenuInput(input);
        
    }
}
