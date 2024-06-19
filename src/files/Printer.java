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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Printer {

    public String allStudentContent;
    public String individualStudentContent;
    public String allStudentClassData;
    private Student student;
    private StudentManagement sm;
    
    /**
     * @param allStudentContent String
     * @param individualStudentContent String
     * @param allStudentClassData String
     * highly suggested that the content to be compiled into one variable and not
     * a long string :D
     */
    public Printer(String allStudentContent, String individualStudentContent, String allStudentClassData) {
        this.allStudentContent = allStudentContent;
        this.individualStudentContent = individualStudentContent;
        this.allStudentClassData = allStudentClassData;
    }
    
    
    // getter methods to get all student content from the student management class
    // are they even needed?

    public String getAllStudentContent() {
        return allStudentContent;
    }

    public String getIndividualStudentContent() {
        return individualStudentContent;
    }

    public String getAllStudentClassData() {
        return allStudentClassData;
    }

    // maybe this method can be used outside this class hehe
    public String getTime() {
        String time = "";
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        time = dtf.format(ldt);
        return time;
    }
    
    
    
    /***
     * Need to compile the content and the time content was generated
     * @return collateAllStudentContent String
     */
    
    public String collateAllStudentContent() {
        String allData = ""; // initialise
        String time = getTime();
        allData = """
                  %s
                  %s
                  """;
        allData = String.format(allData, this.allStudentContent, time);

    }
    
    /**
     * Checking if the content is being printed is important as when the
     * data is printed it's an irreversible task so it's very important if the data is checked before printing
     * @return confirmMessage String
     */
    
    public String confirmationMessage() {
         String confirmMessage = "Are you sure the content here is correct?\n";
         return confirmMessage;
    }
    
    public void confirmAllStudentsContent() {
        String contentCheck = confirmationMessage() + this.allStudentContent;
        int confirm = JOptionPane.showConfirmDialog(
                null, 
                contentCheck,
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            printAllStudents();
        } 
    }
    
    public void confirmIndividualStudentContent() {
        String contentCheck = confirmationMessage() + this.individualStudentContent;
        int confirm = JOptionPane.showConfirmDialog(
                null, 
                contentCheck,
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            printIndividualStudent();
            
        } 

    }
    
    public void confirmAllStudentClassData() {
        String contentCheck = confirmationMessage() + this.allStudentClassData;
        int confirm = JOptionPane.showConfirmDialog(
                null, 
                contentCheck,
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            printIndividualStudent();
            
        } 
        
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
        //fileName = String.format(fileNameTemplate);
                
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(this.allStudentContent);
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
