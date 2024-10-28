package codigosClase.clases;

public class Profesor {
    private String id;
    private String nombre;
    private String departamento;

    public Profesor(String id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return id + " " + nombre + ". Dpto: " + departamento;
    }

    public String getId() {
        return id;
    }
}
