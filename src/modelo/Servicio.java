package modelo;

/**
 *
 * @author Sofi
 * 
 */
public class Servicio {
    
    private int idServicio;
    private String nombre;
    private int precio;
    private int duracion; 
    private String tipo; 

    public Servicio() {
    }

    public Servicio(int idServicio, String nombre, int precio, int duracion, String tipo) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", nombre=" + nombre + ", precio=" + precio + ", duracion=" + duracion + ", tipo=" + tipo + '}';
    }
    
    

   
    

    
}
