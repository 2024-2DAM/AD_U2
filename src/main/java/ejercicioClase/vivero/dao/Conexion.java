package ejercicioClase.vivero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static final String user = "root";
    private static final String pass = "Sandia4you";
    private static final String url = "jdbc:mysql://localhost:3306/vivero?useSSL=false";;

    public static Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }

    public static void createTables() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS flores (" +
                "id int primary key," +
                "especie varchar(100))";
        Connection c = conectar();
        Statement s = c.createStatement();
        s.executeUpdate(sql);
        sql = "CREATE TABLE IF NOT EXISTS petalos (" +
                "id int primary key," +
                "longitud double," +
                "idFlor int," +
                "foreign key (idFlor) references flores(id))";
        s.executeUpdate(sql);
        c.close();
    }

}
