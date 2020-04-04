package práctica7.pkg1;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static práctica7.pkg1.Buffer.BufferReader;
import static práctica7.pkg1.Char.CharReader;
import static práctica7.pkg1.Input.InputStream;
public class Práctica71 {

    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws PathException {
        boolean bucle = false;
        System.out.println("Introduzca ruta origen.");
        String rutaOrigen = lector.nextLine();
        System.out.println("Introduzca ruta destino.");
        String rutaDestino = lector.nextLine();
        while (!bucle) {
            System.out.println("Introduzca una de las siguientes opciones:");
            System.out.println("1-Lectura y escritura del fichero de cartelera byte a byte (byte Streams).");
            System.out.println("2-Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).");
            System.out.println("3-Lectura y escritura de fichero línea a línea con buffers (character Streams).");
            try {
                switch (Integer.parseInt(lector.nextLine())) {
                    case 1:
                        InputStream(rutaOrigen, rutaDestino);
                        bucle = true;
                        break;
                    case 2:
                        CharReader(rutaOrigen, rutaDestino);
                        bucle = true;
                        break;
                    case 3:
                        BufferReader(rutaOrigen, rutaDestino);
                        bucle = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Inserte una opción correcta.");
                lector.next();
            } catch (PathException | IOException | NumberFormatException pe) {
                throw new PathException(pe.getMessage(), Arrays.toString(pe.getStackTrace()));
            }
                
        

        }
        
    }
}
