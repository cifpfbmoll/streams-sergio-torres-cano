package práctica7.pkg1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public final class PathException extends Exception {

    private String mensaje;
    private String traza;

    public PathException() {
    }

    public PathException(String mensaje, String traza) {
        this.mensaje = getMessage();
        this.traza = Arrays.toString(getStackTrace());
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTraza() {
        return traza;
    }

    public void setTraza(String traza) {
        this.traza = traza;
    }

    
    public static void PathException(String mensaje, String traza) {
        try (BufferedWriter writerMejorado = new BufferedWriter(new FileWriter("errores.txt", true))) {

            Date fecha = Calendar.getInstance().getTime();
            String plantilla = "MM/dd/yyyy HH:mm:ss";
            DateFormat formatofecha = new SimpleDateFormat(plantilla);
            String fechahoraString = formatofecha.format(fecha);
            writerMejorado.write(fechahoraString);
            writerMejorado.write(": " + mensaje);
            writerMejorado.write("\n" + traza + "\n\n");
        } catch (IOException eio) {
            System.out.println("Error al leer el archivo.");
        }

    }
}
