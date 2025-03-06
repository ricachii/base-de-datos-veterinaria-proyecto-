package dao;

import modelo.Especializacion;
import java.util.ArrayList;
import java.util.List;

public class EspecializacionDAO {
    private List<Especializacion> especializacionList;

    public EspecializacionDAO() {
        this.especializacionList = new ArrayList<>();
    }

    // Create
    public void agregarEspecializacion(Especializacion especializacion) {
        especializacionList.add(especializacion);
    }

    // Read
    public List<Especializacion> obtenerEspecializaciones() {
        return especializacionList;
    }

    public Especializacion buscarEspecializacionPorId(String idEspecializacion) {
        for (Especializacion especializacion : especializacionList) {
            if (especializacion.getIdEspecializacion().equals(idEspecializacion)) {
                return especializacion;
            }
        }
        return null;
    }

    // Update
    public void actualizarEspecializacion(Especializacion especializacionActualizada) {
        for (int i = 0; i < especializacionList.size(); i++) {
            Especializacion especializacion = especializacionList.get(i);
            if (especializacion.getIdEspecializacion().equals(especializacionActualizada.getIdEspecializacion())) {
                especializacionList.set(i, especializacionActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarEspecializacion(String idEspecializacion) {
        especializacionList.removeIf(especializacion -> especializacion.getIdEspecializacion().equals(idEspecializacion));
    }
}
