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
    
    public static String displayMenuText() {
        // create variables for the menu text
        String header = "Enter your option: \n";
        String options = "1. Display all students\n2. Search student by class\n3. Searh student by name\n4. Quit";
        
        String menuText = header + options;
        String getInput = JOptionPane.showInputDialog(null, menuText); 
        return getInput; // display
        
    }
    
    public static String checkMenuInput(int input) {
        
        String output = "";
        
        switch(input) {
            case 1:
                output = displayAllStudentReport();
                break;
            case 2:
                output = searchStudentByClass();
                break;
            case 3:
                output = searchStudentByName();
                break;
            case 4:
                output = quitProgram();
                break;
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        
        // JOptionPane inputs always returns as string so the parseInt function is required
        int input = Integer.parseInt(displayMenuText());
        checkMenuInput(input);
    }
}
