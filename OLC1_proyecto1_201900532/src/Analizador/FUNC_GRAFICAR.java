package Analizador;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FUNC_GRAFICAR {
//    private static Object outputFile;

    public static void GPIE(DGRAHPP obj) throws IOException {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i =0; i< obj.getListaString().size();i++){
            dataset.setValue(obj.getListaString().get(i),obj.getListaDouble().get(i));
        }
        JFreeChart chart = ChartFactory.createPieChart(
                obj.getTitulo(),
                dataset,
                true,
                true,
                false
        );
        String namefile = obj.getTitulo().replace("\"","");
        File outputFile = new File("C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/"+namefile+".png");
        ChartUtilities.saveChartAsPNG(outputFile,chart,800,800);

    }
    public static void GBAR(DGRAHPB obj) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i =0; i< obj.getEjeX().size();i++){
            dataset.setValue(obj.getEjeY().get(i),obj.getTY(),obj.getEjeX().get(i));
        }
        JFreeChart chart = ChartFactory.createBarChart(
                obj.getTitulo(),
                obj.getTX(),
                obj.getTY(),
                dataset
        );

        String namefile = obj.getTitulo().replace("\"","");
        File outputFile = new File("C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/"+namefile+".png");
        ChartUtilities.saveChartAsPNG(outputFile,chart,800,800);
    }
    public static void GLINE(DGRAHPL obj) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i =0; i< obj.getEjeX().size();i++){
            dataset.setValue(obj.getEjeY().get(i),obj.getTY(),obj.getEjeX().get(i));
        }
        JFreeChart chart = ChartFactory.createLineChart(
                obj.getTitulo(),
                obj.getTX(),
                obj.getTY(),
                dataset
        );

        String namefile = obj.getTitulo().replace("\"","");
        File outputFile = new File("C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/"+namefile+".png");
        ChartUtilities.saveChartAsPNG(outputFile,chart,800,800);
    }
    public static void GHIS(DGRAHPH obj) throws IOException {
        Map<Double,Integer> rec =countDuplicates(obj.getListaDouble());
        double[] dataArray = obj.getListaDouble().stream().mapToDouble(Double::doubleValue).toArray();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Map.Entry<Double,Integer> entry:rec.entrySet()){
            dataset.setValue(entry.getValue(),"FRECUENCIA", entry.getKey().toString());
        }
        JFreeChart chart = ChartFactory.createBarChart(
                obj.getTitulo(),
                "Valores",
                "Frecuencia",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        String namefile = obj.getTitulo().replace("\"","");
        File outputFile = new File("C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/"+namefile+".png");
        ChartUtilities.saveChartAsPNG(outputFile,chart,800,800);
    }
    public static Map<Double, Integer> countDuplicates(ArrayList<Double> list) {
        Map<Double, Integer> countMap = new HashMap<>();
        for (Double num : list) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        return countMap;
    }
    public static String PrintTable(DGRAHPH obj) throws  IOException{
        String table = "";
        table = obj.getTitulo()+"\n"+"<---------------------->\n"+"<VALOR   Fb    Fa   F% >\n"+"<---------------------->\n";
        Collections.sort(obj.getListaDouble());
        Map<Double,Integer> rec =countDuplicates(obj.getListaDouble());
        Integer fa = 0;
        Integer cont = 0;
        for(Map.Entry<Double,Integer> entry:rec.entrySet()){
            cont = cont + entry.getValue();
        }

        for(Map.Entry<Double,Integer> entry:rec.entrySet()){
            fa = fa+entry.getValue();
            table =  table + "<  "+entry.getKey().toString()+"    "+entry.getValue()+"    "+fa+"    "+(entry.getValue()*100)/cont+" >\n"
            ;
        }
//        String ValStung;
        table = table +"<---------------------->\n"+"< total   "+fa+"    "+cont+"  "+" 100 >\n";
        return table;
    }
}

