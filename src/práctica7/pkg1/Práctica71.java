package práctica7.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
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
                    case 4:
                        boolean salir = false;
                        System.out.println("1-Lectura línea a línea y escritura con objetos. ");
                        System.out.println("2-Lectura de objetos y escritura de objetos.");
                        System.out.println("3-Lectura de objetos y escritura por consola.");
                        System.out.println("4-Lectura por consola y escritura de objetos.");
                        System.out.println("5-Volver al menú principal.");
                        while (!salir){
                            switch (Integer.parseInt(lector.nextLine())){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    salir = true;
                                    break;
                            }
                        }
                }
            } catch (InputMismatchException e) {
                System.out.println("Inserte una opción correcta.");
                lector.next();
            } catch (NumberFormatException pe) {
                throw new PathException(pe + "Error en el archivo", Arrays.toString(pe.getStackTrace()));
            } catch (FileNotFoundException fe) {
                throw new PathException(fe + "No se ha introducido la ruta", Arrays.toString(fe.getStackTrace()));
            } catch (IOException ie) {
                System.out.println("Error al leer el archivo.");
                throw new PathException(ie.getMessage(), Arrays.toString(ie.getStackTrace()));
            }
        }

    }
}
