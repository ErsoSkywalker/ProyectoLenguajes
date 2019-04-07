package Ventanas;
//Importamos Clases que necesitaremos

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaBuena extends javax.swing.JFrame {

    /*Aquí creamos tres variables globales, indispensables para llenar la tabla más adelante.
    La primera es md, la cual será el modelo al que recurrirá la tabla.
    la segunda es data, es una matriz donde se irán guardando los nombres de los lenguajes
    La tercera es Nombres, este será el nombre de la columna.
     */

    DefaultTableModel md;
    String data[][] = {};
    String Nombres[] = {"Lenguaje"};

    /*Este es nuestro constructor, donde indicamos una referencia a initComponents()
    Un setLocationRelativeTo que nos servirá para ajustar la ventana en el centro
    md es nuestra variable que llenamos con nombres y datos
    Y abajo le decimos a la tabla que se refiera a md para llenarse
     */
    public VentanaBuena() {
        initComponents();
        ArrayList<String> Hola = new ArrayList<>();
        setLocationRelativeTo(null);
        md = new DefaultTableModel(data, Nombres);
        tblDatos.setModel(md);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 460, 150));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Filtrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/9421999025_3046732b6d_b.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Este metodo es el que se refiere para el evento del boton salir, cuando se es presionado, se cierra la ventana
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    //Aquí está el algoritmo que usaremos para filtrar los nombres
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(".txt", "txt");
        file.setFileFilter(filtroImagen);
        file.showOpenDialog(this);

        /**
         * abrimos el archivo seleccionado
         */
        File abre = file.getSelectedFile();
        String nombre = file.getName(abre);
        System.out.println(nombre);

        //inicializamos Variables y Banderas
        if (nombre.charAt(nombre.length() - 1) == 't' && nombre.charAt(nombre.length() - 2) == 'x' && nombre.charAt(nombre.length() - 3) == 't' && nombre.charAt(nombre.length() - 4) == '.') {

            String cadena;
            boolean anterior = false, esta = false;
            int marca = 0;
            String testing = "";
            String guarda = "l";
            //Abrimos Try-Catch, por si hay un error
            try {
                //Abrimos un File Reader e indicamos el Archivo al que ingresaremos
                FileReader f = new FileReader(abre);
                BufferedReader b = new BufferedReader(f);
                //Usamos el Buffered para recorrer linea por linea nuestro archivo
                //Mientras este no sea nulo, seguirá recorriendo
                while ((cadena = b.readLine()) != null) {
                    //declaramos la variable "esta" como false, "esta" y "siguiente" son variables para validar si está vacio o no la linea
                    esta = false;
                    try {
                        //Aquí validamos si la linea está vacia, si está vacia le damos un true a "esta"
                        //Aquí aplicamos una expresión regular para validar que no haya ningun caracter como a-zA-Z0-9*()><_':, caracteres vacios y caracteres ASCII
                        //El 00 del ASCII es un espacio en blanco, el 9 es un tabulador
                        if (Character.toString(cadena.charAt(0)).matches("[a-zA-Z0-9*()><_':]") || cadena.charAt(0) == ' ' || cadena.charAt(0) == '"' || cadena.charAt(0) == 00 || cadena.charAt(0) == 9) {
                            esta = true;
                        }
                    } catch (Exception e) {
                        esta = false;
                    }
                    //Testing será nuestra palabra rescatada
                    testing = "";
                    //marca es una bandera que validará si hubo o no un espacio en ese caracter
                    marca = 0;
                    //Con este for, recorreremos caracter por caracter nuestra cadena rescatada por el Buffer
                    for (int i = 0; i < cadena.length(); i++) {
                        //Aquí validaremos, si inicia o termina con corchetes no los incluiremos, ya que nos echará errores en nuestra
                        //Regular expression cuando validemos más adelante

                        if (cadena.charAt(i) != '[' && cadena.charAt(i) != ']') {
                            testing += cadena.charAt(i);
                        }

                        //Cuando marca es 1, significa que hubo un espacio, si el siguiente es un guion, significa que es un lenguaje
                        //Ademas de que la linea anterior debe estar vacia
                        if (marca == 1 && cadena.charAt(i) == '-' && !anterior) {
                            //Aquí aplicamos un regex, para validar caracter por caracter, si entra en [a-zA-Z0-9]
                            //Se guarda dentro del string, quitandole el espacio y el guion
                            if (!Character.toString(guarda.charAt(0)).matches("[a-zA-Z0-9]")) {
                                guarda = guarda.substring(1, guarda.length());
                            }
                            //Aquí hacemos otra Regex, donde validamos que la palabra tenga algo detrás o antes, si es así 
                            //iguardamos dentro del arreglo

                            if (!testing.matches(".*" + guarda + ".*") && !anterior) {
                                System.out.println(testing.substring(0, testing.length() - 2));
                                String[] arreglito = {testing.substring(0, testing.length() - 2)};
                                //Aquí vaciamos dentro del modelo nuestro arreglo, cada que se
                                //reinicia el for, se reinicia el arreglo, pero no el modelo
                                md.addRow(arreglito);
                            }

                            guarda = testing;
                            //Acemos un break para que deje de recorrer la linea
                            break;
                            //Si hubo un espacio pero a continuación no hay un guion, entonces marca vualve a ser 0
                        } else if (marca == 1 && cadena.charAt(i) != '-') {
                            marca = 0;
                        }
                        //Si hay un espacio, marca es igual a 1
                        if (cadena.charAt(i) == ' ') {
                            marca = 1;
                        }
                    }
                    //Aquí pasamos el estado de la linea presente a una linea anterior
                    anterior = esta;

                }
                //Cerramos buffer
                b.close();
                //Cerramos Try catch imprimiendo el error
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            System.out.println("Funciona");
        } else {
            JOptionPane.showMessageDialog(null, "No lo vas a tronar, selecciona un txt.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    //Aquí corremos la app
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBuena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBuena().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
