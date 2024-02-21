package Analizador;

//import java.io.*;
//import java.ArrayList;

%%

%public
%class lexer
%type Token
%line
%column
%char
%ignorecase

%eofval{
    return new Token(TokenCons.EOF,null,-1,-1);
%eofval}

Int = [0-9]+
Dec = [0-9]+\.[0-9]+
VAR = [a-zA-Z]+[0-9]*
varArr = @[a-zA-Z]+[0-9]*
whitespace = [ |\t|\r|\n]*

%%

"Var" {return new Token(TokenCons.VAR,yytext(),yyline,yycolumn);}
{whitespace} {/* ignore */}
. {System.err.println("warning:Unrecognized character - "+yytext());}
