package model;

/**
 *
 * @author Daniela
 */
public class Juegos {
    
    private int idjuego;
    private String nombre;
    private String genero;
    private String plataforma;
    private int unidades;
    private double precio;

    //  CONSTRUCTORES
    public Juegos() {
    }

    public Juegos(String nombre, String genero, String plataforma, int unidades, double precio) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.unidades = unidades;
        this.precio = precio;
    }

    public Juegos(int idjuego, String nombre, String genero, String plataforma, int unidades, double precio) {
        this.idjuego = idjuego;
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.unidades = unidades;
        this.precio = precio;
    }
    
    
    // GETTERS Y SETTERS

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
}
