/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */
import java.util.*;
import javax.swing.JOptionPane;

public class StudentManagement {
    /*
    this file is to create the methods to create students, display students, 
    search students, search module, print statistics and etc...
    
    create 3 student objects and store them in the array
    */
    
    // FRONT END CODE TO DISPLAY STUDENTS
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 1
    // gets the information from StudentManagement.java
    public String displayAllStudents() {
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
    
    // if there are no students available
    public static void noStudentsAvailable() {
        JOptionPane.showMessageDialog(null, "No students available.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 2
    // gets the information from StudentManagement.java
    public String searchStudentByClass() {
        String studentClass = JOptionPane.showInputDialog("Enter the class name to search").toUpperCase();
        displayClassSummary(studentClass);
        return studentClass;
    }
 
    public static String displayClassSummary(String studentClass) {
        // if class exists, display the number of students in the class and average gpa
        // if class does not exist, display error message
        /*
        add your code to get the student class that is equal to the class in the studentClass variable
        suggestion: get all the students that have the same class parameter or create a method for that
        */
        
    }
    
    // this function is to display an error message if the student class cannot be found. please use it.
    public static void noStudentClass() {
        JOptionPane.showMessageDialog(null, "No student found from class!");
    }
    
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 3
    // gets the information from StudentManagement.java
    public String searchStudentByName() {
        String studentName = "";
        studentName = JOptionPane.showInputDialog(null, "Enter the Student name to search: ");
        // 
        findStudent(studentName); 
        return studentName;
    }
    
    public static String findStudent(String studentName) {
        // to be filled in later on
    }
    
    // to use if student name cannot be found in the system
    private static void cannotFindStudent(String studentName) {
        String errorMessage = String.format("Cannot find the student %s", studentName);
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // OPTION 4
    // exits the program
    // this method is working. PLEASE DO NOT TOUCH.
    public void quitProgram() {
        JOptionPane.showMessageDialog(null, "Program terminated.\nThank You!");
        System.exit(0);
    }
    // -------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------
    // DISPLAY MENU ERROR MESSAGE
    // this method is working. PLEASE DO NOT TOUCH.
    public void displayMenuError() {
        String errorMessageText = "Invalid input. Please enter a number from 1 to 4.";
        JOptionPane.showMessageDialog(null, errorMessageText, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
}
