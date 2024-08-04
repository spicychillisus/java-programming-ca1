/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author asher
 */
public class StudentController {
    
    public String noFilter() {
        String noFilterText = "Please select a filter!";
        return noFilterText;
    }
    
    public void changeTitledBorderText(javax.swing.JPanel studentDisplayPanel, String newTitle) {
        Border border = studentDisplayPanel.getBorder();
        if (border instanceof TitledBorder) {
            TitledBorder tb = (TitledBorder) border;
            tb.setTitle(newTitle);
            studentDisplayPanel.repaint();
        }
    }
}
