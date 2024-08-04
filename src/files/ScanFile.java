/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 * this is the file input file
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ScanFile {
    
    private String fileName;
    private ArrayList<Student> students;

//    public ScanFile() {
//        this.fileName = fileName;
//    }
    
    String fileContent = "";
    
    public void fileReader(String fileName) throws IOException, FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        
        // skips the first line
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
        
        // skips the first line and reads the data from 2nd line onwards
        while (scan.hasNextLine()) {
            // to test
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }
        scan.close();
        
        System.out.println(fileContent.toString());
        
    }
    
    private String className;
    private String adminNum;
    private String studentName;
    private Integer numberOfSubjects;
    private String subjCode;
    private String subjName;
    private String subjCreds;
    private String subjScore;
    
    public void sectionData() {
        // Split the data into individual records
        String data = fileContent;
        String[] records = data.split("\n");

        // Arrays to store the data
        String[] classCodes = new String[records.length];
        String[] studentIDs = new String[records.length];
        String[] studentNames = new String[records.length];
        int[] numOfSubjects = new int[records.length];

        for (int i = 0; i < records.length; i++) {
            String[] fields = records[i].split(";");
            
            classCodes[i] = fields[0];
            studentIDs[i] = fields[1];
            studentNames[i] = fields[2];
            numOfSubjects[i] = Integer.parseInt(fields[3]);
            
            // student general information
            System.out.println("Class: " + classCodes[i]);
            System.out.println("Student ID: " + studentIDs[i]);
            System.out.println("Student Name: " + studentNames[i]);
            System.out.println("Number of Subjects: " + numOfSubjects[i] + "\n");
            
            
            

            int index = 4;
            while (index < fields.length) {
                String subjectCode = fields[index++];
                String subjectName = fields[index++];
                String subjectCredits = fields[index++];
                String subjectScore = fields[index++];
                
                // modules the student is taking
                System.out.println("Subject Code: " + subjectCode);
                System.out.println("Subject Name: " + subjectName);
                System.out.println("Subject Credits: " + subjectCredits);
                System.out.println("Subject Score: " + subjectScore);
            }

            System.out.println();
            
           
        }
        
        
    }
    
    
    
    

    public String getFileName() {
        return fileName;
    }

//    public ArrayList<Student> getStudents() {
//        return students;
//    }

    public String getClassName() {
        return className;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public String getSubjCode() {
        return subjCode;
    }

    public String getSubjName() {
        return subjName;
    }

    public String getSubjCreds() {
        return subjCreds;
    }

    public String getSubjScore() {
        return subjScore;
    }
    
    

    
    
}
