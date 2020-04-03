package práctica7.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Char {

    public static void CharReader(String origen, String destino) throws PathException {
        int posicion;
        String[] elementos = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        String enunciado = "Cartelera de CineFBMoll";
        int i = 0;
        File entrada = new File(origen);
        try (FileReader lector = new FileReader(entrada);
                FileWriter salida = new FileWriter(destino)) {

            for (int j = 0; j < enunciado.length(); j++) {
                salida.write(enunciado.charAt(j));
            }
            salida.write((char) 10);
            do {
                posicion = lector.read();
                if (posicion != -1) {
                    switch (Character.toString((char) posicion)) {
                        case "#":
                            salida.write((char) 10);
                            if (i >= 0 && i < 6) {
                                for (int j = 0; j < elementos[i].length(); j++) {
                                    salida.write(elementos[i].charAt(j));
                                }
                            }
                            i++;
                            break;
                        case "{":
                            salida.write((char) 10);
                            salida.write((char) 10);
                            i = 0;
                            break;
                        default:
                            salida.write(posicion);
                            break;
                    }
                }
            } while (posicion != -1);
            salida.close();
        } catch (FileNotFoundException fe) {
            throw new PathException(fe.getMessage(), Arrays.toString(fe.getStackTrace()));
        } catch (IOException ie) {
            System.out.println("Error al leer el archivo.");
            throw new PathException(ie.getMessage(), Arrays.toString(ie.getStackTrace()));
            
        }
    }
}
