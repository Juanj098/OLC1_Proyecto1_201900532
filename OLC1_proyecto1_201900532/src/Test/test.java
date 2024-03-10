/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Func.Function;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import Analizador.Parser;

/**
 *
 * @author juanj
 */
public class test {

    public static void main(String[] args) throws IOException{
        System.out.println("--------------------------");
        String prueba = "PROGRAM\n" +
                        "var:char[]::ExampleCHAR<-\"hola ejemplo\" end;\n" +
                        "var:double::Example123<- 1.5 end;\n" +
                        "var:char[]::hola1<-\"juan jose\" end;\n" +
                        "var:char[]::hola<- hola1 end;\n" +
                        "var:double::Example456<- Example123 end;\n" +
                        "arr:char[]::@labels<-[ \"hola\",\"x\",\"y\"] end;\n" +
                        "arr:double::@D123<- [1.0,2.0,33.0] end;\n" +
                        "var:double::med1<-media([12.0,3.22,9.9])end;\n" +
                        "var:double::suma<-SUM(MUL(5.0,6.0),SUM(7.0,DIV(21.0,3.0)))end;\n" +
                        "var:DOUBLE::ejMOD<-MOD(10.0,3.0)end;\n" +
                        "arr:double::@D1234<- [mul(6.0,4.0),res(5.0,3.0),sum(2.0,3.0)] end;\n" +
                        "var:double::med2<-media([sum(1.0,6.0),3.0,4.0])end;\n" +
                        "var:double::mod1<-moda([sum(1.0,6.0),3.0,4.0,3.0,4.0,4.0])end;\n" +
                        "var:double::mediana1<-mediana([sum(1.0,6.0),3.0,5.0,3.2,2.0,4.0,3.9])end;\n" +
                        "var:double::varianza1<-varianza([sum(1.0,6.0),3.0,5.0,3.2,2.0,4.0,3.9])end;\n" +
                        "var:double::Max1<-max([sum(1.0,6.0),3.0,15.0,3.2,2.0,4.0,10.9])end;\n" +
                        "var:double::Min1<-min([sum(1.0,6.0),3.0,15.0,3.2,2.0,4.0,10.9])end;\n" +
                        "arr:CHAR[]::@prueba<- [\"labels\"] end;\n" +
                        "arr:char[]::@labels2<- @labels end;\n" +
                        "arr:char[]::@labels2<- @prueba end;\n" +
                        "arr:double::@nums<- @D123 end;\n" +
                        "END PROGRAM";
//        Generar();
        Analizar(prueba);

        for (int i = 0; i< Function.list.size();i++){
            System.out.println(Function.list.get(i));
        }

        System.out.println("----TS----");
        for (int j =0; j < Parser.TS.size();j++){
            System.out.println(Parser.TS.get(j).toString());
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
