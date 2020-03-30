package práctica7.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer {

    public static void BufferReader(String origen, String destino) {
        int posicion;
        String[] elementos = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        String enunciado = "Cartelera de CineFBMoll";
        int i = 0;
        File entrada = new File(origen);
        try (BufferedReader lector = new BufferedReader(new FileReader (entrada));
                BufferedWriter salida = new BufferedWriter(new FileWriter (destino))) {
            salida.write(enunciado);
            salida.newLine();
            do {
                posicion = lector.read();
                if (posicion != -1) {
                    switch (Character.toString((char) posicion)) {
                        case "#":
                            salida.newLine();
                            salida.write(elementos[i]);
                            i++;
                            break;
                        case "{":
                            salida.newLine();
                            salida.newLine();
                            i = 0;
                            break;
                        default:
                            salida.write(posicion);
                            break;
                    }
                }
            } while (posicion != -1);
            salida.close();
        } catch (IOException exc) {

        }
    }
}