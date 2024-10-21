package codigosClase;

import java.sql.*;
import java.util.Scanner;

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
/*
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
*/
            int filas = 0;
            sql = "INSERT INTO vertebrados (id, nombre, cantidad, extinto) VALUES " +
                    "(1, 'Aguila', 92, false)," +
                    " (2, 'Garrapata', 92, false);";
            //filas = sentencia.executeUpdate(sql);
            System.out.println("He insertado " + filas + " filas");

            sql = "SELECT * FROM vertebrados;";
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {  //Con .next() voy avanzando en la fila del ResultSet
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                boolean extinto = rs.getBoolean("extinto");
                System.out.println("Acabo de leer: " + id + " - " + nombre + ", " + cantidad + ", " + extinto);
            }

            // PREPARED STATEMENTS:
            // Sentencia preparada (es recomendable siempre que no pueda crear el SQL completo)
            String sqlPreparado = "SELECT nombre, cantidad FROM vertebrados WHERE cantidad > ?";

            PreparedStatement preparedStatement = con.prepareStatement(sqlPreparado);
            //Select del nombre y la cantidad de los animales que hay más de 50 de cantidad

            System.out.print("Dime la cantidad y te digo qué animales tienen más: ");
            Scanner sc = new Scanner(System.in);
            String cantidad = sc.nextLine();

            //Relleno los ? de la sentencia preparada:
            preparedStatement.setInt(1, Integer.parseInt(cantidad));

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int cant = rs.getInt("cantidad");
                System.out.println(nombre + " - " + cant);
            }


            // Animales que no estén extinguidos y que tengan más de 50 unidades, quiero el nombre solamente
            sql = "SELECT nombre FROM vertebrados WHERE cantidad > ? AND extinto = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            //Completo la sentencia preparada
            int cantid = 49;
            boolean ext = false;
            ps.setInt(1, cantid);
            ps.setBoolean(2, ext);
            rs = ps.executeQuery();
            System.out.println("RESULTADOS:");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}