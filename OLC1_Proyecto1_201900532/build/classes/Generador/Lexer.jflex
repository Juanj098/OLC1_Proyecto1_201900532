package Generador;

import static olc1_proyecto1_201900532 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

%%

//definir Regex y constructor
// %class lexer
%unicode
%line
%column
%cup
%char
%ignorecase
%type tokens


%{
    yyline = 0;
    yycolumn = 0;  
%}

ID = [a-zA-Z0-9_]+
ID_Arr = /@[a-z0-9_]
D = [0-9]+
Dec = [0-9]+\.[0-9]+
espacio = [ ,\t,\r,\n]+
 
%%

//creacion de tokens

var |
Program |
End |
Char {System.out.println("P_Reservada"yytext()+":"+yyline+":"+yycolumn);return new Symbol(sym.P_Reservada,yycolumn,yyline,yytext());}

//errores

.{
    System.out.println("Error Lexico: "+yytext()+" linea: "+yyline+" columna: "yycolumn )
}
