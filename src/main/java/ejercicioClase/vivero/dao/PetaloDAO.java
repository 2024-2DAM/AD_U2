package ejercicioClase.vivero.dao;

import ejercicioClase.vivero.clases.Petalo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        c.close();
        return petalo;
    }

    public static List<Petalo> leerPorIdFlor(int idFlor) throws SQLException {
        List<Petalo> petalos = new ArrayList<>();
        String sql = "SELECT * FROM petalos WHERE idFlor = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, idFlor);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int id = rs.getInt("id");
            double longitud = rs.getDouble("longitud");
            Petalo p = new Petalo(id, longitud);
            petalos.add(p);
        }
        return petalos;
    }

    //Esto está mucho peor que la anterior.
    //Los Statement se deberían dejar reservados para cuando tengo una sentencia SQL
    // terminada, que no dependa de otros valores. Así evito inyecciones de código.
    // Si necesito valores externos (como el id) debería ser PreparedStatement.
    public static Petalo leerV2(int id) throws SQLException {
        Petalo petalo = null;
        String sql = "select * from petalos where id = " + id;
        Connection c = Conexion.conectar();
        Statement ps = c.createStatement();
        ResultSet rs = ps.executeQuery(sql);
        if (rs.next()) {
            petalo = new Petalo(id, rs.getFloat("longitud"));
        }
        return petalo;
    }

    public static void eliminar(int id) throws SQLException {
        String sql = "delete from petalos where id = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        c.close();
    }

    public static void actualizar(Petalo p) throws SQLException {
        String sql = "update petalos set longitud = ? where id = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setDouble(1, p.getLongitud());
        ps.setInt(2, p.getId());
        ps.executeUpdate();
        c.close();
    }
}
