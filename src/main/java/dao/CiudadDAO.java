package dao;

import modelo.Ciudad;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    private List<Ciudad> ciudadList;

    public CiudadDAO() {
        this.ciudadList = new ArrayList<>();
    }

    // Create
    public void agregarCiudad(Ciudad ciudad) {
        ciudadList.add(ciudad);
    }

    // Read
    public List<Ciudad> obtenerCiudades() {
        return ciudadList;
    }

    public Ciudad buscarCiudadPorId(String idCiudad) {
        for (Ciudad ciudad : ciudadList) {
            if (ciudad.getIdCiudad().equals(idCiudad)) {
                return ciudad;
            }
        }
        return null;
    }

    // Update
    public void actualizarCiudad(Ciudad ciudadActualizada) {
        for (int i = 0; i < ciudadList.size(); i++) {
            Ciudad ciudad = ciudadList.get(i);
            if (ciudad.getIdCiudad().equals(ciudadActualizada.getIdCiudad())) {
                ciudadList.set(i, ciudadActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarCiudad(String idCiudad) {
        ciudadList.removeIf(ciudad -> ciudad.getIdCiudad().equals(idCiudad));
    }
}
