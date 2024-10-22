package codigosClase.dao;

import codigosClase.clases.Alumnado;

import java.util.List;

public class AlumnadoDAO {
    //CRUD + otras dos (alumnado mayor de edad y alumnado entre edades)

    //Insertar en la BD
    public static int insertar(Alumnado alumnado) {
        //TODO
        return -1;
    }

    //Leer
    public static Alumnado leer(String nia){
        //TODO
        return null;
    }

    //Actualizar
    public static int actualizar(Alumnado alumnado) {
        //TODO
        return -1;
    }

    //Eliminar
    public static int eliminar(String nia){
        //TODO
        return -1;
    }

    //Devolver todes les alumnes que son mayores de edad
    public static List<Alumnado> leerMayores(){
        //TODO
        return null;
    }

    //Devolver todes les alumnes que tienen entre dos edades
    public static List<Alumnado> leerEntreEdades(int min, int max){
        //TODO
        return null;
    }
}
