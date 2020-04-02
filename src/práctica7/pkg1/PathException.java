package práctica7.pkg1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class PathException extends Exception {

    private String message;
    private int error;

    public PathException() {
    }

    public PathException(String message, int error) {
        this.message = message;
        this.error = error;
    }

    public PathException(int errorCode) {
        if (error == 123) {
            this.setMessage("No es una ruta valida");
        } else if (error == 321) {
            this.setMessage("Ruta del archivo no encontrado.");
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int errorCode) {
        this.error = errorCode;
    }

    public static void logErrors(String errorMessage, StackTraceElement[] stack) {
        String newLine = System.getProperty("line.separator");
        try (OutputStreamWriter errorlog = new OutputStreamWriter(
                new FileOutputStream("Log_error.txt", true), StandardCharsets.UTF_8)) {
            LogFecha(errorlog);
            errorlog.write(errorMessage);
            errorlog.append(newLine);
            for (StackTraceElement stack1 : stack) { 
                errorlog.write(stack1.toString());
                errorlog.append(newLine);
            }
        } catch (IOException ex) {
            System.out.println("Unexpected error.");
        }
    }

    public static void LogFecha(OutputStreamWriter writer) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        writer.write(dateFormat.format(date));
    }
}