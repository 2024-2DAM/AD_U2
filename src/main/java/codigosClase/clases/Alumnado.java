package codigosClase.clases;

public class Alumnado {
    private String nia;
    private String nombre;
    private int edad;
    //private Profesor tutor;

    public Alumnado(String nia, String nombre, int edad) {
        this.nia = nia;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nia + " - " + nombre + " - " + edad;
    }
}

