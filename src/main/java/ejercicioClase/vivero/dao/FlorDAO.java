package ejercicioClase.vivero.dao;

import ejercicioClase.vivero.clases.Flor;
import ejercicioClase.vivero.clases.Petalo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlorDAO {
    public static void insertar(Flor f) throws SQLException {
        String sql = "INSERT INTO flores (id, especie) VALUES (?,?)";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, f.getId());
        ps.setString(2, f.getEspecie());
        ps.executeUpdate();
        c.close();
        //Cada vez que meto una flor, voy a meter todos sus pétalos:
        for (Petalo p : f.getPetalos()) {
            PetaloDAO.insertar(p, f.getId());
        }
    }

    public static Flor leer(int id) throws SQLException {
        Flor f = null;
        String sql = "SELECT * FROM flores WHERE id = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            //EL SELECT me ha devuelto 1 resultados
            String especie = rs.getString("especie");
            f = new Flor(id, especie);
            //AHORA LOS PÉTALOS!!!
            f.setPetalos(PetaloDAO.leerPorIdFlor(id));
        } else {
            //El SELECT no me ha devuelto nada
        }
        return f;
    }

    public static void eliminar(Flor f) throws SQLException {
       //Primero tengo que eliminar sus pétalos (si no me
        // dará error)
        for(Petalo p: f.getPetalos()){
            PetaloDAO.eliminar(p.getId());
        }

        String sql = "DELETE FROM flores WHERE id = ?";
        Connection c = Conexion.conectar();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, f.getId());
        ps.executeUpdate();
        c.close();
    }
}
