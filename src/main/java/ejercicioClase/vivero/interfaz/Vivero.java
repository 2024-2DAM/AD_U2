package ejercicioClase.vivero.interfaz;

import ejercicioClase.vivero.clases.Flor;
import ejercicioClase.vivero.clases.Petalo;
import ejercicioClase.vivero.dao.Conexion;
import ejercicioClase.vivero.dao.FlorDAO;

import java.sql.SQLException;

public class Vivero {
    public static void main(String[] args) {
        //Crea tres flores: f1, f2 y f3.
        Flor f1 = new Flor(9, "rosa");
        Flor f2 = new Flor(5, "orquídea");
        Flor f3 = new Flor(21, "margarita");

        //Pon a f1 tres pétalos, a f2 dos pétalos, y ninguno a f3.
        f1.anadirPetalo(new Petalo(901, 2.3));
        f1.anadirPetalo(new Petalo(902, 2.2));
        f1.anadirPetalo(new Petalo(903, 2.4));
        f2.anadirPetalo(new Petalo(501, 4.4));
        f2.anadirPetalo(new Petalo(502, 4.9));

        //Inserta en la base de datos toda la información.
        try {
            Conexion.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
/*
        try {
            FlorDAO.insertar(f1);
        } catch (SQLException e) {
            System.err.println("Error al insertar f1: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            FlorDAO.insertar(f2);
        } catch (SQLException e) {
            System.err.println("Error al insertar f2: " + e.getMessage());
        }
        try {
            FlorDAO.insertar(f3);
        } catch (SQLException e) {
            System.err.println("Error al insertar f3: " + e.getMessage());
        }
*/
        //Lee de la base de datos toda la información y muéstrala por pantalla.
        try {
            Flor fLeida1 = FlorDAO.leer(9);
            System.out.println(fLeida1);
            Flor fLeida2 = FlorDAO.leer(5);
            System.out.println(fLeida2);
            Flor fLeida3 = FlorDAO.leer(21);
            System.out.println(fLeida3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Elimina un pétalo de f1 y actualízalo en la bd.

        //Elimina f2 de la base de datos.
        //Lee de la base de datos toda la información y muéstrala por pantalla.
        //Crea una f4 (sin pétalos) que sea de la misma especie que f1. A continuación busca y muestra por pantalla todas las flores que contengan sean de esa especie.



    }
}
