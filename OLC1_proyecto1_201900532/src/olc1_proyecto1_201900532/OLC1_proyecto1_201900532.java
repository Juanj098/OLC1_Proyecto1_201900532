/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package olc1_proyecto1_201900532;

import javax.swing.*;
/**
 *
 * @author juanj
 */
public class OLC1_proyecto1_201900532 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame Frame = new OLC1FORM();
                Frame.setSize(850,750);
                Frame.setVisible(true);
                Frame.setLocationRelativeTo(null);
                Frame.setResizable(false);
            }
        });

    }

}
