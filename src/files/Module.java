/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author DIT/FT/2B/23 P2210979 Reyes Asher Benedict Calaminos
 * @author DIT/FT/2B/23 P2323150 Ng Yu Jie
 */
public class Module {
    private String moduleCode;
    private String moduleName;
    private int creditUnit;
    private double marks;

    public Module(String moduleCode, String moduleName, int creditUnit, double marks) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.creditUnit = creditUnit;
        this.marks = marks;
    }
    
    

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public double getMarks() {
        return marks;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
        @Override
    public String toString() {
        return "Module Code: " + moduleCode + ", Module Name: " + moduleName + 
               ", Credit Unit: " + creditUnit + ", Marks: " + marks;
    }
}

