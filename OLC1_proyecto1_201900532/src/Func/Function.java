package Func;

import Errores.Errores;

import java.util.*;
import java.util.Collection;

public class Function {
    public static LinkedList<Errores> list = new LinkedList<>();

    public static double Media(ArrayList<Double> lista){
        double sumatoria = 0;
        double promedio;
        for (int i=0;i<lista.size();i++) {
            sumatoria = sumatoria+lista.get(i);
        };
        promedio = sumatoria/lista.size();
        promedio = Math.floor(promedio*100)/100;
        return promedio;
    }
    public static double Moda(ArrayList<Double> lista){
        HashMap<Double,Integer> frec = new HashMap<>();
        for(Double valor:lista){
            if (frec.containsKey(valor)){
                frec.put(valor,frec.get(valor)+1);
            }else{
                frec.put(valor,1);
            }
        }
        Double moda = null;
        int frecMax = 0;
        for (Map.Entry<Double,Integer> entry : frec.entrySet()){
            if(entry.getValue() > frecMax){
                moda = entry.getKey();
                frecMax = entry.getValue();
            }
        }
        return moda;
    }
    public static double Mediana(ArrayList<Double> lista){
        Collections.sort(lista);
        int n = lista.size();
        if (n%2!=0){
            return lista.get(n/2);
        } else {
            double v1 = lista.get((n/2)-1);
            double v2 = lista.get((n/2));
            return (v2+v1)/2.0;
        }
    }
    public static double Varianza(ArrayList<Double> lista){
        double suma = 0;
        int n = lista.size();
        for(int i=0;i<lista.size();i++){
            suma+=lista.get(i);
        }
        double media = suma/n;
        double sumacua =0.0;
        for (int j=0;j<lista.size();j++){
            sumacua += Math.pow(lista.get(j)-media,2);
        }
        double varianza = sumacua/n;
        return varianza;
    }
    public static Double Max(ArrayList<Double> lista){
        Collections.sort(lista);
        int n = lista.size();
        return lista.get(n-1);
    }
    public static Double Min(ArrayList<Double> lista){
        Collections.sort(lista);
        int n = lista.size();
        return lista.get(0);
    }
}


