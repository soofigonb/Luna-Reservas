package modelo;

import bd.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Sofi
 * 
 */

public class ReservaDAO {
    
        // Verifica si el cliente existe consultando el ClienteDAO.
    // Esto evita registrar reservas con clientes inexistentes.
    private boolean clienteExiste(int idCliente) {
        ClienteDAO dao = new ClienteDAO();
        return dao.buscarClientePorId(idCliente) != null;
    }

    // Verifica si el servicio existe consultando el ServicioDAO.
    // Esto evita registrar reservas con servicios que no están en la base.
    private boolean servicioExiste(int idServicio) {
        ServicioDAO dao = new ServicioDAO();
        return dao.buscarServicioPorId(idServicio) != null;
    }

    // Revisa si una fecha y hora están disponibles para agendar una reserva.
    // Si ya existe una reserva en ese mismo horario, no permite agendar.
    public boolean horaDisponible(Date fecha, Time hora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean disponible = true;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM reserva WHERE fecha = ? AND hora = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, fecha);
            stmt.setTime(2, hora);

            rs = stmt.executeQuery();
            if (rs.next()) disponible = false; // Ya existe reserva en ese horario

        } catch (SQLException e) {
            System.err.println("Error al validar hora: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return disponible;
    }

    // Inserta una nueva reserva en la base de datos.
    // Aplica validaciones de integridad, horario disponible y estado válido.
    public boolean agregarReserva(Reserva r) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            // Validar existencia de cliente y servicio
            if (!clienteExiste(r.getIdCliente())) return false;
            if (!servicioExiste(r.getIdServicio())) return false;

            // Validaciones de formato
            if (r.getFecha() == null) return false;
            if (r.getHora() == null) return false;

            // Validar disponibilidad del horario
            if (!horaDisponible(r.getFecha(), r.getHora())) return false;

            // Validar estado
            if (r.getEstado() == null || r.getEstado().trim().isEmpty()) return false;

            conn = ConexionDB.obtenerConexion();
            String sql = "INSERT INTO reserva (idCliente, idServicio, fecha, hora, estado) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, r.getIdCliente());
            stmt.setInt(2, r.getIdServicio());
            stmt.setDate(3, r.getFecha());
            stmt.setTime(4, r.getHora());
            stmt.setString(5, r.getEstado());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al agregar reserva: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return exito;
    }

    // Obtiene todas las reservas ordenadas por fecha y hora.
    // Cada fila de la tabla se convierte en un objeto Reserva.
    public ArrayList<Reserva> listarReservas() {
        ArrayList<Reserva> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM reserva ORDER BY fecha ASC, hora ASC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idServicio"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("estado")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar reservas: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return lista;
    }

    // Lista todas las reservas de una fecha específica.
    // Útil para ver la carga diaria de horas disponibles.
    public ArrayList<Reserva> listarReservasPorFecha(Date fecha) {
        ArrayList<Reserva> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM reserva WHERE fecha = ? ORDER BY hora ASC";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, fecha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idServicio"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("estado")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar reservas por fecha: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return lista;
    }

    // Busca una reserva específica por su ID.
    // Retorna un objeto Reserva si existe, o null si no está.
    public Reserva buscarReservaPorId(int idReserva) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reserva r = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM reserva WHERE idReserva = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idReserva);
            rs = stmt.executeQuery();

            if (rs.next()) {
                r = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idServicio"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("estado")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar reserva por ID: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return r;
    }

    // Actualiza los datos de una reserva existente.
    // Asegura que el cliente, servicio, fecha, hora y estado sean válidos.
    public boolean actualizarReserva(Reserva r) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            if (!clienteExiste(r.getIdCliente())) return false;
            if (!servicioExiste(r.getIdServicio())) return false;
            if (r.getFecha() == null || r.getHora() == null) return false;
            if (r.getEstado() == null || r.getEstado().trim().isEmpty()) return false;

            conn = ConexionDB.obtenerConexion();

            String sql = "UPDATE reserva SET idCliente = ?, idServicio = ?, fecha = ?, hora = ?, estado = ? WHERE idReserva = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, r.getIdCliente());
            stmt.setInt(2, r.getIdServicio());
            stmt.setDate(3, r.getFecha());
            stmt.setTime(4, r.getHora());
            stmt.setString(5, r.getEstado());
            stmt.setInt(6, r.getIdReserva());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al actualizar reserva: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return exito;
    }

    // Elimina una reserva de la base de datos según su ID.
    // Retorna true si la eliminación se realizó correctamente.
    public boolean eliminarReserva(int idReserva) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "DELETE FROM reserva WHERE idReserva = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idReserva);

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al eliminar reserva: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return exito;
    }

}
