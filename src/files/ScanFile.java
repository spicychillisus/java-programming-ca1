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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScanFile {
    
    private String fileName;

    public ScanFile(String fileName) {
        this.fileName = fileName;
    }
    
    public void fileReader(String fileName) throws IOException, FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(fileName);
        
        String fileContent = "";
        while (scan.hasNextLine()) {
            // to test
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }
        
        System.out.println(fileContent);
        
    }
}
