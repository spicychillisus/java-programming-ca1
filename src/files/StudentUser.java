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
    
    private static int displayMenu() {
        // create variables for the menu text
        String header = "Enter your option: \n";
        String options = "1. Display all students\n2. Search student by class\n3. Search student by name\n4. Quit";
        
        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText); 
        return Integer.parseInt(getInput); // display
        
    }
    
    private static void checkMenuInput(int input) {
        
        StudentManagement sm = new StudentManagement();
        
        switch(input) {
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
                sm.quitProgram();
                break;
            default:
                try {
                    sm.displayMenuError();
                } catch (NumberFormatException e) {
                    sm.displayMenuError();
                }
                break;
        }
    }
    // this method is working. PLEASE DO NOT TOUCH.
    public static void main(String[] args) {
        // JOptionPane inputs always returns as string so the parseInt function is required
        while (true) {
            int input = displayMenu();
            checkMenuInput(input);
        }
        
        
    }
}
