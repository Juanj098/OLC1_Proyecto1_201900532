package Analizador;

import java_cup.runtime.Symbol;

%%

%cup
%public
%unicode
%class Lexer
%line
%column
%char
%ignorecase

%{
%}
VARI = [string|Double]
Int = [0-9]+
Dec = [0-9]+\.[0-9]+
VARID = [a-zA-Z]+[0-9]*
PALS = \"[a-zA-Z .]+\"
varArr = @[a-zA-Z]+[0-9]*
whitespace = [ |\t|\r|\n]*

%%

//Palabras reservadas

"Var" {return new Symbol(sym.VAR, yyline, yycolumn, yytext());}
"Program" {return new Symbol(sym.PROGRAM, yyline, yycolumn, yytext());}
"End Program" {return new Symbol(sym.ENDP, yyline, yycolumn, yytext());}
"CHAR[]" {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
"Double"  {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
//"Arr" {return new Symbol(sym.ARR, yyline, yycolumn, yytext());}



//operadores 


//espacios en blanco
{whitespace} {/* ignore */}

//Comentarios

//Simbolos
":"  {return new Symbol(sym.DP, yyline, yycolumn, yytext());}
"<-" {return new Symbol(sym.FLIZQ, yyline, yycolumn, yytext());}
"::" {return new Symbol(sym.DPD, yyline, yycolumn, yytext());}
";"  {return new Symbol(sym.PYC, yyline, yycolumn, yytext());}
"\"" {return new Symbol(sym.COMI, yyline, yycolumn, yytext());}

//variables
{VARID} {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
{PALS} {return new Symbol(sym.CONT, yyline, yycolumn, yytext());}

//errores

. {System.err.println("warning:Unrecognized character - "+yytext());}
