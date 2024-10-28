package codigosClase.mains;

import codigosClase.clases.Alumnado;
import codigosClase.dao.AlumnadoDAO;
import codigosClase.dao.Conexion;

import java.sql.SQLException;

public class MainAlumnado {
    public static void main(String[] args) {

        Conexion.crearTablas();



        /*
        Alumnado a1 = new Alumnado("123", "Luz", 22);
        Alumnado a2 = new Alumnado("456", "Mar", 17);
        Alumnado a3 = new Alumnado("789", "Juan", 30);
        Alumnado a4 = new Alumnado("159", "Pedro", 15);

       // Conexion.eliminarTablas();
        Conexion.crearTablas();

        System.exit(1);

        AlumnadoDAO.insertar(a1);
        AlumnadoDAO.insertar(a2);
        AlumnadoDAO.insertar(a3);
        AlumnadoDAO.insertar(a4);

        //Pruebo actualizar
        a4.setNombre("NUEVO");
        a4.setEdad(16);
        AlumnadoDAO.actualizar(a4);

        //Pruebo leer por nia
        System.out.println(AlumnadoDAO.leer("159"));

        //Pruebo leer +18
        System.out.println(AlumnadoDAO.leerMayores());

        //Pruebo leer entre 17 y 23
        System.out.println(AlumnadoDAO.leerEntreEdades(17,23));

        //Pruebo eliminar
        AlumnadoDAO.eliminar("123");*/

    }
}
