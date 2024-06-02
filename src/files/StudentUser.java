/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */

public class StudentUser {
    // this method stores only the main class
    // this method is working. PLEASE DO NOT TOUCH.
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        // JOptionPane inputs always returns as string so the parseInt function is required
        while (true) {
            int input = Integer.parseInt(sm.displayMenu());
            sm.checkMenuInput(input);
        }
        
        
    }
}
