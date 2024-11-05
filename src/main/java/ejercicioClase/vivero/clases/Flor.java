package ejercicioClase.vivero.clases;

import java.util.ArrayList;
import java.util.List;

public class Flor extends Planta {
    private List<Petalo> petalos = new ArrayList<>();

    public Flor(int id, String especie, List<Petalo> petalos) {
        super(id, especie);
        this.petalos = petalos;
    }

    public Flor(int id, String especie) {
        super(id, especie);
    }

    public List<Petalo> getPetalos() {
        return petalos;
    }

    public int anadirPetalo(Petalo petalo) {
        petalos.add(petalo);
        return petalos.size();
    }

    public void quitarPetalo(int id){
        Petalo eliminar = new Petalo(id);
        petalos.remove(eliminar);
    }

    @Override
    public String toString() {
        String ret = super.toString() + "\n";
        for (Petalo petalo : petalos) {
            ret += "\t" + petalo.toString() + "\n";
        }
        return ret;
    }
}
