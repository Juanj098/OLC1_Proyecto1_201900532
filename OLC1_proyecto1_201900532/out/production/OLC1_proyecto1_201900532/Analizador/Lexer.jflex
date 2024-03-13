package Analizador;

import java_cup.runtime.Symbol;
import Errores.Errores;
import static Func.Function.list_err;
import static Func.Function.list_Token;

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
PALS = [\"][\-|\@|\?|\^|\&|\#|\_]*[0-9]*[A-Za-zÁáÉéÍíÓóÚúÜü\s]+[\:|\-|\@|\?|\^|\&|\#|\_|]*[0-9]*[\"]
varArr = @[A-Za-z]+[0-9]*
whitespace = [\s|\t|\r|\n]*
comment ={TraditionalComment} | {DocumentationComment}
TraditionalComment ="!"[\-|\@|\?|\^|\&|\#|\_]*[0-9]*[A-Za-zÁáÉéÍíÓóÚúÜü\s]+[\-|\@|\:|\?|\^|\&|\#|\_]*[0-9]*
DocumentationComment = "<!" {CommentContent}{whitespace} "!"+">"
CommentContent       = [\-|\@|\?|\^|\&|\#|\_]*[0-9]*[A-Za-zÁáÉéÍíÓóÚúÜü\s]+[\:|\-|\@|\?|\^|\&|\#|\_|]*[0-9]*

%%

//Palabras reservadas
"Var" {Token tok = new Token("VAR",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.VAR, yyline, yycolumn, yytext());}
"Program" {Token tok = new Token("PROGRAM",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.PROGRAM, yyline, yycolumn, yytext());}
"End Program" {Token tok = new Token("ENDP",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.ENDP, yyline, yycolumn, yytext());}
"CHAR[]" {Token tok = new Token("CHAR",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
"Double"  {Token tok = new Token("DOUBLE",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
"end" {Token tok = new Token("END",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.END, yyline, yycolumn, yytext());}
"arr" {Token tok = new Token("ARRAY",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.ARRAY, yyline, yycolumn, yytext());}
"SUM" {Token tok = new Token("SUMA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.SUM, yyline, yycolumn, yytext());}
"RES" {Token tok = new Token("RESTA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.RESTA, yyline, yycolumn, yytext());}
"MUL" {Token tok = new Token("MULTI",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MULTI, yyline, yycolumn, yytext());}
"DIV" {Token tok = new Token("DIV",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.DIV, yyline, yycolumn, yytext());}
"MOD" {Token tok = new Token("MOD",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MOD, yyline, yycolumn, yytext());}
"MEDIA" {Token tok = new Token("MEDIA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MEDIA, yyline, yycolumn, yytext());}
"MODA" {Token tok = new Token("MODA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MODA, yyline, yycolumn, yytext());}
"MEDIANA" {Token tok = new Token("MEDIANA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MEDIANA, yyline, yycolumn, yytext());}
"VARIANZA" {Token tok = new Token("VARIANZA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.VARIANZA, yyline, yycolumn, yytext());}
"MAX" {Token tok = new Token("MAX",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MAX, yyline, yycolumn, yytext());}
"MIN" {Token tok = new Token("MIN",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.MIN, yyline, yycolumn, yytext());}
"CONSOLE" {Token tok = new Token("CONSO",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.CONSO, yyline, yycolumn, yytext());}
"COLUMN" {Token tok = new Token("COLUM",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.COLUM, yyline, yycolumn, yytext());}
"PRINT" {Token tok = new Token("PRINT",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.PRINT, yyline, yycolumn, yytext());}
"GRAPHPIE" {Token tok = new Token("GPIE",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.GPIE, yyline, yycolumn, yytext());}
"GRAPHBAR" {Token tok = new Token("GBAR",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.GBAR, yyline, yycolumn, yytext());}
"GRAPHLINE" {Token tok = new Token("GLINE",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.GLINE, yyline, yycolumn, yytext());}
"HISTOGRAM" {Token tok = new Token("GHIS",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.GHIS, yyline, yycolumn, yytext());}
"EXEC" {Token tok = new Token("EXEC",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.EXEC, yyline, yycolumn, yytext());}
"LABEL" {Token tok = new Token("LBEL",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.LBEL, yyline, yycolumn, yytext());}
"VALUES" {Token tok = new Token("VALS",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.VALS, yyline, yycolumn, yytext());}
"TITULO" {Token tok = new Token("TITLE",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.TITLE, yyline, yycolumn, yytext());}
"EJEX"   {Token tok = new Token("EJX",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.EJX, yyline, yycolumn, yytext());}
"EJEY"   {Token tok = new Token("EJY",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.EJY, yyline, yycolumn, yytext());}
"TITULOX" {Token tok = new Token("TX",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.TX, yyline, yycolumn, yytext());}
"TITULOY" {Token tok = new Token("TY",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.TY, yyline, yycolumn, yytext());}

//espacios en blanco
{whitespace} {/* ignore */}

//Comentarios
{comment} {/*ignore*/}

//Simbolos
":"  {Token tok = new Token("DP",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.DP, yyline, yycolumn, yytext());}
"<-" {Token tok = new Token("FLIZQ",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.FLIZQ, yyline, yycolumn, yytext());}
"->" {Token tok = new Token("FLDER",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.FLDER, yyline, yycolumn, yytext());}
"::" {Token tok = new Token("DPD",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.DPD, yyline, yycolumn, yytext());}
";"  {Token tok = new Token("PYC",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.PYC, yyline, yycolumn, yytext());}
"[" {Token tok = new Token("CORIZQ",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.CORIZQ, yyline, yycolumn, yytext());}
"]" {Token tok = new Token("CORDER",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.CORDER, yyline, yycolumn, yytext());}
"," {Token tok = new Token("COMA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
"(" {Token tok = new Token("PARIZQ",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.PARIZQ, yyline, yycolumn, yytext());}
")" {Token tok = new Token("PARDER",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.PARDER, yyline, yycolumn, yytext());}
"=" {Token tok = new Token("IG",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.IG, yyline,yycolumn, yytext());}


//variables
{ID} {Token tok = new Token("ID",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.ID, yyline, yycolumn, yytext());}
{PALS} {Token tok = new Token("CADENA",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.CADENA, yyline, yycolumn, yytext());}
{varArr} {Token tok = new Token("ID_ARR",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.IDARR, yyline, yycolumn, yytext());}
{Dec} {Token tok = new Token("NUM",yytext(),yycolumn,yyline); list_Token.add(tok);return new Symbol(sym.NUM, yyline, yycolumn, yytext());}


//errores

. {
    //System.err.println("warning:Unrecognized character - "+yytext());
    Errores Error = new Errores(yyline,yycolumn,yytext(),"lexico");
    list_err.add(Error);
    //list_errores.add(Errores);
    //System.out.println(Error.toString());

}
