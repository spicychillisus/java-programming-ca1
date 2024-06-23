/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */
/**
 * This object simulates printers in real life where you send data to it and the printer prints it out
 * @author spicychilisus
 * @author yujie please insert ur github username
 */

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Printer extends StudentManagement {

    private String allStudentContent;
    private String individualStudentContent;
    private String allStudentClassData;
    private Student student;
    
    public Printer() {
        super();
    }
    /**
     * highly suggested that the content to be compiled into one variable and not
     * a long string :D
     * allStudentContent: data taken from StudentManagement
     * individualStudentContent: data taken from StudentManagement
     * allStudentClassData: data taken from StudentManagement
     */
    
    
    // getter methods to get all student content from the student management class

    public String getAllStudentContent() {
        return allStudentContent;
    }

    public String getIndividualStudentContent() {
        return individualStudentContent;
    }

    public String getAllStudentClassData() {
        return allStudentClassData;
    }
        
    
    /*
        * You may see a object called "FileWriter" being used in the bottom methods
        * The FileWriter class in Java is typically used for writing character files.
        * It is not recommended to use FileWriter to write data directly into Microsoft Office formats 
        * such as .docx, .ppt, .xlsx, etc., as it could lead to data corruption.
        * These formats are complex and require specific libraries to handle them correctly.
        * The easiest file format for it to handle is .txt file, which is the notepad file format.
        * No external specific libraries are required to handle .txt format
        * FileWriter object must be enclosed in a try catch as there is a unreported IO exception and must
        * be handled
     */
    
     // prints out all the student data available in the school
    public void printAllStudents() {
        String fileName = "";
        fileName = "data-of-all-students.txt";
                
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getAllStudentContent());
            fw.close(); // to save resources
        } catch (IOException e) {
            printingError();
        }
    }
    
    public void printIndividualStudent() {
        String fileName = "";
        String fileNameTemplate = "data-of-student-%s.txt";
        String studentName = student.getName();
        fileName = String.format(fileNameTemplate, studentName);
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(this.individualStudentContent);
            fw.close();
        } catch (IOException e) {
            printingError();
        }
    }
    
    public void printAllStudentClass() {
        String fileName = "";
        String fileNameTemplate = "data-of-class-%s.txt";
        String studentClass = student.getStudentClass();
        fileName = String.format(fileNameTemplate, studentClass);
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(this.allStudentClassData);
            fw.close();
        } catch (IOException e) {
            printingError();
        }
    }
    
    // error message to be displayed when the printing fails
    private void printingError() {
        JOptionPane.showMessageDialog(
                null, 
                "Unable to print details, please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
        );
    }
    
    
    
}
