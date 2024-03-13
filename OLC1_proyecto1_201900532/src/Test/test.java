/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Func.Function;
import java.io.IOException;
import java.io.StringReader;
import java.io.Reader;
import Analizador.Parser;


/**
 *
 * @author juanj
 */
public class test {

    public static void main(String[] args) throws IOException{
        System.out.println("--------------------------");
        String prueba = "PROGRAM\n" +
                        "!hola\n"+
                        "<!hola es\n"+
                        "un\n"+
                        "comentario!>\n"+
                        "var:char[]::ExampleCHAR<-\"hola ejemplo\" end;\n" +
                        "var:double::Example123<- 1.5 end;\n" +
                        "var:char[]::hola1<-\"juan jose\" end;\n" +
                        "var:char[]::hola<- hola1 end;\n" +
                        "var:double::Example456<- Example123 end;\n" +
                        "arr:char[]::@labels<-[ \"hola\",\"x\",\"y\"] end;\n" +
                        "arr:double::@D123<- [1.0,mul(2.0,8.0),33.0] end;\n" +
                        "var:double::med1<-media([12.0,3.22,9.9])end;\n" +
                        "var:double::suma<-SUM(MUL(Example123,6.0),SUM(7.0,DIV(21.0,3.0)))end;\n" +
                        "var:DOUBLE::ejMOD<-MOD(10.0,3.0)end;\n" +
                        "arr:double::@D1234<- [mul(6.0,4.0),res(5.0,3.0),sum(2.0,3.0)] end;\n" +
                        "var:double::med2<-media([sum(1.0,6.0),3.0,4.0])end;\n" +
                        "var:double::mod1<-moda([sum(Example123,6.0),3.0,4.0,3.0,4.0,4.0])end;\n" +
                        "var:double::mediana1<-mediana([sum(1.0,6.0),3.0,5.0,3.2,2.0,4.0,3.9])end;\n" +
                        "var:double::varianza1<-varianza([sum(1.0,6.0),3.0,5.0,3.2,2.0,4.0,3.9])end;\n" +
                        "var:double::Max1<-max([sum(1.0,6.0),3.0,15.0,3.2,2.0,4.0,10.9])end;\n" +
                        "var:double::Min1<-min([sum(1.0,6.0),3.0,15.0,3.2,2.0,4.0,10.9])end;\n" +
                        "arr:CHAR[]::@prueba<- [\"labels\"] end;\n" +
                        "arr:char[]::@labels2<- @labels end;\n" +
                        "arr:char[]::@labels2<- @prueba end;\n" +
                        "arr:double::@nums<- @D123 end;\n" +
                        "console::print=\"hola\",med1,\"adios\" end;\n" +
                        "console::print=\"hola1233\",varianza1,\"adiosxd\" end;\n" +
                        "console::column=\"letras\" -> [\"A\",\"B\",\"C\",\"D\"] end;"+
                        "console::column= @D1234 -> @D1234 end;"+
                        "graphPie(\n" +
                            "label::char[] = [\"si\",\"sale\",\"compi1\"] end;\n" +
                            "values::double = [Example123,2.0,3.0] end;\n" +
                            "titulo::char[] = \"Cadena\" end;\n" +
                            "EXEC graphPie end;\n" +
                        ") end;\n" +
                        "graphBar("+
                            "titulo::char[] = \"Estudiantes\" end;\n"+
                            "ejeX::char[] = [\"1 Parcial\", \"2 parcial\", \"Final\"] end;\n"+
                            "ejeY::double = [50.0, 30.0, 70.0] end;\n" +
                            "tituloX::char[] = \"Actividades\" end;\n"+
                            "tituloY::char[] = \"Notas\" end;\n"+
                            "EXEC graphBar end\n;"+
                        ") end;\n"+
                        "graphLine(\n"+
                            "titulo::char[] = \"Grafica de Linea\" end;\n"+
                            "ejeX::char[] = [hola1, \"2 parcial\", \"Final\"] end;\n"+
                            "ejeY::double = [50.0, 30.0, 70.0] end;\n"+
                            "tituloX::char[] = \"Actividades\" end;\n"+
                            "tituloY::char[] = \"Notas\" end;\n"+
                            "EXEC graphLine end;\n"+
                        ") end;\n"+
                        " Histogram(\n"+
                            "titulo::char[] = \"Analisis de Arreglo\" end;\n"+
                            "values::double = [2.0,2.0,2.0,5.0,5.0,7.0,8.0] end;\n"+
                            "EXEC Histogram end;\n"+
                        ") end;"+
                        "END PROGRAM";
        Generar();
//        Analizar(prueba);
//
        for (int i = 0; i< Function.list_err.size();i++){
            System.out.println(Function.list_err.get(i));
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
