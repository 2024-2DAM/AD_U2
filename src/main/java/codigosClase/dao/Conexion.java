package codigosClase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    /**
     * Se conecta a una base de datos, devolviendo dicha conexión o null si ha habido algún problema
     *
     * @return
     */
    public static Connection conectar() throws SQLException {
        String user = "root";
        String pass = "Sandia4you";
        String url = "jdbc:mysql://localhost:3306/escuela?useSSL=false";
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }


    public static boolean crearTablas() {
        String sql = "create table if not exists profesorado " +
                "(id varchar(50) primary key," +
                "nombre varchar(50) not null," +
                "departamento varchar(50));";
        try(Connection c = conectar()){
            Statement st = c.createStatement();
            st.executeUpdate(sql);

            //Sentencia SQL para crear tabla alumnado
            String sqlAl = "create table if not exists alumnado " +
                    "(nia varchar(50) primary key," +
                    "nombre varchar(50) not null," +
                    "edad int," +
                    "idtutor varchar(50)," +
                    "foreign key (idtutor) references profesorado(id) );";
            st = c.createStatement();
            st.executeUpdate(sqlAl);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
