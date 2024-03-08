package Func;

import Errores.Errores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

}


