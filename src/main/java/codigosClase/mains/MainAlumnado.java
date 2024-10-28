package codigosClase.mains;

import codigosClase.clases.Alumnado;
import codigosClase.dao.AlumnadoDAO;
import codigosClase.dao.Conexion;

public class MainAlumnado {
    public static void main(String[] args) {
        Alumnado a1 = new Alumnado("123", "Luz", 22);
        Alumnado a2 = new Alumnado("456", "Mar", 17);
        Alumnado a3 = new Alumnado("789", "Juan", 30);
        Alumnado a4 = new Alumnado("159", "Pedro", 15);

        Conexion.eliminarTabla();
        Conexion.crearTablas();
        AlumnadoDAO.insertar(a1);
        AlumnadoDAO.insertar(a2);
        AlumnadoDAO.insertar(a3);
        AlumnadoDAO.insertar(a4);

        //Pruebo actualizar
        a4.setNombre("NUEVO");
        a4.setEdad(16);
        AlumnadoDAO.actualizar(a4);

        //Pruebo eliminar

        //Pruebo leer todo

        //Pruebo leer +18

        //Pruebo leer entre 17 y 23

    }
}
