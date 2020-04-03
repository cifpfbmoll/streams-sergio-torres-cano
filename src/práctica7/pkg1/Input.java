package práctica7.pkg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Input {

    public static void InputStream(String origen, String destino) throws PathException, IOException {
        int posicion;
        String[] elementos = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        String enunciado = "Cartelera de CineFBMoll";
        int i = 0;
        byte[] enunciado_escrito = enunciado.getBytes();
        FileInputStream entrada = new FileInputStream(origen);
        FileOutputStream salida = new FileOutputStream(destino);
        salida.write(enunciado_escrito);
        salida.write((char) 10);
        do {
            posicion = entrada.read();
            if (posicion != -1) {
                switch (Character.toString((char) posicion)) {
                    case "#":
                        salida.write((char) 10);
                        if (i >= 0 && i < 6) {
                            byte[] elemento_escrito = elementos[i].getBytes();
                            salida.write(elemento_escrito);
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
    }
}
