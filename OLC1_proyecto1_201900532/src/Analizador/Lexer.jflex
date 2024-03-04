package Analizador;

import java_cup.runtime.Symbol;
import Errores.Errores;
import static Func.Function.list;
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
comi = [\"]
Dec = [0-9]+\.[0-9]+
VARID = [A-Za-z]+[0-9]*
PALS = [a-zA-Z .]+[0-9]*
varArr = @[A-Za-z]+[0-9]*
whitespace = [ |\t|\r|\n]*

%%

//Palabras reservadas
"Var" {return new Symbol(sym.VAR, yyline, yycolumn, yytext());}
"Program" {return new Symbol(sym.PROGRAM, yyline, yycolumn, yytext());}
"End Program" {return new Symbol(sym.ENDP, yyline, yycolumn, yytext());}
"CHAR[]" {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
"Double"  {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
"end" {return new Symbol(sym.END, yyline, yycolumn, yytext());}
"arr" {return new Symbol(sym.ARRAY, yyline, yycolumn, yytext());}
"SUM" {return new Symbol(sym.SUM, yyline, yycolumn, yytext());}
"REST" {return new Symbol(sym.RESTA, yyline, yycolumn, yytext());}

//operadores
"+" {return new Symbol(sym.ADD, yyline,yycolumn,yytext());}
"-" {return new Symbol(sym.MINUS, yyline,yycolumn,yytext());}
"*" {}

//espacios en blanco
{whitespace} {/* ignore */}

//Comentarios

//Simbolos
":"  {return new Symbol(sym.DP, yyline, yycolumn, yytext());}
"<-" {return new Symbol(sym.FLIZQ, yyline, yycolumn, yytext());}
"::" {return new Symbol(sym.DPD, yyline, yycolumn, yytext());}
";"  {return new Symbol(sym.PYC, yyline, yycolumn, yytext());}
{comi} {return new Symbol(sym.COMI, yyline, yycolumn, yytext());}
"[" {return new Symbol(sym.CORIZQ, yyline, yycolumn, yytext());}
"]" {return new Symbol(sym.CORDER, yyline, yycolumn, yytext());}
"," {return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
"(" {return new Symbol(sym.PARIZQ, yyline, yycolumn, yytext());}
")" {return new Symbol(sym.PARDER, yyline, yycolumn, yytext());}


//variables
{VARID} {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
{PALS} {return new Symbol(sym.CADENA, yyline, yycolumn, yytext());}
{varArr} {return new Symbol(sym.IDARR, yyline, yycolumn, yytext());}
{Dec} {return new Symbol(sym.NUM, yyline, yycolumn, yytext());}

//errores

. {
    //System.err.println("warning:Unrecognized character - "+yytext());
    Errores Error = new Errores(yyline,yycolumn,yytext(),"lexico");
    list.add(Error);
    //list_errores.add(Errores);
    //System.out.println(Error.toString());

}
