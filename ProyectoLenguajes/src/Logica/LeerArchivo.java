package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Vector;

public class LeerArchivo {

    public Vector muestraContenido(String archivo) throws FileNotFoundException, IOException {
        Vector vector=new Vector();
        String cadena;
        boolean anterior = false, esta = false;
        int marca = 0;
        String testing = "";
        String guarda = "l";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {

            esta = false;
            try {
                if (Character.toString(cadena.charAt(0)).matches("[a-zA-Z0-9*()><_':]") || cadena.charAt(0) == ' ' || cadena.charAt(0) == '"' || cadena.charAt(0) == 00 || cadena.charAt(0) == 9) {
                    esta = true;
                }
            } catch (Exception e) {
                esta = false;
            }

            testing = "";
            marca = 0;

            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) != '[' && cadena.charAt(i) != ']') {
                    testing += cadena.charAt(i);
                }
                if (marca == 1 && cadena.charAt(i) == '-' && !anterior) {
                    if (!Character.toString(guarda.charAt(0)).matches("[a-zA-Z0-9]")) {
                        guarda = guarda.substring(1, guarda.length());
                    }
                    if (!testing.matches(".*" + guarda + ".*") && !anterior ) {
                        //testing.substring(0, testing.length() - 2)
                        vector.addElement(testing.substring(0, testing.length() - 2));
                    }

                    guarda = testing;
                    break;
                } else if (marca == 1 && cadena.charAt(i) != '-') {
                    marca = 0;
                }
                if (cadena.charAt(i) == ' ') {
                    marca = 1;
                }
            }

            anterior = esta;

        }

        b.close();
        
        return vector;
    }
}
