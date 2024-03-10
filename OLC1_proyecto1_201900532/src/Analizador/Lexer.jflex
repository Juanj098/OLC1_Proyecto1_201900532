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
%function next_token

%{
%}

VARI = [string|Double]
Int = [0-9]+
comi = [\"]
Dec = [0-9]+\.[0-9]+
ID = [A-Za-z]+[0-9]*
PALS = [\"][A-Za-z\s]+[0-9]*[\"]
varArr = @[A-Za-z]+[0-9]*
whitespace = [\s|\t|\r|\n]*

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
"RES" {return new Symbol(sym.RESTA, yyline, yycolumn, yytext());}
"MUL" {return new Symbol(sym.MULTI, yyline, yycolumn, yytext());}
"DIV" {return new Symbol(sym.DIV, yyline, yycolumn, yytext());}
"MOD" {return new Symbol(sym.MOD, yyline, yycolumn, yytext());}
"MEDIA" {return new Symbol(sym.MEDIA, yyline, yycolumn, yytext());}
"MODA" {return new Symbol(sym.MODA, yyline, yycolumn, yytext());}
"MEDIANA" {return new Symbol(sym.MEDIANA, yyline, yycolumn, yytext());}
"VARIANZA" {return new Symbol(sym.VARIANZA, yyline, yycolumn, yytext());}
"MAX" {return new Symbol(sym.MAX, yyline, yycolumn, yytext());}
"MIN" {return new Symbol(sym.MIN, yyline, yycolumn, yytext());}
//espacios en blanco
{whitespace} {/* ignore */}

//Comentarios

//Simbolos
":"  {return new Symbol(sym.DP, yyline, yycolumn, yytext());}
"<-" {return new Symbol(sym.FLIZQ, yyline, yycolumn, yytext());}
"::" {return new Symbol(sym.DPD, yyline, yycolumn, yytext());}
";"  {return new Symbol(sym.PYC, yyline, yycolumn, yytext());}
"[" {return new Symbol(sym.CORIZQ, yyline, yycolumn, yytext());}
"]" {return new Symbol(sym.CORDER, yyline, yycolumn, yytext());}
"," {return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
"(" {return new Symbol(sym.PARIZQ, yyline, yycolumn, yytext());}
")" {return new Symbol(sym.PARDER, yyline, yycolumn, yytext());}


//variables
{ID} {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
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
