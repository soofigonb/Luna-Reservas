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

public class ClienteDAO {

    // Método privado que valida el formato general de un correo electrónico.
    // Retorna true si contiene '@' y '.', caso contrario false.
    private boolean correoValido(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    // Busca un cliente que tenga un teléfono específico.
    // Este método se usa para evitar registros duplicados de teléfono.
    // Retorna un objeto Cliente si encuentra coincidencia, o null si no existe.
    public Cliente buscarClientePorTelefono(String telefono) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM cliente WHERE telefono = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefono);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar teléfono duplicado: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return c;
    }

    // Verifica si ya existe un cliente con el mismo nombre + teléfono.
    // Esto evita la duplicidad de registros intencionales.
    // Retorna el cliente si existe, o null si no está registrado.
    public Cliente buscarClienteDuplicado(String nombre, String telefono) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM cliente WHERE nombre = ? AND telefono = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al verificar duplicado: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return c;
    }

    // Inserta un nuevo cliente en la base de datos.
    // Realiza validación de campos, formato de correo y duplicados.
    // Retorna true si se insertó correctamente.
    public boolean agregarCliente(Cliente c) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            // Validaciones básicas
            if (c.getNombre() == null || c.getNombre().trim().isEmpty()) return false;
            if (c.getTelefono() == null || c.getTelefono().trim().isEmpty()) return false;
            if (c.getCorreo() == null || c.getCorreo().trim().isEmpty()) return false;

            // Validación de correo electrónico
            if (!correoValido(c.getCorreo())) return false;

            // Validación de teléfono único
            if (buscarClientePorTelefono(c.getTelefono()) != null) return false;

            // Duplicidad nombre + teléfono
            if (buscarClienteDuplicado(c.getNombre(), c.getTelefono()) != null) return false;

            conn = ConexionDB.obtenerConexion();
            String sql = "INSERT INTO cliente (nombre, telefono, correo) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getTelefono());
            stmt.setString(3, c.getCorreo());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return exito;
    }

    // Retorna una lista completa de todos los clientes registrados en la BD.
    // Cada fila de la tabla se transforma en un objeto Cliente.
    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM cliente ORDER BY idCliente ASC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
                lista.add(cli);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return lista;
    }

    // Busca un cliente específico por su ID.
    // Retorna el objeto Cliente si existe, o null si no se encuentra.
    public Cliente buscarClientePorId(int idCliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "SELECT * FROM cliente WHERE idCliente = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar cliente por ID: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return c;
    }

    // Actualiza los datos de un cliente existente en la tabla.
    // Solo modifica nombre, teléfono y correo.
    // Retorna true si la operación fue exitosa.
    public boolean actualizarCliente(Cliente c) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            if (c.getNombre().trim().isEmpty()) return false;
            if (c.getTelefono().trim().isEmpty()) return false;
            if (c.getCorreo().trim().isEmpty()) return false;

            if (!correoValido(c.getCorreo())) return false;

            conn = ConexionDB.obtenerConexion();
            String sql = "UPDATE cliente SET nombre = ?, telefono = ?, correo = ? WHERE idCliente = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getTelefono());
            stmt.setString(3, c.getCorreo());
            stmt.setInt(4, c.getIdCliente());

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }
        return exito;
    }

    // Elimina un cliente de la base de datos según su ID.
    // Retorna true si se eliminó correctamente.
    public boolean eliminarCliente(int idCliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;

        try {
            conn = ConexionDB.obtenerConexion();
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);

            int filas = stmt.executeUpdate();
            if (filas > 0) exito = true;

        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) {}
            try { if (conn != null) conn.close(); } catch (SQLException ex) {}
        }

        return exito;
    }

    // Método autogenerado por NetBeans, no utilizado.
    public Object buscarCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
