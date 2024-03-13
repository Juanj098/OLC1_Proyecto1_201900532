package olc1_proyecto1_201900532;
import Analizador.*;
import Analizador.RESP;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.LinkedList;

import Errores.Errores;
import Func.Function;
import Analizador.Parser;

public class OLC1FORM extends JFrame {
    public LinkedList<String> filesPath = new LinkedList<>();
    Integer index = 0;
    FileWriter fileWriter = null;

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton ABRIRDfButton;
    private JTextArea txt1;
    private JButton EJECUTARButton;
    private JPanel paneAnalizar;
    private JTextArea txt2;
    private JButton btnAnt;
    private JButton btnSig;
    private JLabel imglbel;
    private JButton SALIRButton;
    private JButton REPORTEDETABLADEButton;
    private JButton REPORTEDEERRORESButton;
    private JButton REPORTEDETOKENSButton;
    private JButton button1;

    public OLC1FORM() {
        super("OLC1");
        setContentPane(panel1);
        ABRIRDfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("SELECCIONAR ARCHIVO");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos .df", "df");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(OLC1FORM.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file.getName().toLowerCase().endsWith(".df")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            System.out.println("file -> " + file.getAbsolutePath());
                            StringBuilder cont = new StringBuilder();
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                                cont.append(line).append("\n");
                            }
                            txt1.setText(cont.toString());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(OLC1FORM.this, "El archivo seleccionado no es .df", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("operacion cancelada");
                }
            }
        });
        EJECUTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txt2.setText("");
                    StringBuilder resultadoTexto = new StringBuilder();
                    String input = txt1.getText();
                    Reader sr = new StringReader(input);
                    Analizador.Lexer lx = new Analizador.Lexer(sr);
                    Analizador.Parser parse = new Analizador.Parser(lx);
                    parse.parse();
                    ArrayList<RESP> result = Parser.resultad;
                    Object val = null;
                    for (RESP r : result) {
                        val = r.getRespuesta();
                        System.out.println("resu ->" + val);
                        if (val instanceof respString) {
                            String dato = ((respString) val).getValor();
                            resultadoTexto.append(dato).append("\n");
                        } else if (val instanceof respDouble) {
                            Double dato = ((respDouble) val).getValor();
                            resultadoTexto.append(dato).append("\n");

                        }
                    }
                    txt2.setText(resultadoTexto.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(OLC1FORM.this, "ERROR EN EL ANALISIS");
                    throw new RuntimeException(ex);
                }
                String FolderP = "C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/";
                File folder = new File(FolderP);
                if (folder.exists() && folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File f : files) {
                            if (f.isFile() && isImg(f.getName())) {
                                filesPath.add(f.getName());
                            }
                        }
                    }
                }
                String name = filesPath.get(index);
                Showimg(name);
                enabledisable();
            }
        });
        btnAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index > 0) {
                    index--;
                    String name = filesPath.get(index);
                    Showimg(name);
                    enabledisable();
                }
            }
        });
        btnSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < filesPath.size() - 1) {
                    index++;
                    String name = filesPath.get(index);
                    Showimg(name);
                    enabledisable();
                }
            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        REPORTEDEERRORESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileWriter = new FileWriter("reporte_err.html");
                    fileWriter.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Contenido</title>\n</head>\n<body>\n");
                    fileWriter.write("<table border=\"1\">\n<tr><th>Índice</th><th>Contenido</th></tr>\n");
                    int index = 0;
                    for (Errores item : Function.list_err) {
                        fileWriter.write("<tr><td>" + index + "</td><td>" + item + "</td></tr>\n");
                        index++;
                    }
                    fileWriter.write("</table>\n");
                    fileWriter.write("</body>\n</html>");
                    System.out.println("Archivo HTML generado correctamente.");
                    File htmlFile = new File("reporte_err.html");
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
                    System.out.println("Error al generar el archivo HTML: " + ex.getMessage());
                } finally {
                    try {
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (IOException ex) {
                        System.out.println("Error al cerrar el FileWriter: " + ex.getMessage());
                    }
                }
            }
        });
        REPORTEDETABLADEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileWriter = new FileWriter("reporte_TS.html");
                    fileWriter.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Contenido</title>\n</head>\n<body>\n");
                    fileWriter.write("<table border=\"1\">\n<tr><th>Índice</th><th>Contenido</th></tr>\n");
                    int index = 0;
                    for (NodoSym item : Parser.TS) {
                        fileWriter.write("<tr><td>" + index + "</td><td>" + item + "</td></tr>\n");
                        index++;
                    }
                    fileWriter.write("</table>\n");
                    fileWriter.write("</body>\n</html>");
                    System.out.println("Archivo HTML generado correctamente.");
                    File htmlFile = new File("reporte_TS.html");
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
                    System.out.println("Error al generar el archivo HTML: " + ex.getMessage());
                } finally {
                    try {
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (IOException ex) {
                        System.out.println("Error al cerrar el FileWriter: " + ex.getMessage());
                    }
                }
            }
        });
        REPORTEDETOKENSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileWriter = new FileWriter("reporte_Token.html");
                    fileWriter.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Contenido</title>\n</head>\n<body>\n");
                    fileWriter.write("<table border=\"1\">\n<tr><th>Índice</th><th>Contenido</th></tr>\n");
                    int index = 0;
                    for (Token item : Function.list_Token) {
                        fileWriter.write("<tr><td>" + index + "</td><td>" + item + "</td></tr>\n");
                        index++;
                    }
                    fileWriter.write("</table>\n");
                    fileWriter.write("</body>\n</html>");
                    System.out.println("Archivo HTML generado correctamente.");
                    File htmlFile = new File("reporte_Token.html");
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
                    System.out.println("Error al generar el archivo HTML: " + ex.getMessage());
                } finally {
                    try {
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (IOException ex) {
                        System.out.println("Error al cerrar el FileWriter: " + ex.getMessage());
                    }
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filesPath.clear();
                String FolderP = "C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/";
                File folder = new File(FolderP);
                if (folder.exists() && folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File f : files) {
                            if (f.isFile() && isImg(f.getName())) {
                                filesPath.add(f.getName());
                            }
                        }
                    }
                }
                String name = filesPath.get(index);
                Showimg(name);
                enabledisable();
            }
        });
    }
        public void Showimg (String name){
            ImageIcon Myimg = new ImageIcon("C:/Users/juanj/OneDrive/Escritorio/Compiladores 1/OLC1_Proyecto1_201900532/OLC1_proyecto1_201900532/src/GRPHS/" + name);
            Image imagen = Myimg.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon escaledIcon = new ImageIcon(imagen);
            imglbel.setIcon(escaledIcon);
        }

        public static String getFileEX (String path){
            int dotIndex = path.lastIndexOf(".");
            if (dotIndex > 0 && dotIndex < path.length() - 1) {
                return path.substring(dotIndex + 1).toLowerCase();
            }
            return null;
        }

        public static boolean isImg(String name){
            String ext = getFileEX(name);
            if (ext != null && (ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg"))) {
                return true;
            }
            return false;
        }

        private void enabledisable () {
            if (index - 1 <= 0) {
                btnAnt.setEnabled(false);
            }
            if (index > 0) {
                btnAnt.setEnabled(true);
            }
            if (index + 1 >= filesPath.size()) {
                btnSig.setEnabled(false);
            }
            if (index < filesPath.size()) {
                btnSig.setEnabled(true);
            }
        }

}

