package ejercicioClase.vivero.interfaz;

import ejercicioClase.vivero.clases.Petalo;
import ejercicioClase.vivero.dao.Conexion;

import java.sql.SQLException;

public class Vivero {
    public static void main(String[] args) {

        /*
        Crea tres flores: f1, f2 y f3.
Pon a f1 tres pétalos, a f2 dos pétalos, y ninguno a f3.
Inserta en la base de datos toda la información.
Lee de la base de datos toda la información y muéstrala por pantalla.
Elimina un pétalo de f1 y actualízalo en la bd.
Elimina f2 de la base de datos.
Lee de la base de datos toda la información y muéstrala por pantalla.
Crea una f4 (sin pétalos) que sea de la misma especie que f1. A continuación busca y muestra por pantalla todas las flores que contengan sean de esa especie.
         */

        try {
            Conexion.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
