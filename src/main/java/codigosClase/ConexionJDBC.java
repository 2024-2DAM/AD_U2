package codigosClase;

import java.sql.*;

public class ConexionJDBC {
    public static void main(String[] args) {
        //Conexión:
        String url = "jdbc:mysql://127.0.0.1:3306/animales?useSSL=false";
        String user = "root";
        String password = "Sandia4you";

        try (Connection con = DriverManager.getConnection(url, user, password);) {

            //CREATE TABLE:
            String sql = "CREATE TABLE IF NOT EXISTS vertebrados " +
                    "(id VARCHAR(50) PRIMARY KEY," +
                    "nombre varchar(50) NOT NULL," +
                    "cantidad INT," +
                    "extinto BOOLEAN);";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);

            //INSERT:
            sql = "INSERT INTO vertebrados (id, nombre, cantidad, extinto) VALUES " +
                    "(1, 'Aguila', 92, false)";
            int filas = sentencia.executeUpdate(sql); //NO lo inserto más porque el id estaría repetido y saldría excepción
            System.out.println("He insertado " + filas + " filas");

            //UPDATE:
            sql = "UPDATE vertebrados SET extinto = true WHERE id = '1'";
            filas = sentencia.executeUpdate(sql);
            System.out.println("He actualizado " + filas + " filas");

            //DELETE:
            sql = "DELETE FROM vertebrados WHERE id = '1'";
            filas = sentencia.executeUpdate(sql);
            System.out.println("He eliminado " + filas + " filas");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}