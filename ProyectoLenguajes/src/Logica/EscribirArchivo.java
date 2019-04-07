/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kurisu
 */
public class EscribirArchivo {

    public void Escribir() throws IOException {
        //Un texto cualquiera guardado en una variable
        char Aloha = 10;
        String saludo = "Hola";

        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("texto.txt");

//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

//Escribimos en el archivo con el metodo write 
            escribir.write(saludo+Aloha+saludo);

//Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
        
        Logica.LeerArchivo leer = new Logica.LeerArchivo();
        Logica.EscribirArchivo escribir = new Logica.EscribirArchivo();
        leer.muestraContenido("C:\\Users\\Kurisu\\Desktop\\TeoriaDeLaComputación\\ProyectoLenguajes\\Listas\\test2.txt");
        escribir.Escribir();
    }
 
}
