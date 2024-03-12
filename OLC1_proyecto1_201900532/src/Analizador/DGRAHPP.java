package Analizador;

import java.util.ArrayList;

public class DGRAHPP {
        private String titulo;
        private ArrayList<String> listaString;
        private ArrayList<Double> listaDouble;

        // Constructor
        public DGRAHPP(String titulo, ArrayList<String> listaString, ArrayList<Double> listaDouble) {
            this.titulo = titulo;
            this.listaString = listaString;
            this.listaDouble = listaDouble;
        }

        // Getters y Setters
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public ArrayList<String> getListaString() {
            return listaString;
        }

        public void setListaString(ArrayList<String> listaString) {
            this.listaString = listaString;
        }

        public ArrayList<Double> getListaDouble() {
            return listaDouble;
        }

        public void setListaDouble(ArrayList<Double> listaDouble) {
            this.listaDouble = listaDouble;
        }
    }

