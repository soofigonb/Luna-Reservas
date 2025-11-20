package modelo;

import bd.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sofi
 * 
 */

public class ServicioDAO {

    // Busca un servicio por su nombre.
    // Permite verificar duplicados antes de agregar.
    public Servicio buscarServicioPorNombre(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio s = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM servicio WHERE nombre = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Construye el objeto Servicio a partir de la fila obtenida
                s = new Servicio(
                        rs.getInt("idServicio"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("duracion"),
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar servicio por nombre: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return s;
    }

    // Inserta un servicio nuevo en la base de datos.
    // Aplica validaciones básicas y evita duplicados por nombre.
    public boolean agregarServicio(Servicio s) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            // Validaciones obligatorias
            if (s.getNombre() == null || s.getNombre().trim().isEmpty()) return false;
            if (s.getPrecio() <= 0) return false;
            if (s.getDuracion() <= 0) return false;
            if (s.getTipo() == null || s.getTipo().trim().isEmpty()) return false;

            // Evitar nombres repetidos
            if (buscarServicioPorNombre(s.getNombre()) != null) return false;

            conn = ConexionDB.obtenerConexion();

            String sql = "INSERT INTO servicio (nombre, precio, duracion, tipo) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, s.getNombre());
            stmt.setInt(2, s.getPrecio());
            stmt.setInt(3, s.getDuracion());
            stmt.setString(4, s.getTipo());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;  // Registro exitoso

        } catch (SQLException e) {
            System.err.println("Error al agregar servicio: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return exito;
    }

    // Retorna una lista con todos los servicios registrados.
    public ArrayList<Servicio> listarServicios() {
        ArrayList<Servicio> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM servicio ORDER BY idServicio ASC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servicio s = new Servicio(
                        rs.getInt("idServicio"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("duracion"),
                        rs.getString("tipo")
                );
                lista.add(s);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar servicios: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return lista;
    }

    // Busca un servicio usando su ID primario.
    public Servicio buscarServicioPorId(int idServicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio s = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM servicio WHERE idServicio = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServicio);

            rs = stmt.executeQuery();

            if (rs.next()) {
                s = new Servicio(
                        rs.getInt("idServicio"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("duracion"),
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar servicio por ID: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return s;
    }

    // Actualiza la información de un servicio existente.
    public boolean actualizarServicio(Servicio s) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            // Validaciones básicas
            if (s.getNombre().trim().isEmpty()) return false;
            if (s.getPrecio() <= 0) return false;
            if (s.getDuracion() <= 0) return false;

            conn = ConexionDB.obtenerConexion();

            String sql = "UPDATE servicio SET nombre = ?, precio = ?, duracion = ?, tipo = ? WHERE idServicio = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, s.getNombre());
            stmt.setInt(2, s.getPrecio());
            stmt.setInt(3, s.getDuracion());
            stmt.setString(4, s.getTipo());
            stmt.setInt(5, s.getIdServicio());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true; // Actualización exitosa

        } catch (SQLException e) {
            System.err.println("Error al actualizar servicio: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return exito;
    }

    // Elimina un servicio del sistema según su ID.
    // Retorna true si la operación se realizó correctamante.
    public boolean eliminarServicio(int idServicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            conn = ConexionDB.obtenerConexion();

            String sql = "DELETE FROM servicio WHERE idServicio = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServicio);

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true; // Eliminación confirmada

        } catch (SQLException e) {
            System.err.println("Error al eliminar servicio: " + e.getMessage());
        } finally {
            // Liberar recursos
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return exito;
    }

    // Método no implementado generado por NetBeans.
    public Servicio buscarServicio(int idServicio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
