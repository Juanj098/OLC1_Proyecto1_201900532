package Errores;

public class Errores {
    private int linea;
    private  int columna;
    private  String lex;

    public Errores (int linea, int columna, String lex){
        this.columna = columna;
        this.linea = linea;
        this.lex = lex;
    }

    public void setLex(String lex){
        this.lex = lex;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return (" Error_(" + lex +"["+ columna +":"+linea+"]"+" )");
    }
}
