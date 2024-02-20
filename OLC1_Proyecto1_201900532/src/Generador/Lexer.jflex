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

// palabras reservadas

"var"         {return new Symbol(sym.VAR,yycolumn,yyline,yytext());}
"Program"     {return new Symbol(sym.PROGRAM,yycolumn,yyline,yytext());}
"End"         {return new Symbol(sym.END,yycolumn,yyline,yytext());}
"arr"         {return new Symbol(sym.ARR,yycolumn,yyline,yytext());}
"EXEC"        {return new Symbol(sym.Exec,yycolumn,yyline,yytext());}
"console"     {return new Symbol(sym.Console,yycolumn,yyline,yytext());}
"print"       {return new Symbol(sym.Print,yycolumn,yyline,yytext());}
"tituloX"     {return new Symbol(sym.TituloX,yycolumn,yyline,yytext());}
"tituloY"     {return new Symbol(sym.TituloY,yycolumn,yyline,yytext());}
"ejeX"        {return new Symbol(sym.EjeX,yycolumn,yyline,yytext());}
"ejeY"        {return new Symbol(sym.EjeY,yycolumn,yyline,yytext());}
"label"       {return new Symbol(sym.Label,yycolumn,yyline,yytext());}
"Titulo"      {return new Symbol(sym.Titulo,yycolumn,yyline,yytext());}

// Tipos datos

"double"      {return new Symbol(sym.DOUBLE,yycolumn,yyline,yytext());}
"Char"        {return new Symbol(sym.CHAR,yycolumn,yyline,yytext());}
"int"         {return new Symbol(sym.INTEGER,yycolumn,yyline,yytext());}


// operadores
""
// comentarios

// simbolos

// N_variables

//errores

.{
    System.out.println("Error Lexico: "+yytext()+" linea: "+yyline+" columna: "yycolumn )
}
