package files;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author DIT/FT/2B/23 P2210979 reyes asher benedict calaminos
 * @author DIT/FT/2B/23 P2323150 Ng Yu Jie
 */
import java.util.*;
import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManagement {
    protected ArrayList<Student> students = new ArrayList<>();
    private ScanFile scan = new ScanFile();
    
    public StudentManagement() {
        
        this.scan = scan;
        this.students = students;
        // member A
        // Adding dummy student data

        // Adding student data with modules
        Student student1 = new Student("p1234567", "John Tan", "DIT/FT/2A/02");
        student1.addModule(new Module("ST0509", "Java", 4, 80));
        student1.addModule(new Module("ST0502", "FOP", 6, 75));
        student1.calculateGPA();
        students.add(student1);

        Student student2 = new Student("p222222", "Peter Goh", "DAAA/FT/2A/03");
        student2.addModule(new Module("ST0501", "FED", 5, 90));
        student2.addModule(new Module("ST0502", "FOP", 6, 78));
        student2.addModule(new Module("ST2413", "FOC", 4, 65.5));
        student2.addModule(new Module("SP108B", "ECG", 4, 81));
        student2.calculateGPA();
        students.add(student2);

        Student student3 = new Student("p333333", "Jack Lim", "DIT/FT/2A/04");
        student3.addModule(new Module("ST0503", "BED", 6, 55.5));
        student3.addModule(new Module("ST0504", "MAD", 5, 86));
        student3.addModule(new Module("ST0502", "FOP", 6, 66));
        student3.calculateGPA();
        students.add(student3);
    }
    
    private String newStudAdminNum;
    private String newStudName;
    private String newStudClass;
    private String newStudModCode;
    private String newStudModName;
    private int newStudCredUnit;
    private double newStudMarks;
    
    public void addStudentDataFromFile() {
        try {
            scan.fileReader("students.txt");
            scan.sectionData();
            
            // get the new student variables from the scanfile.java
            newStudAdminNum = scan.getAdminNum();
            newStudName = scan.getStudentName();
            newStudClass = scan.getClassName();

            // get the modules that the student is taking
            newStudModCode = scan.getSubjCode();
            newStudModName = scan.getSubjName();
            newStudCredUnit = Integer.parseInt(scan.getSubjCreds());
            newStudMarks = Double.parseDouble(scan.getSubjScore());
            
            // add new student
            Student newStudent = new Student(newStudAdminNum, newStudName, newStudClass);
            newStudent.addModule(new Module(newStudModCode, newStudModName, newStudCredUnit, newStudMarks));
            students.add(newStudent);
            
            
            System.out.println(newStudAdminNum);
            System.out.println(students);
            
            
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    public void addNewStudents(String adminNumber, String name, String studentClass, List<Module> modules) {
        Student newStudent = new Student(adminNumber, name, studentClass);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Add a method to save student data to file
    public void saveStudentsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(students.size()));
            writer.newLine();
            for (Student student : students) {
                writer.write(student.getStudentClass() + ";" + student.getAdminNumber() + ";" + student.getName() + ";" + student.getModules().size() + ";");
                for (Module module : student.getModules()) {
                    writer.write(module.getModuleCode() + ";" + module.getModuleName() + ";" + module.getCreditUnit() + ";" + module.getMarks() + ";");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    


    

    public void displayAllStudents() {
        if (students.isEmpty()) {
            noStudentsAvailable();
            return;
        }

        StringBuilder sb = new StringBuilder();
        int maxStudents = Math.min(students.size(), 4);
        for (int i = 0; i < maxStudents; i++) {
            Student student = students.get(i);
            sb.append("Student ").append(i + 1).append(":\n")
                    .append("Name: ").append(student.getName()).append("\n")
                    .append("Admin: ").append(student.getAdminNumber()).append("\n")
                    .append("Class: ").append(student.getStudentClass()).append("\n")
                    .append("Modules Taken:\n");

            ArrayList<Module> modules = student.getModules();
            for (int j = 0; j < modules.size(); j++) {
                Module module = modules.get(j);
                sb.append(j + 1).append(". ")
                        .append(module.getModuleCode()).append(" / ")
                        .append(module.getModuleName()).append(" / ")
                        .append("Credit Units: ").append(module.getCreditUnit()).append(" / ")
                        .append("Marks: ").append(module.getMarks()).append("\n");
            }
            sb.append("-----------\n");
        }

        // only allow 4 students to be displayed in the JOptionPane. any more will make
        // the display look messy
        if (students.size() > 4) {
            int remainingStudents = students.size() - 4;
            sb.append("and ").append(remainingStudents).append(" more student");
            if (remainingStudents > 1) {
                sb.append("s");
            }
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    // for the printer constructor
    public String getAllStudents() {
        if (students.isEmpty()) {
            return "No students available";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            sb.append("Student ").append(i + 1).append(":\n")
                    .append("Name: ").append(student.getName()).append("\n")
                    .append("Admin: ").append(student.getAdminNumber()).append("\n")
                    .append("Class: ").append(student.getStudentClass()).append("\n")
                    .append("Modules Taken:\n");

            ArrayList<Module> modules = student.getModules();
            for (int j = 0; j < modules.size(); j++) {
                Module module = modules.get(j);
                sb.append(j + 1).append(". ")
                        .append(module.getModuleCode()).append(" / ")
                        .append(module.getModuleName()).append(" / ")
                        .append("Credit Units: ").append(module.getCreditUnit()).append(" / ")
                        .append("Marks: ").append(module.getMarks()).append("\n");
            }
            sb.append("-----------\n");
        }

        return sb.toString();
    }
    
    // ca2
    public ArrayList getStudentDataByName(String searchContent, ArrayList<Student> studentList) {
        String studentName = searchContent.trim();
        ArrayList data = new ArrayList<>();
        try {
            //studentName = JOptionPane.showInputDialog("Enter the Student name to search: ").trim();
            StringBuilder sb = new StringBuilder();
            boolean found = false;
    

            int index = 0;
            for (Student student : studentList) {
                if (student.getName().equalsIgnoreCase(studentName)) {
                    found = true;
                    sb.append("Name: ").append(student.getName()).append("\n")
                      .append("Admin: ").append(student.getAdminNumber()).append("\n")
                      .append("Class: ").append(student.getStudentClass()).append("\n")
                      .append("GPA: ").append(student.getGPA()).append("\n")
                      .append("Modules Taken:\n");
    
                    ArrayList<Module> modules = student.getModules();
                    for (int j = 0; j < modules.size(); j++) {
                        Module module = modules.get(j);
                        sb.append(j + 1).append(". ")
                          .append(module.getModuleCode()).append(" / ")
                          .append(module.getModuleName()).append(" / ")
                          .append("Credit Units: ").append(module.getCreditUnit()).append(" / ")
                          .append("Marks: ").append(module.getMarks()).append("\n");
                    }
                    data.add(index);
                }
                index++;
            }
    
            if (!found) {
                data.add("No student found with that name");
                return data;
            }
            
            data.add(sb.toString());
            //System.out.println(data);
            return data;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No student found with that name");
            return data;
        }
        
       
    }
    
    public Map<String, Student> searchStudentByClass(String searchClass) {
        String studentClass = searchClass.toUpperCase();
        Map<String, Student> studentMap = new HashMap<>();
        int studentCount = 0;
        double totalGPA = 0.0;

        for (Student student : students) {
            if (student.getStudentClass().equalsIgnoreCase(studentClass)) {
                studentCount++;
                totalGPA += student.getGPA();
                
                Map<String, Object> studentDetails = new HashMap<>();
                studentDetails.put("Student", student);
                studentDetails.put("Modules", student.getModules());
                
                studentMap.put(student.getName(), student);
            }
        }

        if (studentCount == 0) {
            Map<String, Object> noResults = new HashMap<>();
            noResults.put("Message", "No students found");
            studentMap.put("No students found", null); // Marker for no results
        } else {
            double averageGPA = totalGPA / studentCount;
            
        }

        return studentMap;
    }
    
    // was used in ca1
    public void searchStudentByName(String studentName) {
        //String studentName = JOptionPane.showInputDialog("Enter the Student name to search: ").trim();
        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                found = true;
                sb.append("Name: ").append(student.getName()).append("\n")
                        .append("Admin: ").append(student.getAdminNumber()).append("\n")
                        .append("Class: ").append(student.getStudentClass()).append("\n")
                        .append("GPA: ").append(student.getGPA()).append("\n")
                        .append("Modules Taken:\n");

                ArrayList<Module> modules = student.getModules();
                for (int j = 0; j < modules.size(); j++) {
                    Module module = modules.get(j);
                    sb.append(j + 1).append(". ")
                            .append(module.getModuleCode()).append(" / ")
                            .append(module.getModuleName()).append(" / ")
                            .append("Credit Units: ").append(module.getCreditUnit()).append(" / ")
                            .append("Marks: ").append(module.getMarks()).append("\n");
                }
            }
        }

        if (!found) {
            cannotFindStudent(studentName);
            return;
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    

    // for printing purposes
    public ArrayList getStudentByClass() {
        String studentClass = "";
        ArrayList data = new ArrayList<>();

        try {
            studentClass = JOptionPane.showInputDialog("Enter the class name to search").toUpperCase();
            int studentCount = 0;
            double totalGPA = 0.0;
            StringBuilder sb = new StringBuilder();

            // int index = 0;

            for (Student student : students) {
                if (student.getStudentClass().equalsIgnoreCase(studentClass)) {
                    studentCount++;
                    totalGPA += student.getGPA();
                    sb.append("Name: ").append(student.getName()).append("\n")
                            .append("Admin: ").append(student.getAdminNumber()).append("\n")
                            .append("GPA: ").append(student.getGPA()).append("\n")
                            .append("-----------\n");

                }

            }

            if (studentCount == 0) {
                noStudentClass();
                // return;
            }

            double averageGPA = totalGPA / studentCount;
            sb.append("Number of students in class ").append(studentClass).append(": ").append(studentCount)
                    .append("\n")
                    .append("Average GPA: ").append(String.format("%.2f", averageGPA));

            data.add(sb.toString());
            data.add(studentClass);

            return data;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No student found from class!");
            return data;
        }

    }
    
    

    // Member B
    public void addStudent() {
        String name = getInput("Enter name:", "Name cannot be empty. Please enter a valid name.");
        if (name == null)
            return; // Cancel handling

        String adminNumber = getInput("Enter Admin:",
                "Admin number cannot be empty. Please enter a valid admin number.");
        if (adminNumber == null)
            return; // Cancel handling

        String studentClass = getInput("Enter Class:", "Class cannot be empty. Please enter a valid class.");
        if (studentClass == null)
            return; // Cancel handling

        Student student = new Student(adminNumber, name, studentClass);

        int numberOfModules = getIntInput("Enter number of Modules Taken:",
                "Number of modules must be at least 1. Please enter a valid number.", 1, Integer.MAX_VALUE);
        if (numberOfModules == -1)
            return; // Cancel handling

        for (int i = 1; i <= numberOfModules; i++) {
            addModuleToStudent(student, i);
        }

        student.calculateGPA(); // 3.5
        student.calculateGPA(); // 3.5??
        student.calculateGPA(); // 3.5?
        
        // add module
        student.calculateGPA(); // 2.0
        student.calculateGPA(); // 
        student.calculateGPA();
        
        
        
        students.add(student);
        JOptionPane.showMessageDialog(null, "Student added successfully:\n" + student);
    }

    private void addModuleToStudent(Student student, int moduleIndex) {
        String moduleCode = getInput("Enter Module Code for module " + moduleIndex + ":",
                "Module code cannot be empty. Please enter a valid module code.");
        if (moduleCode == null)
            return; // Cancel handling

        String moduleName = getInput("Enter Module Name for module " + moduleIndex + ":",
                "Module name cannot be empty. Please enter a valid module name.");
        if (moduleName == null)
            return; // Cancel handling

        int creditUnit = getIntInput("Enter Credit Unit for module " + moduleIndex + ":",
                "Credit units must be at least 1. Please enter a valid number.", 1, Integer.MAX_VALUE);
        if (creditUnit == -1)
            return; // Cancel handling

        int marks = getIntInput("Enter Marks for module " + moduleIndex + ":",
                "Marks must be between 0 and 100. Please enter a valid number.", 0, 100);
        if (marks == -1)
            return; // Cancel handling

        Module module = new Module(moduleCode, moduleName, creditUnit, marks);
        student.addModule(module);
    }

    public void deleteStudent() {
        String adminNumber = getInput("Enter Admin Number of student to delete:",
                "Admin number cannot be empty. Please enter a valid admin number.");
        if (adminNumber == null)
            return; // Cancel handling

        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getAdminNumber().equals(adminNumber)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) {
            students.remove(studentToDelete);
            JOptionPane.showMessageDialog(null, "Student deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }
    }

    public void addModuleForStudent() {
        String adminNumber = getInput("Enter Admin Number of student to add module:",
                "Admin number cannot be empty. Please enter a valid admin number.");
        if (adminNumber == null)
            return; // Cancel handling

        for (Student student : students) {
            if (student.getAdminNumber().equals(adminNumber)) {
                int i = student.getModules().size() + 1;
                do {
                    addModuleToStudent(student, i++);
                } while (JOptionPane.showConfirmDialog(null, "Add more modules?", "Confirm",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

                student.calculateGPA();
                JOptionPane.showMessageDialog(null, "Modules added successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student not found.");
    }

    private String getInput(String message, String errorMessage) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);
            if (input == null) {
                return null; 
            } else if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMessage); // Show error message for empty input
            } else {
                return input.trim();
            }
        }
    }

    private int getIntInput(String message, String errorMessage, int minValue, int maxValue) {
        while (true) {
            String inputStr = JOptionPane.showInputDialog(message);
            if (inputStr == null) {
                return -1;
            }
            try {
                int input = Integer.parseInt(inputStr);
                if (input >= minValue && input <= maxValue) {
                    return input;
                } else {
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number");
            }
        }
    }
    
    // Advanced feature done by Ng Yu Jie
    public void generateGPAReport(double minGPA, double maxGPA) {
        StringBuilder sb = new StringBuilder();
        int studentCount = 0;

        sb.append("Students with GPA between ").append(minGPA).append(" and ").append(maxGPA).append(":\n\n");

        for (Student student : students) {
            if (student.getGPA() >= minGPA && student.getGPA() <= maxGPA) {
                studentCount++;
                sb.append("Name: ").append(student.getName()).append("\n")
                        .append("Admin: ").append(student.getAdminNumber()).append("\n")
                        .append("Class: ").append(student.getStudentClass()).append("\n")
                        .append("GPA: ").append(student.getGPA()).append("\n")
                        .append("---------------------\n");
            }
        }

        if (studentCount == 0) {
            sb.append("No students found within the specified GPA range.");
        } else {
            sb.append("Total students: ").append(studentCount);
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "GPA Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void noStudentsAvailable() {
        JOptionPane.showMessageDialog(null, "No students available.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void noStudentClass() {
        JOptionPane.showMessageDialog(null, "No student found from class!");
    }

    private static void cannotFindStudent(String studentName) {
        String errorMessage = String.format("Cannot find the student %s", studentName);
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}