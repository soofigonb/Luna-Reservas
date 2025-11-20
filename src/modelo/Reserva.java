package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sofi
 * 
 */
public class Reserva {
    
    private int idReserva;
    private int idCliente;
    private int idServicio;
    private java.sql.Date fecha;
    private java.sql.Time hora;
    private String estado;

    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, int idServicio, Date fecha, Time hora, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idCliente=" + idCliente + ", idServicio=" + idServicio + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + '}';
    }
    

    
}
