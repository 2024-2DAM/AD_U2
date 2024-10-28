package codigosClase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    /**
     * Se conecta a una base de datos, devolviendo dicha conexión o null si ha habido algún problema
     * @return
     */
    public static Connection conectar() throws SQLException {
        String user = "root";
        String pass = "Sandia4you";
        String url = "jdbc:mysql://localhost:3306/escuela?useSSL=false";
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }

    public static boolean eliminarTabla(){
        boolean result = false;
        String sql = "drop table if exists alumnado";
        try (Connection c = conectar()){
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean crearTablas(){
        boolean result = false;
        String sql = "create table if not exists alumnado " +
                "(nia varchar(50) primary key," +
                "nombre varchar(50) not null," +
                "edad int);";   //TODO quiero que la edad pueda ser null
        try (Connection c = conectar()){
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            //result = false;   //No hace falta
        }
        return result;
    }
}
