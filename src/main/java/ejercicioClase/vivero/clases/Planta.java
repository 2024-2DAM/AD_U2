package ejercicioClase.vivero.clases;

public abstract class Planta {
    private int id;
    private String especie;

    public Planta(int id, String especie) {
        this.id = id;
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public String toString() {
        return id + " - " + especie;
    }
}
