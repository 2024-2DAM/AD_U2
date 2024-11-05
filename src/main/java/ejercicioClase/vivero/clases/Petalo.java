package ejercicioClase.vivero.clases;

import java.util.Objects;

public class Petalo {

    private int id;
    private double longitud;

    public Petalo(int id, double longitud) {
        this.id = id;
        this.longitud = longitud;
    }
    public Petalo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Petalo petalo = (Petalo) o;
        return id == petalo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " - " + longitud;
    }
}
