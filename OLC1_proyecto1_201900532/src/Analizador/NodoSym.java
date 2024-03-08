package Analizador;

public class NodoSym {
    public String Nombre;
    public String Valor;
    public String Tipo;

    public NodoSym(String nombre, String valor, String tipo){
        this.Nombre = nombre;
        this.Valor = valor;
        this.Tipo = tipo;
    }

    @Override
    public String toString(){
        return "Nombre: "+Nombre+" - Valor: "+Valor+" - Tipo: "+Tipo;
    }
}
