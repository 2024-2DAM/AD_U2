package ejercicioClase.vivero.dao;

import ejercicioClase.vivero.clases.Flor;

import java.sql.Connection;
import java.sql.SQLException;

public class FlorDAO {
    public static void insertar(Flor f) throws SQLException {
        String sql = "INSERT INTO flor (nombre, descripcion, tipo) VALUES (?,?,?)";
        Connection c = Conexion.conectar();

    }
}
