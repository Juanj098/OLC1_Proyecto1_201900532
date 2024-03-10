package Analizador;

public class NodoSym {
    public String Nombre;
    public Object Valor;
    public String Tipo;

    public NodoSym(String nombre, Object valor, String tipo){
        this.Nombre = nombre;
        this.Valor = valor;
        this.Tipo = tipo;
    }

    public Object getValor() {
        return Valor;
    }
    public void setValor(Object valor) {
        Valor = valor;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString(){
        return "Nombre: "+Nombre+" - Valor: "+Valor+" - Tipo: "+Tipo;
    }
}
