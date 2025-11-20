package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sofi
 * 
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/reserva_horas";
    private static final String USER = "root";
    private static final String PASS = "";
    
    // Método encargado de establecer la conexión con la base de datos MySQL.
    // Retorna un objeto Connection activo si la conexión es exitosa.

    public static Connection obtenerConexion() {

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a reserva_horas");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectarse: " + e.getMessage());
        }

        return conexion;
    }

}
