package práctica7.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Buffer {

    public static void BufferReader(String origen, String destino) throws PathException {
        int posicion;
        String[] elementos = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        String enunciado = "Cartelera de CineFBMoll";
        boolean bucle = false;
        File entrada = new File(origen);
        int i = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(entrada));
                BufferedWriter salida = new BufferedWriter(new FileWriter(destino))) {

            salida.write(enunciado);
            salida.newLine();
            salida.newLine();
            String linealeida = lector.readLine();
            String[] peliculas = linealeida.split("\\{");
            String[][] apartado_peliculas = new String[peliculas.length][elementos.length + 1];
            for (int j = 0; j < peliculas.length; j++) {
                apartado_peliculas[j] = peliculas[j].split("#");
            }

            for (String[] apartado_pelicula : apartado_peliculas) {
                for (int k = 0; k < apartado_peliculas[0].length; k++) {
                    salida.write(apartado_pelicula[k]);
                    salida.newLine();
                    if (i < 6) {
                        salida.write(elementos[i]);
                        i++;
                    } else {
                        i = 0;
                    }
                }
                salida.newLine();

            }
            salida.close();
        } catch (FileNotFoundException fe){
            throw new PathException(fe.getMessage(), Arrays.toString(fe.getStackTrace()));
            
        } catch (IOException ie){
            System.out.println("Error al leer el archivo.");
            
        }
    }
}
