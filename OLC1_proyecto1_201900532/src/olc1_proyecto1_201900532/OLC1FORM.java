package olc1_proyecto1_201900532;
import Analizador.*;
import Analizador.RESP;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static Test.test.Analizar;

public class OLC1FORM extends JFrame {
    private JTabbedPane ventana;
    private JPanel panel1;
    private JButton ABRIRDfButton;
    private JTextArea textArea1;
    private JButton NUEVOARCHIVOButton;
    private JButton EJECUTARButton;
    private JButton GUARDARButton;
    private JButton SALIRButton;
    private JTextArea textArea2;
    private JTable table1;
    private JTable table2;
    private JTable table3;

    public OLC1FORM(){
        super("OLC1");
        setContentPane(panel1);

        ABRIRDfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("SELECCIONAR ARCHIVO");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos .df","df");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(OLC1FORM.this);
                if (result ==JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    if(file.getName().toLowerCase().endsWith(".df")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                            String line;
                            System.out.println("file -> " + file.getAbsolutePath());
                            StringBuilder cont = new StringBuilder();
                            while ((line = reader.readLine())!= null){
                                System.out.println(line);
                                cont.append(line).append("\n");
                            }
                            textArea1.setText(cont.toString());
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(OLC1FORM.this, "El archivo seleccionado no es .df", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    System.out.println("operacion cancelada");
                }
            }
        });
        EJECUTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea2.setText("");
                    StringBuilder resultadoTexto = new StringBuilder();
                    String input = textArea1.getText();
                    Reader sr=  new StringReader(input);
                    Analizador.Lexer lx = new Analizador.Lexer(sr);
                    Analizador.Parser parse = new Analizador.Parser(lx);
                    parse.parse();
                    ArrayList<RESP> result = Parser.resultad;
                    Object val = null;
                    for(RESP r:result){
                        val =r.getRespuesta();
                        System.out.println("resu ->"+val);
                        if (val instanceof respString) {
                            String dato = ((respString) val).getValor();
                            resultadoTexto.append(dato).append("\n");
                        } else if (val instanceof respDouble) {
                            Double dato = ((respDouble) val).getValor();
                            resultadoTexto.append(dato).append("\n");

                        }
                    }
                    textArea2.setText(resultadoTexto.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(OLC1FORM.this,"ERROR EN EL ANALISIS");
                    throw new RuntimeException(ex);
                }
            }
        });

    }

}

