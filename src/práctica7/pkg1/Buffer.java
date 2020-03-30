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
        boolean bucle = false;
        File entrada = new File(origen);
        int i = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(entrada));
                BufferedWriter salida = new BufferedWriter(new FileWriter(destino))) {
            String linealeida = lector.readLine();
            String[] peliculas = linealeida.split("\\{");
            String[][] apartado_peliculas = null;
            for (int j = 0; j < peliculas.length; j++) {
                apartado_peliculas[j] = peliculas[j].split("#");
            }
            salida.newLine();

            for (int j = 0; j < apartado_peliculas[j].length; j++) {
                for (int k=0; k < apartado_peliculas[j][k].length(); k++){
                    salida.write(apartado_peliculas[j][k]);
                }
                salida.newLine();
                if (i < 6) {
                    salida.write(elementos[i]);
                    i++;
                } else {
                    i = 0;
                }
            }
            salida.close();
        } catch (IOException exc) {
            System.out.println("Error al introducir la ruta");
            System.out.println(exc.getMessage());
        }
    }
}
