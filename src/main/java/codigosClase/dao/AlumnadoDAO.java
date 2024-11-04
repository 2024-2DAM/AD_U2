package codigosClase.dao;

import codigosClase.clases.Alumnado;
import codigosClase.clases.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnadoDAO {
    //CRUD + otras dos (alumnado mayor de edad y alumnado entre edades)

    //Insertar en la BD

    /**
     * @param alumnado
     * @return Entero con el número de elementos insertados, o -1 si ha habido algún error
     */
    public static int insertar(Alumnado alumnado) {
        int filas = -1;
        String sql = "insert into alumnado " +
                "(nia, nombre, edad, idtutor)" +
                "values (?, ?, ?, ?)";
        try (Connection c = Conexion.conectar();) {
            PreparedStatement s = c.prepareStatement(sql);
            //1. Completo la sentencia SQL
            s.setString(1, alumnado.getNia());
            s.setString(2, alumnado.getNombre());
            s.setInt(3, alumnado.getEdad());
            s.setString(4, alumnado.getTutor().getId());

            //2. Lanzo la sentencia
            filas = s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    //Leer

    /**
     * Lee de la base de datos el alumno con el NIA indicado como parámetro. SI no existe, devuevle null
     *
     * @param nia NIA del alumnado a buscar en la BD
     * @return Alumnado con los datos de la BD, o null si no existe
     */
    public static Alumnado leer(String nia) {
        Alumnado alumnado = null;
        String sql = "select * from alumnado where nia = ?";
        try (Connection c = Conexion.conectar();) {
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, nia);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                String n = rs.getString(1); //También se puede poner el índice de la columna
                String nombre = rs.getString("nombre"); //También se podría haber puesto 2
                int edad = rs.getInt("edad");
                //LEO PROFE:
                String idTutor = rs.getString("idtutor");
                //ESTO NO: alumnado = new Alumnado(n, nombre, edad, idTutor);

                //Tengo que construir el profesor completo (no solo su id!!!)
                Profesor tutor = ProfesorDAO.leer(idTutor);
                alumnado = new Alumnado(n, nombre, edad, tutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnado;
    }

    //Actualizar

    /**
     * @param alumnado
     * @return -1 si ha habido algún error al conectarse con la BD o la sentencia estaba mal formada.
     * 0 si el alumno no existía en la BD.
     * 1 si existía y lo modifico correctamente
     */
    public static int actualizar(Alumnado alumnado) {
        int filas = -1;
        String sql = "update alumnado set nombre = ?, edad = ? where nia = ?";
        try (Connection c = Conexion.conectar()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, alumnado.getNombre());
            p.setInt(2, alumnado.getEdad());
            p.setString(3, alumnado.getNia());
            filas = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    //Eliminar
    public static int eliminar(String nia) {
        int filas = -1;
        String sql = "delete from alumnado where nia = ?";
        try (Connection c = Conexion.conectar()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nia);
            filas = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    //Devolver todes les alumnes que son mayores de edad

    /**
     * @return ArrayLIst con el alumnado mayor de edad, o vacío si no había nadie.
     */
    public static List<Alumnado> leerMayores() {
        return leerEntreEdades(18, 1000);
        /*List<Alumnado> alumnado = new ArrayList<>();
        String sql = "select * from alumnado where edad >= 18";
        try (Connection c = Conexion.conectar()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String nia = rs.getString("nia");   //también rs.getString(1)
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                alumnado.add(new Alumnado(nia, nombre, edad));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnado;*/
    }

    //Devolver todes les alumnes que tienen entre dos edades
    public static List<Alumnado> leerEntreEdades(int min, int max) {
        List<Alumnado> alumnado = new ArrayList<>();
        String sql = "select * from alumnado where edad between ? and ?";
        try (Connection c = Conexion.conectar()) {
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, min);
            s.setInt(2, max);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                String nia = rs.getString("nia");   //también rs.getString(1)
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                //TUTOR:
                String idTutor = rs.getString("idtutor");
                Profesor tutor = ProfesorDAO.leer(idTutor);
                alumnado.add(new Alumnado(nia, nombre, edad, tutor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnado;
    }
}
