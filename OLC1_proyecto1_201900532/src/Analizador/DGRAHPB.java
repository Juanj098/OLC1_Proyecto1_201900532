package Analizador;

import java.util.ArrayList;

public class DGRAHPB {
    private String titulo;
    private ArrayList<String> ejeX;
    private ArrayList<Double> ejeY;
    private String TX;
    private String TY;


    // Constructor
    public DGRAHPB(String titulo,String TX, String TY, ArrayList<String> listaString, ArrayList<Double> listaDouble) {
        this.titulo = titulo;
        this.TX = TX;
        this.TY = TY;
        this.ejeX = listaString;
        this.ejeY = listaDouble;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(ArrayList<String> listaString) {
        this.ejeX = listaString;
    }

    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    public void setEjeY(ArrayList<Double> listaDouble) {
        this.ejeY = listaDouble;
    }

    public String getTX() {
        return TX;
    }

    public void setTX(String TX) {
        this.TX = TX;
    }

    public String getTY() {
        return TY;
    }

    public void setTY(String TY) {
        this.TY = TY;
    }
}
