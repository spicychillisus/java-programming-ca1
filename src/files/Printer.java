/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author DIT/FT/2B/23 P2210979 reyes asher benedict calaminos
 */
/**
 * This object simulates printers in real life where you send data to it and the printer prints it out
 * @author spicychilisus
 */

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.File;
import java.awt.Desktop;

public class Printer extends StudentManagement {
   
    private String allStudentContent;
    private String individualStudentContent;
    private String allStudentClassData;
    private Integer index;
    private String studentClass;
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

    public String getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
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
    
    private void openFile(File file) {
        if (Desktop.isDesktopSupported()) {
            // check if desktop is supported
            Desktop desktop = Desktop.getDesktop();
            try {
                // Open the file with the default application
                desktop.open(file);
            } catch (IOException e) {
                System.err.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop is not supported on this platform.");
        }
    }
        
    
    /*
        * You may see a object called "FileWriter" being used in the bottom methods
        * The FileWriter class in Java is typically used for writing character files.
        * It is not recommended to use FileWriter to write data directly into Microsoft Office formats 
        * such as .docx, .ppt, .xlsx, etc., as it could lead to data corruption.
        * These formats are complex and require specific libraries to handle them correctly.
        * The easiest file format for it to handle is .txt file, which is the notepad file format.
        * It can be only be viewed outside this project sadly
        * No external specific libraries are required to handle .txt format
        * FileWriter object must be enclosed in a try catch as there is a unreported IO exception and must
        * be handled
        * The printed file can be viewed by going to file explorer and opening the folder of this project
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
            
            openFile(new File(fileName));
        } catch (IOException e) {
            printingError();
        }
    }
    
    // do not touch
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
            openFile(new File(fileName));
        } catch (IOException e) {
            printingError();
        }
    }
   
    // prints the data of the class that is inputted
    public void printAllStudentClass() {
        String fileName = "";
        String fileNameTemplate = "data-of-class-%s.txt";
        //String studentClass = students.get(index).getStudentClass();
        //String studentClass = getAllStudentClassData();
        String studentClass = getStudentClass();
        fileName = String.format(fileNameTemplate, studentClass);
        System.out.println(fileName);
        
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getAllStudentClassData());
            printingSuccess();
            fw.close();
            openFile(new File(fileName));
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
