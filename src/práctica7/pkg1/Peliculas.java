package práctica7.pkg1;

import java.io.Serializable;
import static práctica7.pkg1.Práctica71.lector;


public class Peliculas implements Serializable {

    private String titulo = "";
    private String ano = "";
    private String director = "";
    private String duracion = "";
    private String sinopsis = "";
    private String reparto = "";
    private String sesion = "";


    public Peliculas() {
    }


    public Peliculas(String titulo, String ano, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.sesion = sesion;
    }


    public Peliculas(Peliculas p) {
        this.titulo = p.titulo;
        this.ano = p.ano;
        this.director = p.director;
        this.duracion = p.duracion;
        this.sinopsis = p.sinopsis;
        this.reparto = p.reparto;
        this.sesion = p.sesion;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAno() {
        return ano;
    }


    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }


    public String getDuracion() {
        return duracion;
    }


    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }


    public String getSinopsis() {
        return sinopsis;
    }


    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public void mostrarPelicula() {
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Año: " + this.getAno());
        System.out.println("Duración: " + this.getDuracion());
        System.out.println("Sinopsis: " + this.getSinopsis());
        System.out.println("Reparto: " + this.getReparto());
        System.out.println("Sesión: " + this.getSesion());
    }

    public void pedirPelicula() {
        System.out.println("Introduce el título: ");
        this.setTitulo(lector.nextLine());
        System.out.println("Introduce el año: ");
        this.setAno(lector.nextLine());
        System.out.println("Introduce la duración: ");
        this.setDuracion(lector.nextLine());
        System.out.println("Introduce la sinopsis: ");
        this.setSinopsis(lector.nextLine());
        System.out.println("Introduce el reparto: ");
        this.setReparto(lector.nextLine());
        System.out.println("Introduce la sesion: ");
        this.setSesion(lector.nextLine());
    }
}