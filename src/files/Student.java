/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author asher
 */
import java.util.ArrayList;

public class Student {
    private String adminNumber;
    private String name;
    private String studentClass;
    private ArrayList<Module> modules;
    private double gpa;

    public Student(String adminNumber, String name, String studentClass) {
        this.adminNumber = adminNumber;
        this.name = name;
        this.studentClass = studentClass;
        this.modules = new ArrayList<>();
        this.gpa = 0.0;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public double getGPA() {
        return gpa;
    }

    public void calculateGPA() {
        int totalCreditUnits = 0;
        double totalGradePoints = 0.0;
        
        for (Module module : modules) {
            int gradePoints = getGradePoints(module.getMarks());
            totalCreditUnits += module.getCreditUnit();
            totalGradePoints += gradePoints * module.getCreditUnit();
        }
        
        this.gpa = totalGradePoints / totalCreditUnits;
    }

    private int getGradePoints(int marks) {
        if (marks >= 80) return 4;
        else if (marks >= 70) return 3;
        else if (marks >= 60) return 2;
        else if (marks >= 50) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Admin Number: " + adminNumber + ", Name: " + name +
               ", Class: " + studentClass + ", GPA: " + gpa;
    }
}

