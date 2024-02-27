/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Func.Function;

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
        String prueba =  "PROGRAM\n" +
                         "var:char[]:: example <- \"hola\" end; \n" +
                         "END PROGRAM";
        Generar();
//        Analizar(prueba);

        for (int i = 0; i< Function.list.size();i++){
            System.out.println(Function.list.get(i));
        }


    }
    public static void Analizar(String entrada){
        try {
            Reader sr = new StringReader(entrada);
            Analizador.Lexer lx = new Analizador.Lexer(sr);
            Analizador.Parser parse = new Analizador.Parser(lx);
            parse.parse();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Generar(){
        try {
            String path = "C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/Analizador/";
            String[] opJFlex = {path + "Lexer.jflex","-d",path};
            jflex.Main.generate(opJFlex);

            String[] opCup = {"-destdir",path,"-parser","Parser",path+"parser.cup"};
            java_cup.Main.main(opCup);

        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
}
