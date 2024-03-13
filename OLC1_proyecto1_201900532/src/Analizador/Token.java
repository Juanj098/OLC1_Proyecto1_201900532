package Analizador;

public class Token {
    public String Sym;
    public String text;
    public Integer yycolumn;
    public Integer yyline;

    public Token(String sym, String text, Integer col, Integer  fila){
        this.Sym = sym;
        this.text = text;
        this.yycolumn = col;
        this.yyline = fila;
    }

    public Integer getYycolumn() {
        return yycolumn;
    }

    public Integer getYyline() {
        return yyline;
    }

    public String getSym() {
        return Sym;
    }

    public String getText() {
        return text;
    }

    public void setSym(String sym) {
        Sym = sym;
    }

    public void setYycolumn(Integer yycolumn) {
        this.yycolumn = yycolumn;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setYyline(Integer yyline) {
        this.yyline = yyline;
    }

    @Override
    public String toString() {
        return "sym: "+ Sym + " columna: "+ yycolumn+" fila: "+ yyline+" text: "+text;
    }
}
