/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;


/**
 *
 * @author juanj
 */
public class Generador {
    public static void main(String[] args) {
        try {
            String path = "C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/Analizador/";
            String[] opJFlex = {path + "Lexer.jflex","-d",path};
            jflex.Main.generate(opJFlex);
        } catch (Exception e) {
//            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static genLexer(String ruta){
//        File arch = new File(ruta);
//        jflex.Main.generate(arch);
//    }
}