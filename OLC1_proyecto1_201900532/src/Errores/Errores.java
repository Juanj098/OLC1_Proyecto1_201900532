package Errores;

public class Errores {
    private int linea;
    private  int columna;
    private  String lex;
    private  String tipo;

    public Errores (int linea, int columna, String lex, String tipo){
        this.columna = columna;
        this.linea = linea;
        this.lex = lex;
        this.tipo = tipo;
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

    public void setTipo(String tipo){this.tipo =  tipo;}
    @Override
    public String toString() {
        return (" Error_(" + lex +"["+ columna +":"+linea+"]"+"->"+tipo+" )");
    }
}
