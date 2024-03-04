/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Func.Function;
import Errores.Errores;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import Func.Function;

import static Func.Function.list;

/**
 *
 * @author juanj
 */
public class test {

    public static void main(String[] args) throws IOException{
        System.out.println("--------------------------");
        String prueba =  "PROGRAM\n" +
                         "var:char[]::exampleCHAR<-\"es un ejemplo\"end;\n"+
                         "var:double::example123<-1.5end;\n"+
                         "var:char[]::hola<-\"juan jose\"end;\n"+
                         "arr:char[]::@labels<-[\" label aprobar \" , \" P1 \" , \" P2 \"]end;\n"+
                         "arr:double::@D123<-[1.0,2.0,33.0]end;\n"+
//                         "var:double::suma<-sum(1.0,5.12)end;\n"+
                         "SUM(SUM(7.0+4.0)+REST(5.0-1.0));\n"+
                         "END PROGRAM";
//        Generar();
        Analizar(prueba);

        for (int i = 0; i< list.size();i++){
            System.out.println(list.get(i));
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
