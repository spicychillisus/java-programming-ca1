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
 */

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Printer extends StudentManagement {
   
    private String allStudentContent;
    private String individualStudentContent;
    private String allStudentClassData;
    private Integer index;
    // create getter and setter methods
    
    // inherit the properties from the parent class
    public Printer () {
        super();
    }
    
    // getter methods to get all student content from the student management class

    public String getAllStudentContent() {
        return this.allStudentContent;
    }
    
    public void setAllStudentContent(String allStudentContent) {
        this.allStudentContent = allStudentContent;
    }
    
    public Integer getIndex() {
        return this.index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndividualStudentContent() {
        return individualStudentContent;
    }
    
    public void setIndividualStudentContent(String individualStudentContent) {
        this.individualStudentContent = individualStudentContent;
    }

    public String getAllStudentClassData() {
        return allStudentClassData;
    }

    public void setAllStudentClassData(String allStudentClassData) {
        this.allStudentClassData = allStudentClassData;
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
     // COMPLETED! DO NOT TOUCH! IT IS WORKING!
    public void printAllStudents() {
        String fileName = "";
        fileName = "data-of-all-students.txt";
                
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getAllStudentContent());
            printingSuccess();
            fw.close(); // to save resources
        } catch (IOException e) {
            printingError();
        }
    }
    
    // in progress
    public void printIndividualStudent() {
        String fileName = "";
        String fileNameTemplate = "data-of-student-%s.txt";
        String studentName = students.get(index).getName();
        fileName = String.format(fileNameTemplate, studentName);
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getIndividualStudentContent());
            printingSuccess();
            fw.close();
        } catch (IOException e) {
            printingError();
        }
    }
   
    public void printAllStudentClass() {
        String fileName = "";
        String fileNameTemplate = "data-of-class-%s.txt";
        String studentClass = students.get(index).getStudentClass();
        fileName = String.format(fileNameTemplate, studentClass);
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(this.allStudentClassData);
            printingSuccess();
            fw.close();
        } catch (IOException e) {
            printingError();
        } 
    }
    
    private static void printingSuccess() {
        JOptionPane.showMessageDialog(
                null,
                "Successfully printed.",
                "Printed",
                JOptionPane.INFORMATION_MESSAGE
        );
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
