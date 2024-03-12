package Analizador;

import java.util.ArrayList;

public class DGRAHPH {
    private String titulo;
    private ArrayList<Double> listaDouble;

    // Constructor
    public DGRAHPH(String titulo, ArrayList<Double> listaDouble) {
        this.titulo = titulo;
        this.listaDouble = listaDouble;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public ArrayList<Double> getListaDouble() {
        return listaDouble;
    }
    public void setListaDouble(ArrayList<Double> listaDouble) {
        this.listaDouble = listaDouble;
    }
}
