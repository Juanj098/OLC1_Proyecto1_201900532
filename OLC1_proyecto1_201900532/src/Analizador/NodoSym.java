package Analizador;

import java.util.ArrayList;

class ValorString{
    private String valor;

    public  ValorString(String valor){
        this.valor=valor;
    }

    public String getValor() {
        return valor;
    }
}

class ValorDouble{
    private Double valor;

    public ValorDouble(Double valor){
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
}

class ArrayString {
    private ArrayList<String> valor;
    public ArrayString(ArrayList<String> valor){
        this.valor = valor;
    }
    public ArrayList<String> getValor() {
        return valor;
    }
}

class ArrayDouble {
    private ArrayList<Double> valor;
    public ArrayDouble(ArrayList<Double> valor) {
        this.valor = valor;
    }
    public ArrayList<Double> getValor() {
        return valor;
    }
}
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
        String valorString;
        if (Valor instanceof ValorString) {
            valorString = ((ValorString) Valor).getValor();
        } else if (Valor instanceof ValorDouble) {
            valorString = Double.toString(((ValorDouble) Valor).getValor());
        } else if (Valor instanceof ArrayString) {
            valorString = ((ArrayString) Valor).getValor().toString();
        } else if (Valor instanceof ArrayDouble) {
            valorString = ((ArrayDouble) Valor).getValor().toString();
        } else {
            valorString = "Valor no reconocido";
        }
        return "Nombre: "+Nombre+" - Valor: "+valorString+" - Tipo: "+Tipo;
    }
}
