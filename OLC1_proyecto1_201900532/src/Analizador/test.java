/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author juanj
 */
public class test {
    public static void main(String[] args) throws IOException{
        System.out.println("--------------------------");
        String prueba = "var var";
        Reader sr = new StringReader(prueba);
        lexer lx = new lexer(sr);
        Token tk = lx.yylex();
        while(tk.getLexeme()!=null){
            System.out.println(tk.toString());
            tk = lx.yylex();
        }
        System.out.println("------------:D------------");

    }
}
