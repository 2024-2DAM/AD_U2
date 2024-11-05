package ejercicioClase.vivero.dao;

import ejercicioClase.vivero.clases.Petalo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetaloDAO {
    public static void insertar(Petalo p, int idFlor) throws SQLException {






















        String sql = "insert into petalos (id, longitud, idFlor) values (?, ?, ?)";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setDouble(2, p.getLongitud());
        ps.setInt(3, idFlor);
        ps.executeUpdate();
    }

    public static Petalo leer(int id) throws SQLException {
        Petalo petalo = null;
        String sql = "select * from petalos where id = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            petalo = new Petalo(id, rs.getFloat("longitud"));
        }
        return petalo;
    }
}
