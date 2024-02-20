/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generador;

import jflex.exceptions.SilentExit;

/**
 *
 * @author juanj
 */
public class Generador {
    public static void main(String[] args) {
        try {
            String path = "./src/Generador/";
            String[] opJFlex = {path+"Lexer.jflex","-d",path};
            jflex.Main.generate(opJFlex);            
        } catch (SilentExit e) {
            System.err.println(e.getMessage());
        }
    }
    
}
