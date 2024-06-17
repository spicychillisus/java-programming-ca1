/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */
import java.util.*;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;


public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
        
        //member A
        // Adding dummy student data
        Student student1 = new Student("A001", "John Doe", "CS101");
        student1.addModule(new Module("M001", "Fundamentals of Programming", 4, 85));
        student1.addModule(new Module("M002", "Mathematics I", 3, 78));
        student1.calculateGPA();
        students.add(student1);

        Student student2 = new Student("A002", "Jane Smith", "CS101");
        student2.addModule(new Module("M003", "Data Structures", 4, 90));
        student2.addModule(new Module("M004", "Computer Architecture", 3, 88));
        student2.calculateGPA();
        students.add(student2);

        Student student3 = new Student("A003", "Alice Johnson", "CS102");
        student3.addModule(new Module("M001", "Fundamentals of Programming", 4, 92));
        student3.addModule(new Module("M005", "Discrete Mathematics", 3, 81));
        student3.calculateGPA();
        students.add(student3);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            noStudentsAvailable();
            return;
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

        JOptionPane.showMessageDialog(null, sb.toString(), "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchStudentByClass() {
        String studentClass = JOptionPane.showInputDialog("Enter the class name to search").toUpperCase();
        int studentCount = 0;
        double totalGPA = 0.0;
        StringBuilder sb = new StringBuilder();


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
            return;
        }
        
        double averageGPA = totalGPA / studentCount;
        sb.append("Number of students in class ").append(studentClass).append(": ").append(studentCount).append("\n")
         .append("Average GPA: ").append(String.format("%.2f", averageGPA));

        JOptionPane.showMessageDialog(null, sb.toString(), "Class Summary", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void printAllStudents() {
        double totalGPA = 0.0;
        int studentCount = 0;
        String studentClass = "";
        String printOut = "";
        String output = "";
        
        studentClass = JOptionPane.showInputDialog("Enter the class statistic you wish to print out: ");
        
        for (Student student : students) {
            if (student.getStudentClass().equalsIgnoreCase(studentClass)) {
                studentCount++;
                totalGPA += student.getGPA();
                printOut +="""
                           Name: %s
                           Admin: %s
                           GPA: %d
                           --------------
                           """;
                
                output = String.format(printOut, student.getName(), student.getAdminNumber(), student.getGPA());

                        
                sb.append("Name: ").append(student.getName()).append("\n")
                  .append("Admin: ").append(student.getAdminNumber()).append("\n")
                  .append("GPA: ").append(student.getGPA()).append("\n")
                  .append("-----------\n");
            }
        }
        
        /*
        * The FileWriter class in Java is typically used for writing character files.
        * It is not recommended to use FileWriter to write data directly into Microsoft Office formats 
        * such as .docx, .ppt, .xlsx, etc., as it could lead to data corruption.
        * These formats are complex and require specific libraries to handle them correctly.
        */
        try {
            FileWriter writer = new FileWriter("allStudents.txt");
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            
        }
    }
    
    public static void printIndividualStudent() {
        
    }

    public void searchStudentByName() {
        String studentName = JOptionPane.showInputDialog("Enter the Student name to search: ").trim();
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
                sb.append("-----------\n");
            }
        }

        if (!found) {
            cannotFindStudent(studentName);
            return;
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    // Member B
    public void addStudent() {
        String name = getInput("Enter name:", "Name cannot be empty. Please enter a valid name.");
        String adminNumber = getInput("Enter Admin:", "Admin number cannot be empty. Please enter a valid admin number.");
        String studentClass = getInput("Enter Class:", "Class cannot be empty. Please enter a valid class.");

        Student student = new Student(adminNumber, name, studentClass);

        int numberOfModules = getIntInput("Enter number of Modules Taken:", "Number of modules must be at least 1. Please enter a valid number.", 1, Integer.MAX_VALUE);

        for (int i = 1; i <= numberOfModules; i++) {
            addModuleToStudent(student, i);
        }

        student.calculateGPA();
        students.add(student);
        JOptionPane.showMessageDialog(null, "Student added successfully:\n" + student);
    }

    public void deleteStudent() {
        String adminNumber = getInput("Enter Admin Number of student to delete:", "Admin number cannot be empty. Please enter a valid admin number.");
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
        String adminNumber = getInput("Enter Admin Number of student to add module:", "Admin number cannot be empty. Please enter a valid admin number.");

        for (Student student : students) {
            if (student.getAdminNumber().equals(adminNumber)) {
                int i = student.getModules().size() + 1;
                do {
                    addModuleToStudent(student, i++);
                } while (JOptionPane.showConfirmDialog(null, "Add more modules?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

                student.calculateGPA();
                JOptionPane.showMessageDialog(null, "Modules added successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student not found.");
    }

    private void addModuleToStudent(Student student, int moduleIndex) {
        String moduleCode = getInput("Enter Module Code for module " + moduleIndex + ":", "Module code cannot be empty. Please enter a valid module code.");
        String moduleName = getInput("Enter Module Name for module " + moduleIndex + ":", "Module name cannot be empty. Please enter a valid module name.");
        int creditUnit = getIntInput("Enter Credit Unit for module " + moduleIndex + ":", "Credit units must be at least 1. Please enter a valid number.", 1, Integer.MAX_VALUE);
        int marks = getIntInput("Enter Marks for module " + moduleIndex + ":", "Marks must be between 0 and 100. Please enter a valid number.", 0, 100);

        Module module = new Module(moduleCode, moduleName, creditUnit, marks);
        student.addModule(module);
    }

    private String getInput(String message, String errorMessage) {
        String input = null;
        while (input == null || input.trim().isEmpty()) {
            input = JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMessage);
            }
        }
        return input.trim();
    }

    private int getIntInput(String message, String errorMessage, int minValue, int maxValue) {
        int input = -1;
        while (input < minValue || input > maxValue) {
            try {
                String inputStr = JOptionPane.showInputDialog(message);
                if (inputStr == null) {
                    JOptionPane.showMessageDialog(null, errorMessage);
                } else {
                    input = Integer.parseInt(inputStr);
                    if (input < minValue || input > maxValue) {
                        JOptionPane.showMessageDialog(null, errorMessage);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    public ArrayList<Student> getStudents() {
        return students;
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
