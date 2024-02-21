/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

/**
 *
 * @author juanjx
 */
public class Token {
    private TokenCons tokenType;
    private String lexeme;
    private int line;
    private int column;

    
    public Token(TokenCons tokenType, String lexeme, int line, int column){
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.column = column;
        this.line = line;
    }
    
    public TokenCons gettokenType(){
        return tokenType;
    }
    
    public void settokenType(TokenCons tokenType){
        this.tokenType = tokenType;
    }
    
    public String getLexeme(){
        return lexeme;
    }
    
    public void setLexeme(String lexeme){
        this.lexeme = lexeme;        
    }

    public int getline(){
        return line;
    }
    
    public void settokenType(int line){
        this.line = line;
    }

    public int getCol(){
        return column;
    }
    
    public void setColumn(int column){
        this.column = column;
    }
    
    @Override
    public String toString(){
        return "Token{"+ "Tokentype: " + tokenType +" lexeme: "+ lexeme + "["+column +":"+line+"]"+"}";
    }
}
