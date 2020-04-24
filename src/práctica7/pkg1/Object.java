/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica7.pkg1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sergio
 */
public class Object {
    public static void leerObjEscribirObj(String origen, String destino) throws PathException, FileNotFoundException{
        try (ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream(origen));
                ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(destino))) {
            boolean eof = false;
            while (!eof) {
                objectSalida.writeObject(new Pelicula((Peliculas) objectEntrada.readObject()));
            }
        } catch (EOFException e) {
            System.out.println("fin de fichero");
        } catch (IOException ex) {
            System.out.println("Error de lectura/escritura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de clase");
        }
    }
}
