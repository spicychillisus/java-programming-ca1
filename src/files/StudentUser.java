/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIT/FT/2B/23 P2210979 Reyes Asher Benedict Calaminos
 * @author DIT/FT/2B/23 P2323150 Ng Yu Jie
 */

/**
 * This is the main class of the whole program 
*/

import java.io.IOException;

public class StudentUser {
    
    public static void main(String[] args) {
        ScanFile sf = new ScanFile();
        try {
            sf.fileReader("students.txt");
            sf.sectionData();
        } catch (IOException e) {
            e.getMessage();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
        
    }
}
