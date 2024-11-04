package codigosClase.dao;

import codigosClase.clases.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {

    public static int insertar(Profesor profesor) {
        String sql = "insert into profesorado (id, nombre, departamento)" +
                "values (?, ?, ?)";
        try (Connection c = Conexion.conectar();) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, profesor.getId());
            p.setString(2, profesor.getNombre());
            p.setString(3, profesor.getDepartamento());
            return p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Profesor leer(String id) {
        Profesor p = null;
        String sql = "select * from profesorado where id = ?";
        try (Connection c = Conexion.conectar()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            //Hago un if porque el select me va a devolver 0 o 1 resultados,
            // es imposible que devuelva más porque la consulta es por el id que
            // es la primary key.
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String dpto = rs.getString("departamento");
                p = new Profesor(id, nombre, dpto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static int actualizar(Profesor profesor) {
        //TODO
        return -1;
    }

    public static int eliminar(String id) {
        //TODO
        return -1;
    }
}
